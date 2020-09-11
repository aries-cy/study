package com.cy.study.beautify.annotation;

import com.cy.study.beautify.registrar.MyRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 注解
 *
 * @author cy
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(MyRegistrar.class)
public @interface MyAnnotation {

    String[] value();
}
