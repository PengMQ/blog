package com.mengqiu.service;


import com.mengqiu.domain.Email;
import com.mengqiu.domain.User;
import com.mengqiu.service.Email.EmailSend;
import freemarker.template.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jvnet.mock_javamail.Mailbox;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.Message;
import java.io.File;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:testApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailSendTest {
    FreeMarkerConfigurer freeMarkerConfig;
    EmailSend emailSend;
    User user;
    Email email;

    @Before
    public void setUp() throws Exception {
        emailSend = new EmailSend();
        user = new User("nana");
        email = new Email("from@163.com", "to@163.com");

        freeMarkerConfig = new FreeMarkerConfigurer();
        freeMarkerConfig = new FreeMarkerConfigurer();
        Configuration configuration = new Configuration();
        configuration.setDirectoryForTemplateLoading(new File("/Users/twer/Documents/Java/spring/projects/blog/src/main/webapp/WEB-INF/freemarker"));
        freeMarkerConfig.setConfiguration(configuration);
        email.setFreeMarkerConfig(freeMarkerConfig);

    }

    @Test
    public void ShouldSendEmailWithoutException() throws Exception {
        emailSend.send(email, user);

        List<Message> inbox = Mailbox.get("to@163.com");
        assertThat(inbox.size(), is(1));
        assertThat(inbox.get(0).getSubject(), is("Welcome nana to Blog"));
        assertThat(inbox.get(0).getContent().toString(), containsString("亲爱的nana:"));

    }
}
