package com.cy.study.beautify;

import com.cy.study.beautify.config.MyConfiguration;
import com.cy.study.beautify.service.PayService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试
 *
 * @author cy
 */
public class BeautifyTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        PayService weChatService = (PayService) context.getBean("WeChat");
        PayService alipayService = (PayService) context.getBean("Alipay");
        weChatService.execute();
        alipayService.execute();
    }
}
