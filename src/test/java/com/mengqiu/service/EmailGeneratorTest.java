package com.mengqiu.service;


import com.mengqiu.domain.User;
import com.mengqiu.service.Email.EmailGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class EmailGeneratorTest {

    private EmailGenerator emailGenerator;

    @Before
    public void setUp() throws Exception {
        emailGenerator = new EmailGenerator();
    }

    @Test
    public void should_generate_subject_from_given_user_info() {
        User user = new User("name");
        String emailSubject = emailGenerator.generateSubject(user);
        assertThat(emailSubject, is("welcome name to Blog"));
    }

    @Test
    public void should_generate_content_by_template() throws Exception {



    }
}
