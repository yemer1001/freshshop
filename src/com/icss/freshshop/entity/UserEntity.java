package com.icss.freshshop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/19/019 14:16
 * @Description :
 */
public class UserEntity implements Serializable {
    private int userid;
    private String username;
    private String email;
    private  String password;
    private double account;
    private int role;  //角色 1-普通用户 2-管理员
    private int status; //用户状态  1-正常 2-封号
    private int sex; //性别 1-男 2-女 0-未选择
    private String phone;
    private String birthday; //生日
    private Timestamp registtime; //注册时间
    private String faceurl;  //人脸地址url

    public UserEntity() {
    }

    public UserEntity(int userid, String username, String email, String password,
                      double account, int role, int status, int sex, String phone,
                      String birthday, Timestamp registtime, String faceurl) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.account = account;
        this.role = role;
        this.status = status;
        this.sex = sex;
        this.phone = phone;
        this.birthday = birthday;
        this.registtime = registtime;
        this.faceurl = faceurl;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Timestamp getRegisttime() {
        return registtime;
    }

    public void setRegisttime(Timestamp registtime) {
        this.registtime = registtime;
    }

    public String getFaceurl() {
        return faceurl;
    }

    public void setFaceurl(String faceurl) {
        this.faceurl = faceurl;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", account=" + account +
                ", role=" + role +
                ", status=" + status +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", birthday='" + birthday + '\'' +
                ", registtime=" + registtime +
                ", faceurl='" + faceurl + '\'' +
                '}';
    }
}
