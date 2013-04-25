package com.mengqiu.service.Email;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class hostAuthenticator extends Authenticator {

    private  String userName;
    private  String passWord;

    public hostAuthenticator(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(userName, passWord);

    }
}
