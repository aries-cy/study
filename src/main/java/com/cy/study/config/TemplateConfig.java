package com.cy.study.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * 模板引擎配置
 *
 * @author cy
 */
@Component
public class TemplateConfig {

    @Bean("jsonTemplateResolver")
    SpringResourceTemplateResolver jsonTemplateResolver(){
        SpringResourceTemplateResolver jsonResolver = new SpringResourceTemplateResolver();
        jsonResolver.setTemplateMode(TemplateMode.TEXT);
        jsonResolver.setCacheable(true);
        jsonResolver.setCacheTTLMs(600_000L);
        jsonResolver.setPrefix("classpath:/templates/json/");
        jsonResolver.setSuffix(".json");
        return jsonResolver;
    }

    @Bean("jsonTemplateEngine")
    TemplateEngine jsonTemplateEngine(@Qualifier("jsonTemplateResolver")SpringResourceTemplateResolver jsonTemplateResolver ){
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(jsonTemplateResolver);
        return templateEngine;
    }

}
