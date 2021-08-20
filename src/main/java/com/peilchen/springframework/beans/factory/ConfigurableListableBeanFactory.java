package com.peilchen.springframework.beans.factory;

import com.peilchen.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.peilchen.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.BeansException;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}