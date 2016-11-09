package com.ian.pakarteh.models;

/**
 * Created by rama on 11/7/16.
 */

public class Gejala {
    private int id;
    private String gid,index1,index2,index3,index4,index5,index6,nama;

    public Gejala(int id, String gid, String index1, String index2, String index3, String index4, String index5, String index6, String nama) {
        this.id = id;
        this.gid = gid;
        this.index1 = index1;
        this.index2 = index2;
        this.index3 = index3;
        this.index4 = index4;
        this.index5 = index5;
        this.index6 = index6;
        this.nama = nama;
    }

    public Gejala(String gid, String index1, String index2, String index3, String index4, String index5, String index6, String nama) {
        this.gid = gid;
        this.index1 = index1;
        this.index2 = index2;
        this.index3 = index3;
        this.index4 = index4;
        this.index5 = index5;
        this.index6 = index6;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getIndex1() {
        return index1;
    }

    public void setIndex1(String index1) {
        this.index1 = index1;
    }

    public String getIndex2() {
        return index2;
    }

    public void setIndex2(String index2) {
        this.index2 = index2;
    }

    public String getIndex3() {
        return index3;
    }

    public void setIndex3(String index3) {
        this.index3 = index3;
    }

    public String getIndex4() {
        return index4;
    }

    public void setIndex4(String index4) {
        this.index4 = index4;
    }

    public String getIndex5() {
        return index5;
    }

    public void setIndex5(String index5) {
        this.index5 = index5;
    }

    public String getIndex6() {
        return index6;
    }

    public void setIndex6(String index6) {
        this.index6 = index6;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
