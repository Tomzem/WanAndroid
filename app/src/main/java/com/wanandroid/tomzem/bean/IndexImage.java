package com.wanandroid.tomzem.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 轮播图片
 * Created by Tomzem on 2018/3/15.
 */
@Entity(nameInDb = "t_IndexImage")
public class IndexImage {
//    "desc":"一起来做个App吧",
//    "id":10,
//    "imagePath":"http://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png",
//    "isVisible":1,
//    "order":0,
//    "title":"一起来做个App吧",
//    "type":0,
//    "url":"http://www.wanandroid.com/blog/show/2"
    @Id(autoincrement = false)
    private int id;
    private String desc;
    private String imagePath;//图片地址
    private int isVisible;//是否显示 1 显示 else 不现实
    private int order; //排序
    private String title;
    private int type;
    private String url;//链接地址
    @Generated(hash = 669833833)
    public IndexImage(int id, String desc, String imagePath, int isVisible, int order, String title,
            int type, String url) {
        this.id = id;
        this.desc = desc;
        this.imagePath = imagePath;
        this.isVisible = isVisible;
        this.order = order;
        this.title = title;
        this.type = type;
        this.url = url;
    }
    @Generated(hash = 680331206)
    public IndexImage() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getImagePath() {
        return this.imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public int getIsVisible() {
        return this.isVisible;
    }
    public void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
    }
    public int getOrder() {
        return this.order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
