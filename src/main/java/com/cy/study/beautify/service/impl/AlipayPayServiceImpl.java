package com.cy.study.beautify.service.impl;

import com.cy.study.beautify.service.PayService;
import org.springframework.stereotype.Service;

/**
 * 支付方式2
 *
 * @author cy
 */
@Service("Alipay")
public class AlipayPayServiceImpl implements PayService {


    @Override
    public void execute() {
        System.out.println("支付宝支付...");
    }
}
