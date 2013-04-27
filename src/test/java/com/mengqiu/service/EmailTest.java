package com.mengqiu.service;

import com.mengqiu.domain.Email;
import com.mengqiu.domain.User;
import freemarker.template.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:testApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailTest {

    private Email email;
    FreeMarkerConfigurer freeMarkerConfig;

//    @Autowired
//    FreeMarkerConfigurer freeMarkerConfigurer;
    User user;


    @Before
    public void setUp() throws Exception {
        email = new Email("from@163.com", "to@163.com");
        user = new User("nana");

        freeMarkerConfig = new FreeMarkerConfigurer();
        freeMarkerConfig = new FreeMarkerConfigurer();
        Configuration configuration = new Configuration();
        configuration.setDirectoryForTemplateLoading(new File("/Users/twer/Documents/Java/spring/projects/blog/src/main/webapp/WEB-INF/freemarker"));
        freeMarkerConfig.setConfiguration(configuration);
        email.setFreeMarkerConfig(freeMarkerConfig);

    }

    @Test
    public void shouldGetEmailFromAddress() throws Exception {
        assertThat(email.getFromAddress(), is("from@163.com"));
    }

    @Test
    public void shouldGetEmailSubject() throws Exception {
        assertThat(email.getEmailSubject(user), containsString("nana"));
    }

    @Test
    public void shouldGetEmailContent() throws Exception {
        assertThat(email.getEmailContent(user),containsString("nana"));
    }
}
