package com.peilchen.springframework.beans.support;

import com.peilchen.springframework.beans.factory.BeanFactory;
import com.peilchen.springframework.beans.factory.BeanDefinition;
import com.peilchen.springframework.beans.factory.ConfigurableBeanFactory;
import com.peilchen.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.BeansException;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个类应该是Spring中最重要的类！！！
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

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

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }
}
