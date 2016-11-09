package com.dimas.gastrointenistal.models;

/**
 * Created by rama on 11/2/16.
 */

public class Hospital {
    private int id;
    private String name;
    private String kec;
    private String alamat;
    private String telp;
    private String jadwal;
    private String lat;
    private String lng;

    public Hospital(int id, String name, String kec, String alamat, String telp, String jadwal, String lat, String lng) {
        this.id = id;
        this.name = name;
        this.kec = kec;
        this.alamat = alamat;
        this.telp = telp;
        this.jadwal = jadwal;
        this.lat = lat;
        this.lng = lng;
    }

    public Hospital(String name, String kec, String alamat, String telp, String jadwal, String lat, String lng) {
        this.name = name;
        this.kec = kec;
        this.alamat = alamat;
        this.telp = telp;
        this.jadwal = jadwal;
        this.lat = lat;
        this.lng = lng;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKec() {
        return kec;
    }

    public void setKec(String kec) {
        this.kec = kec;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
