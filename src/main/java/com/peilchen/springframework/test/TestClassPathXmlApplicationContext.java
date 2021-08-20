package com.peilchen.springframework.test;

import com.peilchen.springframework.beans.support.ClassPathXmlApplicationContext;
import com.peilchen.springframework.test.bean.UserService;

public class TestClassPathXmlApplicationContext {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        UserService userService = (UserService) context.getBean("userService", UserService.class);
        userService.queryUserInfo();


    }
}
