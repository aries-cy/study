package com.cy.study.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * car
 *
 * @author cy
 */
@SPI
public interface Car {

    void run(URL url);
}
