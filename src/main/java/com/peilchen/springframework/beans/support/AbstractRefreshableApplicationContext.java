package com.peilchen.springframework.beans.support;

import com.peilchen.springframework.beans.factory.ConfigurableListableBeanFactory;
import org.springframework.beans.BeansException;

/**
 * 该类创建bean工厂
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext  {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
