package com.mengqiu.service.Email;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class HostAuthenticator extends Authenticator {

    private  String userName;
    private  String passWord;

    public HostAuthenticator(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(userName, passWord);

    }
}
