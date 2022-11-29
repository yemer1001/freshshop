package com.icss.freshshop.vo;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/29/029 14:47
 * @Description :
 */
public class CartVo {
    private  int cartid;
    private int userid;
    private int count;
    private int goodsid;
    private String goodsname;
    private String unit;
    private double price;
    private String imgpath;
    private int categoryid;

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
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

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    @Override
    public String toString() {
        return "CartVo{" +
                "cartid=" + cartid +
                ", userid=" + userid +
                ", count=" + count +
                ", goodsid=" + goodsid +
                ", goodsname='" + goodsname + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", imgpath='" + imgpath + '\'' +
                ", categoryid=" + categoryid +
                '}';
    }
}
