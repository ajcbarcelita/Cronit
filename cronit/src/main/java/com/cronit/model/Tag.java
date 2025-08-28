package com.cronit.model;

public class Tag {
    private int tag_id;
    private int user_id;
    private String name;
    private String color;

    public Tag(int tag_id, int user_id, String name, String color) {
        this.tag_id = tag_id;
        this.user_id = user_id;
        this.name = name;
    }

    public int getTag_id() {
        return tag_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
