package com.suqc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/scholar")
public class ScholarAction {
    @RequestMapping("/scholarList")
    public String scholarList(HttpServletRequest req, HttpServletResponse res){
        return "scholar/schoolar_list_new";
    }
}
