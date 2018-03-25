package com.suqc.controller;

import com.suqc.dao.DictCityDao;
import com.suqc.pojo.DictCity;
import com.suqc.service.DictCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.stereotype.Controller;
import org.springframework.util.PropertyPlaceholderHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class DictCityController {
    @Resource(name = "dictCityService")
    DictCityService dictCityService;
    @RequestMapping("/getAll")
    @ResponseBody
    public List<DictCity> getDictCityAll(HttpServletRequest request, HttpServletResponse response) throws Exception{
        return dictCityService.getAll();
    }

    @RequestMapping("/getCityGroup")
    @ResponseBody
    public List<Map<String,Object>> getDictCityGroup(HttpServletRequest request){
        List<Map<String,Object>> list = dictCityService.getDictMap();
        for(Map<String,Object> map:list){
            System.out.println(map.get("code")+"-->"+Integer.parseInt(map.get("cnt").toString()));
        }
        return list;
    }
}
