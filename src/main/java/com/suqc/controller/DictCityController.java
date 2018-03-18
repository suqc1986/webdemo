package com.suqc.controller;

import com.suqc.dao.DictCityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class DictCityController {
    @Autowired
    DictCityDao dictCityDao;
    @RequestMapping("/getCityGroup")
    @ResponseBody
    public List<Map<String,Object>> getDictCityGroup(HttpServletRequest request){
        List<Map<String,Object>> list = dictCityDao.queryByGroup();
        for(Map<String,Object> map:list){
            System.out.println(map.get("code")+"-->"+Integer.parseInt(map.get("cnt").toString()));
        }
        return list;
    }
}
