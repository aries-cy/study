package com.cy.study.dubbo.aop;

import com.alibaba.dubbo.common.URL;
import com.cy.study.dubbo.spi.Robot;

/**
 * dubbo aop的实现
 *
 * @author cy
 */
public class RobotWrapper2 implements Robot {

    private Robot robot;

    public RobotWrapper2(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void sayHello(URL url) {
        System.out.println("-----<<before>>----");
        robot.sayHello(url);
        System.out.println("-----<<after>>----");
    }

    @Override
    public void sayHello() {
        System.out.println("-----<<before>>----");
        robot.sayHello();
        System.out.println("-----<<after>>----");
    }
}
