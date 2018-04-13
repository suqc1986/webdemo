package com.suqc.dao;

import com.suqc.pojo.DictCity;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;
@MyBatisDao
public interface DictCityDao extends  MyBatisBaseDao<DictCity>{
    public List<Map<String,Long>> queryByGroup();
}
