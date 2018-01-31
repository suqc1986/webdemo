package com.suqc.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.suqc.pojo.User;

import java.io.IOException;
import java.util.List;

public class TestJson {
    public static void main(String[] args ) throws IOException{
        String json = "{\"id\":123,\"name\":\"zhangsan\",\"adds\":[\"中国北京\",\"中国大庆\"]}";
        User u = JSON.parseObject(json,User.class);
        System.out.println(u);
        System.out.println(JSON.toJSONString(u,true));
        System.out.println(JSON.parse(json));
        JSONObject jsonObject =  JSON.parseObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("adds");
        for(int i=0;i<jsonArray.size();i++ ){
            System.out.println(jsonArray.get(i));
        }

        List<String> list = JSON.parseArray(jsonArray.toJSONString(),String.class);
        System.out.println(list);
        System.out.println("--------------");
        String json2 = "[{\"id\":1,\"name\":\"haha\"},{\"$ref\":\"$[0]\"}]";
        JSONArray jsonArray1 = JSON.parseArray(json2);
        for(int i=0;i< jsonArray1.size();i++){
            JSONObject jsonObject1 = jsonArray1.getJSONObject(i);
            String id = jsonObject1.getString("$ref");
            System.out.println(id);
        }
    }
}
