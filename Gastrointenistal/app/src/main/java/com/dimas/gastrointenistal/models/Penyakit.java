package com.dimas.gastrointenistal.models;

/**
 * Created by rama on 11/2/16.
 */

public class Penyakit {
    private int id;
    private String kode,name,penanganan,desc,img;

    public Penyakit(int id, String kode, String name, String penanganan, String desc, String img) {
        this.id = id;
        this.kode = kode;
        this.name = name;
        this.penanganan = penanganan;
        this.desc = desc;
        this.img = img;
    }

    public Penyakit(String kode, String name, String penanganan, String desc, String img) {
        this.kode = kode;
        this.name = name;
        this.penanganan = penanganan;
        this.desc = desc;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPenanganan() {
        return penanganan;
    }

    public void setPenanganan(String penanganan) {
        this.penanganan = penanganan;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
