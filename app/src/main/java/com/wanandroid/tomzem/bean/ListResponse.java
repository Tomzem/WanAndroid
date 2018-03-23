package com.wanandroid.tomzem.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/23.
 */

public class ListResponse<T> extends JsonResponse{
    private String curOage;
    private List<T> datas;
    private Double offset;
    private Boolean over;
    private Double pageCount;
    private Double size;
    private Double total;

    public String getCurOage() {
        return curOage;
    }

    public void setCurOage(String curOage) {
        this.curOage = curOage;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public Double getOffset() {
        return offset;
    }

    public void setOffset(Double offset) {
        this.offset = offset;
    }

    public Boolean getOver() {
        return over;
    }

    public void setOver(Boolean over) {
        this.over = over;
    }

    public Double getPageCount() {
        return pageCount;
    }

    public void setPageCount(Double pageCount) {
        this.pageCount = pageCount;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
