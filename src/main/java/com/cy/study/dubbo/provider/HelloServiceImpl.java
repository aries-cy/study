package com.cy.study.dubbo.provider;

import com.cy.study.dubbo.api.HelloService;

/**
 * 服务提供者实现服务接口
 *
 * @author cy
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        String str = "hello "+name;
        return str;
    }


}
