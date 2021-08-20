package com.peilchen.springframework.test.bean;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "林林哥");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
        hashMap.put("10004", "postProcessor大林哥");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
