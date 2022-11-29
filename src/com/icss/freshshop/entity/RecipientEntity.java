package com.icss.freshshop.entity;

import java.io.Serializable;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/10/3/003 11:30
 * @Description :
 */
public class RecipientEntity implements Serializable {
    private int recipientid;
    private String recipientname;
    private String phone;
    private String address;
    private String zip;
    private int userid;
    private int level;

    public int getRecipientid() {
        return recipientid;
    }

    public void setRecipientid(int recipientid) {
        this.recipientid = recipientid;
    }

    public String getRecipientname() {
        return recipientname;
    }

    public void setRecipientname(String recipientname) {
        this.recipientname = recipientname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "RecipientEntity{" +
                "recipientid=" + recipientid +
                ", recipientname='" + recipientname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", zip='" + zip + '\'' +
                ", userid=" + userid +
                ", level=" + level +
                '}';
    }
}
