//package com.cy.study.dubbo.spi;
//
//import com.alibaba.dubbo.common.URL;
//import com.alibaba.dubbo.common.extension.ExtensionLoader;
//import org.junit.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.ServiceLoader;
//
///**
// * SpiTest
// *
// * @author cy
// */
//public class SpiTest {
//
//    @Test
//    public void myRobotsSayHello(){
//        ExtensionLoader<Car> extensionLoader =
//                ExtensionLoader.getExtensionLoader(Car.class);
//        System.out.println("Dubbo IOC");
//
//        Map<String,String> map = new HashMap<>();
//        map.put("robot","optimusPrime");
//        URL url = new URL("","",1,map);
//
//        Car bigCar = extensionLoader.getExtension("bigCar");
//        bigCar.run(url);
//
//    }
//
//    /**
//     * dubbo SPI
//     * @throws Exception Exception
//     */
//    @Test
//    public void dubboSayHello() throws Exception {
//        ExtensionLoader<Robot> extensionLoader =
//                ExtensionLoader.getExtensionLoader(Robot.class);
//        System.out.println("Dubbo SPI");
//        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
//        optimusPrime.sayHello();
//        System.out.println("------分割线----");
//        Robot bumblebee = extensionLoader.getExtension("bumblebee");
//        bumblebee.sayHello();
//    }
//
//    /**
//     * Java SPI
//     *
//     * @throws Exception 异常
//     */
//    @Test
//    public void javaSayHello() throws Exception {
//        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
//        System.out.println("Java SPI");
//        serviceLoader.forEach(Robot::sayHello);
//    }
//
//}
