package com.suqc.controller;

import com.suqc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/json")
public class JsonController {
    @RequestMapping("/getJsonString")
    @ResponseBody
    public User getJsonString() {
        User u = createUser();
        return u;
    }

    private User createUser() {
        List<String> adds = new ArrayList<>();
        adds.add("中国北京");
        adds.add("中国大庆");
        User u = new User(123, "zhangsan", adds);
        return u;
    }

}
