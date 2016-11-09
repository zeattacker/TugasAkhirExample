package com.ian.pakarteh.models;

/**
 * Created by rama on 11/7/16.
 */

public class Penyakit {
    private int id;
    private String pid,nama,solusi;

    public Penyakit(int id, String pid, String nama, String solusi) {
        this.id = id;
        this.pid = pid;
        this.nama = nama;
        this.solusi = solusi;
    }

    public Penyakit(String pid, String nama, String solusi) {
        this.pid = pid;
        this.nama = nama;
        this.solusi = solusi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSolusi() {
        return solusi;
    }

    public void setSolusi(String solusi) {
        this.solusi = solusi;
    }
}
