package com.mengqiu.domain;

public class Email {
    private final String toAddress;
    private final String fromAddress;
    private final String emailSubject;
    private final String emailContent;

    public Email(String toAddress, String fromAddress, String emailSubject, String emailContent) {
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
        this.emailSubject = emailSubject;
        this.emailContent = emailContent;
    }

    public String getToAddress() {
        return toAddress;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public String getEmailContent() {
        return emailContent;
    }
}
