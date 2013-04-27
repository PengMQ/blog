package com.mengqiu.service;


import com.mengqiu.domain.User;
import com.mengqiu.service.Email.EmailGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.matchers.JUnitMatchers.containsString;

@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:testApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailGeneratorTest {

    @Autowired
    private EmailGenerator emailGenerator;
    FreeMarkerConfigurer freeMarkerConfig;

    @Before
    public void setUp() throws Exception {
//        emailGenerator = new EmailGenerator();
//        freeMarkerConfig = new FreeMarkerConfigurer();
//        freeMarkerConfig = new FreeMarkerConfigurer();
//        Configuration configuration = new Configuration();
//        configuration.setDirectoryForTemplateLoading(new File("/Users/twer/Documents/Java/spring/projects/blog/src/main/webapp/WEB-INF/freemarker"));
//        freeMarkerConfig.setConfiguration(configuration);
//        emailGenerator.setFreeMarkerConfig(freeMarkerConfig);
    }

    @Test
    public void should_generate_subject_from_given_user_info() {
        User user = new User("nana");
        String emailSubject = emailGenerator.generateSubject(user);
        assertThat(emailSubject, is("welcome nana to Blog"));
    }

    @Test
    public void should_generate_content_by_template() throws Exception {
        User user = new User("nana");

        String emailContent = emailGenerator.generateContent(user);
        assertThat(emailContent, containsString("亲爱的nana:"));



    }
}
