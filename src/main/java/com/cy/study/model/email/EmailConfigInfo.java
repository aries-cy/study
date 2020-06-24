package com.cy.study.model.email;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 邮件配置地址
 *
 * @author cy
 */
@Data
@Component
@ConfigurationProperties(prefix = "email")
public class EmailConfigInfo {

    private String username;
    private String password;

}
