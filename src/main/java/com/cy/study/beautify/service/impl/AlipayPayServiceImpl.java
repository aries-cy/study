package com.cy.study.beautify.service.impl;

import com.cy.study.beautify.annotation.MyAnnotation;
import com.cy.study.beautify.service.PayService;
import org.springframework.stereotype.Service;

/**
 * 支付方式2
 *
 * @author cy
 */
@Service("Alipay")
@MyAnnotation("Alipay-class")
public class AlipayPayServiceImpl implements PayService {


    @Override
    @MyAnnotation("Alipay-method")
    public void execute() {
        System.out.println("支付宝支付...");
    }
}
