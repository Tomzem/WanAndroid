package com.wanandroid.tomzem.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 分类菜单
 * Created by Tomzem on 2018/3/24.
 */

public class ClassDatas implements Serializable{
    private List<ClassDatas> children; //子菜单
    private int courseId;
    private int id;
    private String name; //菜单名
    private int order; //顺序
    private int parentChapterId; //父级名
    private int visible;

    public List<ClassDatas> getChildren() {
        return children;
    }

    public void setChildren(List<ClassDatas> children) {
        this.children = children;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getParentChapterId() {
        return parentChapterId;
    }

    public void setParentChapterId(int parentChapterId) {
        this.parentChapterId = parentChapterId;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }
}
