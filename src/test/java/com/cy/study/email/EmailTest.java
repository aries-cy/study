package com.cy.study.email;

import com.cy.study.model.email.EmailConfigInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 邮件测试
 *
 * @author cy
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void springbootConfigTest(){
        EmailConfigInfo emailConfigInfo = context.getBean(EmailConfigInfo.class);
        System.out.println(emailConfigInfo.getUsername()+"  "+ emailConfigInfo.getPassword());
    }

}
