package com.holding.po;

import java.util.Date;

public class Placeholderrate {
    private Integer id;

    private Integer roomid;

    private Integer libraryid;

    private Double llibraryrate;

    private Date updatetime;

    private Double roomrate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Integer getLibraryid() {
        return libraryid;
    }

    public void setLibraryid(Integer libraryid) {
        this.libraryid = libraryid;
    }

    public Double getLlibraryrate() {
        return llibraryrate;
    }

    public void setLlibraryrate(Double llibraryrate) {
        this.llibraryrate = llibraryrate;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Double getRoomrate() {
        return roomrate;
    }

    public void setRoomrate(Double roomrate) {
        this.roomrate = roomrate;
    }
}