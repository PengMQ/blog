package com.mengqiu.controller;


import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HomePageControllerTest {

    private HomePageController homePageController;

    @Before
    public void setUp() throws Exception {
        homePageController = new HomePageController();

    }

    @Test
    public void shouldRenderHomePage() throws Exception {
        ModelAndView modelAndView = homePageController.renderHomePage();
        assertThat(modelAndView.getViewName(), is("homepage/index"));

    }
}
