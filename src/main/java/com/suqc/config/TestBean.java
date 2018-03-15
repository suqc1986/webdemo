package com.suqc.config;

import org.springframework.stereotype.Component;

@Component
public class TestBean {
    private String username;
    private String url;
    private String password;

    public void sayHello() {
        System.out.println("testBean sayHello ...");
    }

    public void init() {
        System.out.println("init......");
    }

    public void destory() {
        System.out.println("destory.....");
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "username='" + username + '\'' +
                ", url='" + url + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
