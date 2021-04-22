package com.cy.study.service;

import com.alibaba.fastjson.JSONObject;
import handler.ConfContext;

/**
 * 模板service
 *
 * @author cy
 */
public interface TemplateService {

    JSONObject getPersonMsg(String templateName,ConfContext context);
}
