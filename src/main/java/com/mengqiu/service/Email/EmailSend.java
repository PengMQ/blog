package com.mengqiu.service.Email;


import com.mengqiu.domain.Email;
import com.mengqiu.domain.User;
import freemarker.template.TemplateException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public  class EmailSend {


    public static final String MAIL_HOST = "smtp.163.com";
    public static final String USER_NAME = "pmqnana@163.com";
    public static final String PASS_WORD = "2wsx@WSX";




    public void send(Email email, User user) throws AddressException {

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", MAIL_HOST);
        properties.put("mail.smtp.auth", true);

        HostAuthenticator hostAuthenticator = new HostAuthenticator(USER_NAME, PASS_WORD);
        Session session = Session.getDefaultInstance(properties, hostAuthenticator);

        try {
            MimeMessage message = createMimeMessage(email, session, user);
            Transport.send(message);
            System.out.print("your email has been sent");

        } catch (MessagingException e) {
            throw new RuntimeException(e); //need to throw other exceptions
        } catch (TemplateException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private MimeMessage createMimeMessage(Email email, Session session, User user) throws MessagingException, IOException, TemplateException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(email.getFromAddress()));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getToAddress()));
        message.setSubject(email.getEmailSubject(user), "utf-8");
        message.setText(email.getEmailContent(user));
        return message;
    }
}
