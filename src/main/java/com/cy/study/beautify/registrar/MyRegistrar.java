package com.cy.study.beautify.registrar;

import com.cy.study.beautify.annotation.MyAnnotation;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;

import java.util.Set;

/**
 * ImportBeanDefinitionRegistrar
 *
 * @author cy
 */
public class MyRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //拿到类上的注解
        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(
                importingClassMetadata.getAnnotationAttributes(MyAnnotation.class.getName()));

        for (String value : annotationAttributes.getStringArray("value")) {
            System.out.println(value);
        }

        //拿到方法上的注解
        Set<MethodMetadata> annotatedMethods = importingClassMetadata.getAnnotatedMethods(MyAnnotation.class.getName());
        annotatedMethods.forEach(methodMetadata -> {
            AnnotationAttributes methodAnnotationAttributes = AnnotationAttributes.fromMap(methodMetadata.getAnnotationAttributes(MyAnnotation.class.getName()));
            for (String value : methodAnnotationAttributes.getStringArray("value")) {
                System.out.println(value);
            }
        });


        //拿到类上的注解
        /*AnnotationAttributes classAttributes = AnnotationAttributes.fromMap(
                importingClassMetadata.getAnnotationAttributes(Service.class.getName()));
        String name =  classAttributes.getStringArray("value")[0];


        try {
            Class<?> aClass = Class.forName(importingClassMetadata.getClassName());
            MyMapperFactoryBean factoryBean = new MyMapperFactoryBean(aClass);
            //接口名称
            String interfaceName = Class.forName(importingClassMetadata.getClassName()).getInterfaces()[0].getName();
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(factoryBean.getClass());
            AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
            //将接口的全路径 作为参数 传给FactoryBean 生成代理对象
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(aClass.getName());
            registry.registerBeanDefinition(name,beanDefinition);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }
}
