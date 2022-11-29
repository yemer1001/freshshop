package com.icss.freshshop.vo;

import java.util.List;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/29/029 11:18
 * @Description :
 */
public class PageResultVo<T> {
    private int currentPage;
    private int totalCount;
    private int totalPage;
    private List<T> lists;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "PageResultVo{" +
                "currentPage=" + currentPage +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", lists=" + lists +
                '}';
    }
}
