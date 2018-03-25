package com.suqc.config;

import org.springframework.stereotype.Component;

@Component("contextInit")
public class ContextInit {
    public void init() {
        System.out.println("context init......");
    }

    public void destory() {
        System.out.println("context destory.....");
    }
}
