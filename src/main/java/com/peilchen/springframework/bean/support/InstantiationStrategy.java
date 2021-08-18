package com.peilchen.springframework.bean.support;

import com.peilchen.springframework.bean.factory.BeanDefinition;
import org.springframework.beans.BeansException;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
