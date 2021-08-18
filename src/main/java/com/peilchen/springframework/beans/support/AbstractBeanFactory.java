package com.peilchen.springframework.beans.support;

import com.peilchen.springframework.beans.BeanFactory;
import com.peilchen.springframework.beans.factory.BeanDefinition;
import org.springframework.beans.BeansException;

/**
 * 这个类应该是Spring中最重要的类！！！
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) {
        return doGetBean(name, args);
    }

    private <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (null != bean) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;
}
