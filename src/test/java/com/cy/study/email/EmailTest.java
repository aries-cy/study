package com.cy.study.email;

import com.cy.study.model.email.EmailConfigInfo;
import com.cy.study.model.email.EmailInfo;
import com.cy.study.util.EmailSendUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

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

    @Test
    public void sendEmail(){
        EmailInfo info = new EmailInfo();
        info.setTitle("哈哈哈哈");
        info.setContent("哼唧");
        info.setReceiveAddresses(Arrays.asList(new String[]{"aries_caoyang@163.com"}));
        EmailSendUtil.sendHtmlEmail(info);
    }

}
