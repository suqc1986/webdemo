package com.suqc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/interceptor")
public class InterceptorController {
    @ResponseBody
    @RequestMapping("/test1")
    public Map<String,String> getSomeDate(){
        Map<String,String> map = new HashMap<>();
        map.put("url","/interceptor/test1");
        return map;
    }
    @RequestMapping("/test2")
    @ResponseBody
    public Map<String,String> getSomeDate2(){
        Map<String,String> map = new HashMap<>();
        map.put("url","/interceptor/test1");
        return map;
    }
}
