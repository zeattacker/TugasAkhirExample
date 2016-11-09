package com.dimas.gastrointenistal.models;

/**
 * Created by rama on 11/5/16.
 */

public class Gejala {
    private int id;
    private String parameter;
    private String kode;
    private String nama;

    public Gejala(int id, String parameter, String kode, String nama) {
        this.id = id;
        this.parameter = parameter;
        this.kode = kode;
        this.nama = nama;
    }

    public Gejala(String parameter, String kode, String nama) {
        this.parameter = parameter;
        this.kode = kode;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
