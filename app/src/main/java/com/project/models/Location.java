package com.project.models;

import java.io.Serializable;


public class Location implements Serializable{
    private String Name;
    private String Des;

    public Location(String name, String des) {
        Name = name;
        Des = des;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }
}