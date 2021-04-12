//package com.cy.study.dubbo.spi.ioc;
//
//import com.alibaba.dubbo.common.URL;
//import com.cy.study.dubbo.spi.Car;
//import com.cy.study.dubbo.spi.Robot;
//
//
///**
// * IOC测试
// *
// * @author cy
// */
//public class BigCar implements Car {
//
//    private Robot robot;
//
//
//    //注入点
//    public void setRobot(Robot robot) {
//        this.robot = robot;
//    }
//
//
//    @Override
//    public void run(URL url) {
//        System.out.println("------bigCar-------run");
//        robot.sayHello(url);
//        System.out.println("------bigCar-------stop");
//    }
//}
