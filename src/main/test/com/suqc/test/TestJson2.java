package com.suqc.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJson2 {
        public static void main(String[] args){

            String jsonstr = "{\"CHINA\":[\"山东大学\",\"同济大学\",\"上海交通大学\"],\"USA\":[\"UNIV CINCINNATI\",\"RENSSELAER POLYTECH INST\"]}";
            System.out.println(jsonstr);
            Map<String,String> agency2country = new HashMap<>();
            JSONObject jsonObj = JSON.parseObject(jsonstr);
            for(String key:jsonObj.keySet()){
                JSONArray jsonArr = JSON.parseArray(jsonObj.getString(key));
                for(int i=0;i<jsonArr.size();i++){
                    agency2country.put(jsonArr.getString(i),key);
                }
            }
            System.out.println(agency2country);
            agency2country.clear();
            System.out.println("---------------");
            HashMap<String,List<String>> country2Agencys = JSON.parseObject(jsonstr,new HashMap<String,List<String>>().getClass());
            System.out.println(country2Agencys);
            for(Map.Entry<String,List<String>> entry:country2Agencys.entrySet()){
                String key = entry.getKey();
                List<String> values = entry.getValue();
                for(String str:values){
                    agency2country.put(str,key);
                }
            }
            System.out.println(agency2country);
            System.out.println("---------------");

            String jsonstr1 = JSON.toJSONString(agency2country,true);
            System.out.println(jsonstr1);
            Map<String,String> a2cMap = JSONObject.parseObject(jsonstr1,new HashMap<String,String>().getClass());
            Map<String,List<String>> c2aMap = new HashMap<>();
            for(String key:a2cMap.keySet()){
                if(c2aMap.get(a2cMap.get(key)) == null){
                    c2aMap.put(a2cMap.get(key),new ArrayList<String>());
                }
                c2aMap.get(a2cMap.get(key)).add(key);
            }
            System.out.println(c2aMap);
            System.out.println(JSON.toJSONString(c2aMap,true));
        }
}
