package com.cy.study.beautify.service.impl;

import com.cy.study.beautify.service.PayService;
import org.springframework.stereotype.Service;

/**
 * 支付方式1
 *
 * @author cy
 */
@Service("WeChat")
public class WeChatPayServiceImpl implements PayService {

    @Override
    public void execute() {
        System.out.println("微信支付...");
    }

}
