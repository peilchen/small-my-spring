package com.peilchen.springframework.beans.factory;

public interface SingletonBeanRegistry {

    Object getSingleton(String name);

}
