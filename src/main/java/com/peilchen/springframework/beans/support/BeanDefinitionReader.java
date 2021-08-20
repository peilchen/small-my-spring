package com.peilchen.springframework.beans.support;

import com.peilchen.springframework.core.io.Resource;
import com.peilchen.springframework.core.io.ResourceLoader;
import org.springframework.beans.BeansException;

public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
