package com.cy.study.dubbo.spi.impl;

import com.alibaba.dubbo.common.URL;
import com.cy.study.dubbo.spi.Robot;

/**
 * Bumblebee
 *
 * @author cy
 */
public class Bumblebee implements Robot {
    @Override
    public void sayHello(URL url) {
        System.out.println("Hello, I am Bumblebee.");
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}
