package com.cy.study.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 服务提供者
 *
 * @author cy
 */
public class HelloProvider {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/provider.xml"});
        context.start();
        System.out.println(">>>>>启动成功");
        System.in.read();
    }

}
