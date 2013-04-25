package com.mengqiu.service.Email;


import com.mengqiu.domain.Email;
import com.mengqiu.domain.User;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailGenerator {
    public String generateSubject(User user) {
        String userName = user.getName();
        return "welcome " + userName + " to Blog";
    }

    public static class EmailSender {


        public static final String MAIL_HOST = "smtp.163.com";
        public static final String USER_NAME = "pmqnana@163.com";
        public static final String PASS_WORD = "2wsx@WSX";


        public void sendEmail(Email email) throws AddressException {

            Properties properties = System.getProperties();

            properties.put("mail.smtp.host", MAIL_HOST);
            properties.put("mail.smtp.auth", true);

            hostAuthenticator hostAuthenticator = new hostAuthenticator(USER_NAME, PASS_WORD);
            Session session = Session.getDefaultInstance(properties, hostAuthenticator);


            try {
                MimeMessage message = createMimeMessage(email, session);

                Transport.send(message);
                System.out.print("your email has been sent");

            } catch (MessagingException e) {
                throw new RuntimeException(e); //need to throw other exceptions
            }


        }

        private MimeMessage createMimeMessage(Email email, Session session) throws MessagingException {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email.getFromAddress()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getToAddress()));
            message.setSubject(email.getEmailSubject(), "utf-8");
            message.setText(email.getEmailContent());
            return message;
        }
    }
}
