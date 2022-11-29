package com.icss.freshshop.entity;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/28/028 19:28
 * @Description :
 */
public class CategoryEntity {
    private int categoryid;
    private String categoryname;
    private int parentid;

    public CategoryEntity() {
    }

    public CategoryEntity(int categoryid, String categoryname, int parentid) {
        this.categoryid = categoryid;
        this.categoryname = categoryname;
        this.parentid = parentid;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }
}
