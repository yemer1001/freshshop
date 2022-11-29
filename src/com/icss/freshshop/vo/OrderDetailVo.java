package com.icss.freshshop.vo;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/10/4/004 19:29
 * @Description :
 */
public class OrderDetailVo {
    private int orderdetailid;
    private String ordernum;
    private int goodsid;
    private int count;
    private double price;
    private String imgpath;
    private String goodsname;
    private String unit;

    public int getOrderdetailid() {
        return orderdetailid;
    }

    public void setOrderdetailid(int orderdetailid) {
        this.orderdetailid = orderdetailid;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "OrderDetailVo{" +
                "orderdetailid=" + orderdetailid +
                ", ordernum='" + ordernum + '\'' +
                ", goodsid=" + goodsid +
                ", count=" + count +
                ", price=" + price +
                ", imgpath='" + imgpath + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
