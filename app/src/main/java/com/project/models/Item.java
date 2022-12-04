package com.project.models;

import java.io.Serializable;

public class Item implements Serializable {
    private int Image;
    private String Name;

    public Item(int image, String name) {
        Image = image;
        this.Name = name;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
}

