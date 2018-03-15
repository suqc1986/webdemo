package com.suqc.test;

import com.alibaba.fastjson.JSONArray;
import com.suqc.pojo.ParamData;

import java.util.List;

public class TestJson3 {
    public static void main(String[] args) {
        String jsonStr = "[{\"group\":\"主体\",\"params\":[{\"k\":\"品牌\",\"v\":\"苹果\"}," +
                "{\"k\":\"型号\",\"v\":\"无\"},{\"k\":\"颜色\",\"v\":\"白色\"}," +
                "{\"k\":\"上市年份\",\"v\":\"无\"},{\"k\":\"上市月份\",\"v\":\"无\"}," +
                "{\"k\":\"输入方式\",\"v\":\"无\"}]},{\"group\":\"网络\",\"params\":[{\"k\":\"4G网络制式\",\"v\":\"无\"}," +
                "{\"k\":\"3G网络制式\",\"v\":\"无\"},{\"k\":\"2G网络制式\",\"v\":\"无\"},{\"k\":\"网络频率\",\"v\":\"无\"}]}," +
                "{\"group\":\"存储\",\"params\":[{\"k\":\"机身内存\",\"v\":\"无\"},{\"k\":\"储存卡类型\",\"v\":\"无\"}]}," +
                "{\"group\":\"娱乐功能\",\"params\":[{\"k\":\"音乐播放\",\"v\":\"无\"},{\"k\":\"视频播放\",\"v\":\"无\"}]}]";
//        解析方法二
        List<ParamData> pdList = JSONArray.parseArray(jsonStr, ParamData.class);
        System.out.println(pdList);
//        解析方法一
//        JSONArray jsonArray = JSONArray.parseArray(jsonStr);
//        List<ParamData> pds = new ArrayList<ParamData>();
//        ParamData pd = null;
//        for(int i=0;i<jsonArray.size();i++){
//            JSONObject jsonObject = JSONObject.parseObject(jsonArray.getString(i));
//            pd = new ParamData();
//            pd.setGroup(jsonObject.getString("group"));
//
//            List<Param> ps = new ArrayList<Param>();
//            JSONArray paramArray = JSONArray.parseArray(jsonObject.getString("params"));
//            for(int j=0;j<paramArray.size();j++){
//                Param param = new Param();
//                JSONObject paramObj = JSONObject.parseObject(paramArray.getString(j));
//                param.setK(paramObj.getString("k"));
//                param.setV(paramObj.getString("v"));
//                ps.add(param);
//            }
//            pd.setParams(ps);
//            pds.add(pd);
//        }
//        for(ParamData pdd:pds){
//            System.out.println(pdd);
//        }
    }
}
