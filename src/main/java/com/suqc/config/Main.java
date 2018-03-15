package com.suqc.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // @Configuration注解的spring容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
//        初始化方法一
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        //初始化方法二   (不好使 哪天在研究)
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(Config.class);
        // 如果加载spring-context.xml文件：
        // ApplicationContext context = new
        // ClassPathXmlApplicationContext("spring-context.xml");

        TestBean tb = (TestBean) context.getBean("testBean");
        tb.sayHello();
        System.out.println(tb);

        TestBean tb2 = (TestBean) context.getBean("testBean");
        tb2.sayHello();
        System.out.println(tb2);
    }
}
