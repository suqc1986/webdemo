package com.suqc.prop;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class TestReadProp {
    public static void main(String[] args) throws Exception{
        ResourceBundle rb = ResourceBundle.getBundle("propfile.config");
        Enumeration<String> en = rb.getKeys();
        while(en.hasMoreElements()){
            String key = en.nextElement();
            System.out.println(key+"="+rb.getString(key));
        }
    }
}
