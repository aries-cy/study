package com.cy.study.model.email;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 邮件发送人
 *
 * @author cy
 */
public class EmailAuthCreator extends Authenticator {

    private String username;
    private String password;

    public EmailAuthCreator(EmailConfigInfo info) {
        this.username = info.getUsername();
        this.password = info.getPassword();
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username,password);
    }
}
