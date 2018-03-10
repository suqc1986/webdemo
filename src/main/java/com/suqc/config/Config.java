package com.suqc.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

@Configuration
//添加自动扫描注解，basePackages为TestBean包路径
//@ComponentScan(basePackages = "com.suqc.config")
@ImportResource(value = {"classpath:spring/spring-*.xml","classpath:spring/springmvc.xml"})
public class Config implements EnvironmentAware{
    private Environment env;

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }

    public Config(){
        System.out.println("TestConfiguration容器启动初始化...");
    }
    @Bean(name = "testBean",initMethod = "init",destroyMethod = "destory")
    @Scope("prototype")
    public TestBean testBean(){
        return new TestBean();
    }
}
