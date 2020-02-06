package com.cy.study;

import com.cy.study.filter.UserDelegateFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 启动类
 *
 * @author cy
 */
@SpringBootApplication
public class StudyApplication{

    private final static Logger LOGGER = LoggerFactory.getLogger(StudyApplication.class);


    @Bean
    public FilterRegistrationBean webFilter(){
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new UserDelegateFilter());
        return filter;
    }

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
        LOGGER.info("启动成功！");
    }


}