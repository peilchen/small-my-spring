package com.peilchen.springframework.test;

import com.peilchen.springframework.beans.PropertyValue;
import com.peilchen.springframework.beans.PropertyValues;
import com.peilchen.springframework.beans.factory.BeanDefinition;
import com.peilchen.springframework.beans.factory.BeanReference;
import com.peilchen.springframework.beans.support.DefaultListableBeanFactory;
import com.peilchen.springframework.test.bean.UserDao;
import com.peilchen.springframework.test.bean.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringRun {

    private String test_name = "aaaaaaa";

    private String runName;


    public SpringRun(String runName) {
        this.runName = runName;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.peilchen.springframework.test");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.queryUserInfo();
    }

    public void queryUserInfo() {
        System.out.println("query user info..." + runName);
    }

    public static void main1(String[] args) {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory listableBeanFactory = new DefaultListableBeanFactory();

        // 2. UseDao注册
        listableBeanFactory.registerBeanDefinition("userDao" ,new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4. UserService 注入bean
        BeanDefinition beanDefinition  = new BeanDefinition(UserService.class, propertyValues);
        listableBeanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. useService获取Bean
        UserService userService = (UserService) listableBeanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
