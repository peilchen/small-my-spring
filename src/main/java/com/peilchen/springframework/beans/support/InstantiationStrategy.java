package com.peilchen.springframework.beans.support;

import com.peilchen.springframework.beans.factory.BeanDefinition;
import org.springframework.beans.BeansException;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
