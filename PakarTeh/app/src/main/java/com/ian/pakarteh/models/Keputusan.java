package com.ian.pakarteh.models;

/**
 * Created by rama on 11/7/16.
 */

public class Keputusan {
    private int id;
    private String pid,gid,bobot;

    public Keputusan(int id, String pid, String gid, String bobot) {
        this.id = id;
        this.pid = pid;
        this.gid = gid;
        this.bobot = bobot;
    }

    public Keputusan(String pid, String gid, String bobot) {
        this.pid = pid;
        this.gid = gid;
        this.bobot = bobot;
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

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getBobot() {
        return bobot;
    }

    public void setBobot(String bobot) {
        this.bobot = bobot;
    }
}
