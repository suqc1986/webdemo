package com.suqc.service;

import com.suqc.dao.DictCityDao;
import com.suqc.pojo.DictCity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class DictCityService {
    @Resource(name = "dictCityDao")
    DictCityDao dictCityDao;

    public List<DictCity> getAll(){
        System.out.println("===== 获取DictCity信息 getAll() =====");
        return dictCityDao.query(null);
    }

    public List<Map<String,Long>> getDictMap(){
        System.out.println("===== 获取DictCity信息 getDictMap()=====");
        return dictCityDao.queryByGroup();
    }
}
