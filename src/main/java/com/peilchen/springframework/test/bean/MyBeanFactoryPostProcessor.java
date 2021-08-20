package com.peilchen.springframework.test.bean;

import com.peilchen.springframework.beans.PropertyValue;
import com.peilchen.springframework.beans.PropertyValues;
import com.peilchen.springframework.beans.factory.BeanDefinition;
import com.peilchen.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.peilchen.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.BeansException;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("uId", "10004"));
    }

}