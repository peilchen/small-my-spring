package com.peilchen.springframework.beans.factory.config;

import com.peilchen.springframework.beans.factory.ConfigurableListableBeanFactory;
import org.springframework.beans.BeansException;

public interface BeanFactoryPostProcessor {
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
