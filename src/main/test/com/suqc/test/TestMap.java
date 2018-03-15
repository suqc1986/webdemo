package com.suqc.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        map.put("c", null);
        map.put(null, "D");
        System.out.println(map);
        System.out.println(Arrays.asList(map.values().toArray()));
    }
}
