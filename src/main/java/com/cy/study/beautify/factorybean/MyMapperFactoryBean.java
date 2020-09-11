package com.cy.study.beautify.factorybean;

import com.cy.study.beautify.annotation.MyAnnotation;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * FactoryBean
 *
 * @author cy
 */
public class MyMapperFactoryBean implements FactoryBean, InvocationHandler {

    private Object object;

    public MyMapperFactoryBean(Object object){
        this.object = object;
    }

    @Override
    public Object getObject() throws Exception {
        Object o = Proxy.newProxyInstance(getClass().getClassLoader(), object.getClass().getInterfaces(), this);
        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return object.getClass();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String[] value = method.getDeclaredAnnotation(MyAnnotation.class).value();
        for (String s : value) {
            System.out.println(s);
        }
        return null;
    }
}
