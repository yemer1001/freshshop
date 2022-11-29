package com.icss.freshshop.entity;

import java.util.Arrays;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/10/3/003 13:45
 * @Description :
 */
public class OrderDto {
    private double totalPrice;
    private int recipientId;
    private int payStyle;
    private String[] goodsids;
    private String[] prices;
    private String[] counts;
    private int userId;
    private String orderNum;

    public OrderDto(double totalPrice, int recipientId, int payStyle, String[] goodsids,
                    String[] prices, String[] counts, int userId) {
        this.totalPrice = totalPrice;
        this.recipientId = recipientId;
        this.payStyle = payStyle;
        this.goodsids = goodsids;
        this.prices = prices;
        this.counts = counts;
        this.userId = userId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public int getPayStyle() {
        return payStyle;
    }

    public void setPayStyle(int payStyle) {
        this.payStyle = payStyle;
    }

    public String[] getGoodsids() {
        return goodsids;
    }

    public void setGoodsids(String[] goodsids) {
        this.goodsids = goodsids;
    }

    public String[] getPrices() {
        return prices;
    }

    public void setPrices(String[] prices) {
        this.prices = prices;
    }

    public String[] getCounts() {
        return counts;
    }

    public void setCounts(String[] counts) {
        this.counts = counts;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "totalPrice=" + totalPrice +
                ", recipientId=" + recipientId +
                ", payStyle=" + payStyle +
                ", goodsids=" + Arrays.toString(goodsids) +
                ", prices=" + Arrays.toString(prices) +
                ", counts=" + Arrays.toString(counts) +
                ", userId=" + userId +
                ", orderNum='" + orderNum + '\'' +
                '}';
    }
}
