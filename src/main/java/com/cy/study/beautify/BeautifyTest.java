package com.cy.study.beautify;

import com.cy.study.beautify.config.MyConfiguration;
import com.cy.study.beautify.service.PayService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * 测试
 *
 * @author cy
 */
public class BeautifyTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);

        Map<String, PayService> map = context.getBeansOfType(PayService.class);

        PayService weChatService = (PayService) context.getBean("WeChat");
        PayService alipayService = (PayService) context.getBean("Alipay");
        weChatService.execute();
        alipayService.execute();
    }
}
