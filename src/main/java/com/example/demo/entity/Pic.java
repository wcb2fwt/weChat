package com.example.demo.entity;

import java.util.Date;

public class Pic {

    private int id;

    private String picName;

    private String picUrl;

    private String newName;

    private String url;

    private Date createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Pic{" +
                "id=" + id +
                ", picName='" + picName + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", newName='" + newName + '\'' +
                ", headerurl='" + url + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
