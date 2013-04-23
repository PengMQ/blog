package com.mengqiu.service;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {

    private  String userName;
    private  String passWord;

    public MyAuthenticator(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(userName, passWord);

    }
}
