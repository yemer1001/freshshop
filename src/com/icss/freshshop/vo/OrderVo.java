package com.icss.freshshop.vo;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/10/4/004 17:07
 * @Description :
 */
public class OrderVo {
    private String ordernum;
    private int userid;
    private Timestamp createtime;
    private int status;
    private double totalprice;
    private int recipientid;
    private List<OrderDetailVo> lists;

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public int getRecipientid() {
        return recipientid;
    }

    public void setRecipientid(int recipientid) {
        this.recipientid = recipientid;
    }

    public List<OrderDetailVo> getLists() {
        return lists;
    }

    public void setLists(List<OrderDetailVo> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "OrderVo{" +
                "ordernum='" + ordernum + '\'' +
                ", userid=" + userid +
                ", createtime=" + createtime +
                ", status=" + status +
                ", totalprice=" + totalprice +
                ", recipientid=" + recipientid +
                ", lists=" + lists +
                '}';
    }
}
