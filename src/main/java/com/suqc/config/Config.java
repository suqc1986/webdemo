package com.suqc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
//添加自动扫描注解，basePackages为TestBean包路径
//@ComponentScan(basePackages = "com.suqc.config")
@ImportResource(value = {"classpath:spring/spring-*.xml","classpath:spring/springmvc.xml"})
public class Config {
    public Config(){
        System.out.println("TestConfiguration容器启动初始化...");
    }
//    @Bean(name = "testBean",initMethod = "init",destroyMethod = "destory")
//    @Scope("prototype")
//    public TestBean testBean(){
//        return new TestBean();
//    }
}
/**
 * <?xml version="1.0" encoding="UTF-8"?>
 <beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xmlns:context="http://www.springframework.org/schema/context" xmlns:jdbc="http://www.springframework.org/schema/jdbc"
 xmlns:jee="http://www.springframework.org/schema/jee" xmlns:tx="http://www.springframework.org/schema/tx"
 xmlns:util="http://www.springframework.org/schema/util" xmlns:task="http://www.springframework.org/schema/task" xsi:schemaLocation="
 http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
 http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd
 http://www.springframework.org/schema/jdbc http://www.springframework.org/schema/jdbc/spring-jdbc-4.0.xsd
 http://www.springframework.org/schema/jee http://www.springframework.org/schema/jee/spring-jee-4.0.xsd
 http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.0.xsd
 http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util-4.0.xsd
 http://www.springframework.org/schema/task http://www.springframework.org/schema/task/spring-task-4.0.xsd" default-lazy-init="false">
 </beans>
 *
 * */