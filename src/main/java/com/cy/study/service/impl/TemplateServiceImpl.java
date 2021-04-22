package com.cy.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cy.study.service.TemplateService;
import handler.ConfContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

/**
 * 模板测试
 *
 * @author cy
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    @Qualifier("jsonTemplateEngine")
    private TemplateEngine jsonTemplateEngine;


    @Override
    public JSONObject getPersonMsg(String templateName,ConfContext context) {
        return JSON.parseObject(jsonTemplateEngine.process(templateName, context));
    }
}
