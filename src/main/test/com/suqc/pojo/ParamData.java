package com.suqc.pojo;

import java.util.List;

public class ParamData {
    private String group;
    private List<Param> params;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<Param> getParams() {
        return params;
    }

    public void setParams(List<Param> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "ParamData{" +
                "group='" + group + '\'' +
                ", params=" + params +
                '}';
    }
}
