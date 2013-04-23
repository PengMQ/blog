package com.mengqiu.service;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {


    public static final String MAIL_HOST = "smtp.163.com";
    public static final String USER_NAME = "pmqnana@163.com";
    public static final String PASS_WORD = "2wsx@WSX";


    public void sendEmail(String toAddress, String fromAddress, String emailSubject, String emailContent) throws AddressException {

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", MAIL_HOST);
        properties.put("mail.smtp.auth", true);

        MyAuthenticator myAuthenticator = new MyAuthenticator(USER_NAME, PASS_WORD);
        Session session = Session.getDefaultInstance(properties, myAuthenticator);

        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(fromAddress));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setSubject(emailSubject, "utf-8");
            message.setText(emailContent);

            Transport.send(message);
            System.out.print("your email has been sent");

        } catch (MessagingException e) {
            throw new RuntimeException(e); //need to throw other exceptions
        }


    }
}
