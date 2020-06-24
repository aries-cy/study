package com.cy.study.model.email;

import com.sun.mail.util.MailSSLSocketFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * 邮件配置地址
 *
 * @author cy
 */
@Data
@Component
@ConfigurationProperties(prefix = "email")
public class EmailConfigInfo {

    /** 邮件用户名 **/
    private String username;
    /** 邮件密码 **/
    private String password;
    /** 邮件IP **/
    private String mailIp;
    /** 邮件PORT **/
    private String mailPort;

    public Properties getProperties() throws GeneralSecurityException {
        Properties properties = new Properties();
        properties.put("mail.smtp.host",mailIp);
        properties.put("mail.smtp.port",mailPort);
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.transport.protocol","stmp");
        MailSSLSocketFactory mailSSLSocketFactory = new MailSSLSocketFactory();
        mailSSLSocketFactory.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.socketFactory",mailSSLSocketFactory);
        return properties;
    }

}
