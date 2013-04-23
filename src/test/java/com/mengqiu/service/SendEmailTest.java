package com.mengqiu.service;


import org.junit.Before;
import org.junit.Test;
import org.jvnet.mock_javamail.Mailbox;

import javax.mail.Message;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SendEmailTest {
    private EmailSender emailSender;

    @Before
    public void setUp() throws Exception {
        emailSender = new EmailSender();

    }

    @Test
    public void ShouldSendEmailWithoutException() throws Exception {

        String emailSubject = "test email subject";
        String emailBody = "test email body.";
        emailSender.sendEmail("test.to@163.com", "test.from@163.com", emailSubject, emailBody);

        List<Message> inbox = Mailbox.get("test.to@163.com");
        assertThat(inbox.size(), is(1));
        assertThat(inbox.get(0).getSubject(), is("test email subject"));
        assertThat(inbox.get(0).getContent().toString(), is("test email body."));

    }
}
