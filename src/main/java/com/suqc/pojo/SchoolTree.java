package com.suqc.pojo;

public class SchoolTree {
    private int id;
    private int pId;
    private String name;
    private int isParent;

    public int getId() {
        return id;
    }

    public int getpId() {
        return pId;
    }

    public String getName() {
        return name;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsParent() {
        return isParent;
    }

    public void setIsParent(int isParent) {
        this.isParent = isParent;
    }
}
