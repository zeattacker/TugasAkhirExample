package com.dimas.gastrointenistal.models;

/**
 * Created by rama on 11/2/16.
 */

public class Artikel {
    private int id;
    private String title,desc,category,img;

    public Artikel(int id, String title, String desc, String category, String img) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.category = category;
        this.img = img;
    }

    public Artikel(String title, String desc, String category, String img) {
        this.title = title;
        this.desc = desc;
        this.category = category;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
