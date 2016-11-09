package com.dimas.gastrointenistal.models;

/**
 * Created by rama on 11/5/16.
 */

public class Keputusan {
    private int id;
    private String penyakit;
    private String gejala;
    private String probalitas;

    public Keputusan(int id, String penyakit, String gejala, String probalitas) {
        this.id = id;
        this.penyakit = penyakit;
        this.gejala = gejala;
        this.probalitas = probalitas;
    }

    public Keputusan(String penyakit, String gejala, String probalitas) {
        this.penyakit = penyakit;
        this.gejala = gejala;
        this.probalitas = probalitas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPenyakit() {
        return penyakit;
    }

    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }

    public String getGejala() {
        return gejala;
    }

    public void setGejala(String gejala) {
        this.gejala = gejala;
    }

    public String getProbalitas() {
        return probalitas;
    }

    public void setProbalitas(String probalitas) {
        this.probalitas = probalitas;
    }
}
