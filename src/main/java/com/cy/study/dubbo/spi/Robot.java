package com.cy.study.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * dubbo SPI 实例
 *
 * @author cy
 */
@SPI
public interface Robot {

    @Adaptive("robot")
    void sayHello(URL url);

    /**
     * sayHello
     */
    void sayHello();

}
