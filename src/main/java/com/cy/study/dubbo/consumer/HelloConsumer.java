package com.cy.study.dubbo.consumer;

import com.cy.study.dubbo.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 服务消费者
 *
 * @author cy
 */
public class HelloConsumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"META-INF/consumer.xml"});
        context.start();
        // 获取远程服务代理
        HelloService helloService = (HelloService)context.getBean("helloService");
        // 执行远程方法
        String hello = helloService.sayHello("world");
        // 显示调用结果
        System.out.println( hello );
    }

}
