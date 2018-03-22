package com.wanandroid.tomzem.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 常用网站
 * Created by Tomzem on 2018/3/15.
 */
@Entity(nameInDb = "t_UsedWebSite")
public class UsedWebSite {
    /**
     *  "icon":"",
         "id":17,
         "link":"http://www.wanandroid.com/article/list/0?cid=176",
         "name":"国内大牛博客集合",
         "order":1,
         "visible":1
     */
    @Id(autoincrement = false)
    private int id;
    private String icon;
    private String link;
    private String name;
    private int order;
    private int visible;
    @Generated(hash = 1608781295)
    public UsedWebSite(int id, String icon, String link, String name, int order,
            int visible) {
        this.id = id;
        this.icon = icon;
        this.link = link;
        this.name = name;
        this.order = order;
        this.visible = visible;
    }
    @Generated(hash = 130432118)
    public UsedWebSite() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getLink() {
        return this.link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getOrder() {
        return this.order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public int getVisible() {
        return this.visible;
    }
    public void setVisible(int visible) {
        this.visible = visible;
    }
}
