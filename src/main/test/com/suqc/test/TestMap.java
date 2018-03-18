package com.suqc.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> twoMap = new HashMap<>();
        String str = "0823=5,0101=10,0201=1,0301=11";
        String[] arr = str.split(",");
        for(String s:arr){
            String[] ss = s.split("=");
            twoMap.put(ss[0].trim(),Integer.parseInt(ss[1].trim()));
        }
        Map<String,Integer> oneMap = new HashMap<>();
        System.out.println(twoMap.get("0101"));
        for(String key2:twoMap.keySet()){
            String key1 = key2.substring(0, 2);
            int cnt = (oneMap.get(key1)==null?0:oneMap.get(key1)) + twoMap.get(key2);
            oneMap.put(key1,cnt);
//            if(oneMap.get(key1)==null){
//                oneMap.put(key1,0);
//            }
//            if(oneMap.get(key1)!=null){
//                int cnt = oneMap.get(key1)+twoMap.get(key2);
//                oneMap.put(key1,cnt);
//            }
        }
        System.out.println(oneMap);
    }
}
