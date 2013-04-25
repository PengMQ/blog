package com.mengqiu.service;


import com.mengqiu.domain.Email;
import com.mengqiu.service.Email.EmailGenerator;
import org.junit.Before;
import org.junit.Test;
import org.jvnet.mock_javamail.Mailbox;

import javax.mail.Message;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SendEmailTest {
    private EmailGenerator.EmailSender emailSender;

    @Before
    public void setUp() throws Exception {
        emailSender = new EmailGenerator.EmailSender();

    }

    @Test
    public void ShouldSendEmailWithoutException() throws Exception {

        String emailSubject = "test email subject";
        String emailBody = "test email body.";
        Email email = new Email("test.to@163.com", "test.from@163.com", emailSubject, emailBody);
        emailSender.sendEmail(email);

        List<Message> inbox = Mailbox.get("test.to@163.com");
        assertThat(inbox.size(), is(1));
        assertThat(inbox.get(0).getSubject(), is("test email subject"));
        assertThat(inbox.get(0).getContent().toString(), is("test email body."));

    }
}
