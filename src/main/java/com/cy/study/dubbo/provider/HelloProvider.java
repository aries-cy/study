package com.cy.study.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<String> list = new ArrayList<>();
        list.add("a");

        Map<String,String> map = new HashMap<>();
    }

}
