package com.peilchen.springframework.bean.factory;

public interface SingletonBeanRegistry {

    Object getSingleton(String name);

}
