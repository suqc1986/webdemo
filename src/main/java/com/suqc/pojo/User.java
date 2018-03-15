package com.suqc.pojo;

import org.springframework.stereotype.Component;

import java.util.List;

public class User {
    private Integer id;
    private String name;
    private List<String> adds;

    public User() {
    }

    public User(Integer id, String name) {
        this(id, name, null);
    }

    public User(Integer id, String name, List<String> adds) {
        this.id = id;
        this.name = name;
        this.adds = adds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAdds() {
        return adds;
    }

    public void setAdds(List<String> adds) {
        this.adds = adds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
