package com.icss.freshshop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/20/020 15:32
 * @Description :
 */
public class GoodsEntity implements Serializable {
    private int goodsid;  //商品id
    private  int categoryid; //商品类型id
    private  String goodsname; //商品名称
    private double price;  //商品价格
    private int isdiscount; //是否折扣  1-是 2-不是
    private String unit;  //单位
    private String goodsinfo; //商品描述
    private  int popular;  //人气
    private int salesvolume;  //销量
    private int stock;  //库存
    private Timestamp createtime;  //商品添加时间
    private Timestamp addtime;  //商品上架时间
    private Timestamp downtime;  //商品下架时间
    private  int goodsstatus;  //商品状态  1-上架 2-下架 3-补货中
    private String imgpath; //商品图片

    public GoodsEntity() {
    }

    public GoodsEntity(int goodsid, String goodsname, double price, String unit, String goodsinfo, int stock, String imgpath) {
        this.goodsid = goodsid;
        this.goodsname = goodsname;
        this.price = price;
        this.unit = unit;
        this.goodsinfo = goodsinfo;
        this.stock = stock;
        this.imgpath = imgpath;
    }

    public GoodsEntity(int goodsid, int categoryid, String goodsname, double price,
                       int isdiscount, String unit, String goodsinfo, int popular,
                       int salesvolume, int stock, Timestamp createtime, Timestamp addtime,
                       Timestamp downtime, int goodsstatus, String imgpath) {
        this.goodsid = goodsid;
        this.categoryid = categoryid;
        this.goodsname = goodsname;
        this.price = price;
        this.isdiscount = isdiscount;
        this.unit = unit;
        this.goodsinfo = goodsinfo;
        this.popular = popular;
        this.salesvolume = salesvolume;
        this.stock = stock;
        this.createtime = createtime;
        this.addtime = addtime;
        this.downtime = downtime;
        this.goodsstatus = goodsstatus;
        this.imgpath = imgpath;
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIsdiscount() {
        return isdiscount;
    }

    public void setIsdiscount(int isdiscount) {
        this.isdiscount = isdiscount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getGoodsinfo() {
        return goodsinfo;
    }

    public void setGoodsinfo(String goodsinfo) {
        this.goodsinfo = goodsinfo;
    }

    public int getPopular() {
        return popular;
    }

    public void setPopular(int popular) {
        this.popular = popular;
    }

    public int getSalesvolume() {
        return salesvolume;
    }

    public void setSalesvolume(int salesvolume) {
        this.salesvolume = salesvolume;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getAddtime() {
        return addtime;
    }

    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
    }

    public Timestamp getDowntime() {
        return downtime;
    }

    public void setDowntime(Timestamp downtime) {
        this.downtime = downtime;
    }

    public int getGoodsstatus() {
        return goodsstatus;
    }

    public void setGoodsstatus(int goodsstatus) {
        this.goodsstatus = goodsstatus;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    @Override
    public String toString() {
        return "GoodsEntity{" +
                "goodsid=" + goodsid +
                ", categoryid=" + categoryid +
                ", goodsname='" + goodsname + '\'' +
                ", price=" + price +
                ", isdiscount=" + isdiscount +
                ", unit='" + unit + '\'' +
                ", goodsinfo='" + goodsinfo + '\'' +
                ", popular=" + popular +
                ", salesvolume=" + salesvolume +
                ", stock=" + stock +
                ", createtime=" + createtime +
                ", addtime=" + addtime +
                ", downtime=" + downtime +
                ", goodsstatus=" + goodsstatus +
                ", imgpath='" + imgpath + '\'' +
                '}';
    }
}
