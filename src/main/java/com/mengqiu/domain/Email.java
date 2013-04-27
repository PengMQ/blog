package com.mengqiu.domain;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Email {
    private final String fromAddress;
    private final String toAddress;

    private FreeMarkerConfigurer freeMarkerConfig;

    @Required
    @Autowired
    public void setFreeMarkerConfig(FreeMarkerConfigurer freeMarkerConfig) {
        this.freeMarkerConfig = freeMarkerConfig;

    }

    public Email(String fromAddress, String toAddress) {
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
    }
    public String getFromAddress() {
        return fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }



    public String getEmailSubject(User user) {
        String userName = user.getName();
        return "Welcome " + userName + " to Blog";
    }

    public String getEmailContent(User user) throws IOException, TemplateException {

        String emailContent;
        Template emailContentTemplate = freeMarkerConfig.getConfiguration().getTemplate("emailTemplate/emailTemplate.ftl");
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", user.getName());
        emailContent = FreeMarkerTemplateUtils.processTemplateIntoString(emailContentTemplate, map);
        return emailContent;


    }
}
