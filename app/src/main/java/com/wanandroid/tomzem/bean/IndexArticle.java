package com.wanandroid.tomzem.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 首页文章
 * Created by Tomzem on 2018/3/15.
 */
@Entity(nameInDb = "t_IndexArticle")
public class IndexArticle {
    @Id(autoincrement = false)
    private int id;
    private String author;  //作者
    private String link;    //链接‘
    private boolean collect;//收藏
    private String chapterName;
    private String envelopePic; //封面图片
    private String niceDate;//发表日期
    private String projectLink;//项目地址
    private String publishTime;
    private int superChapterId;//一级分类id
    private String superChapterName;//一级分类名称
    private String title;//标题
    private int visible;//浏览
    private int zan;//点赞
    private String apkLink;//作品链接
    private String desc;
    private String origin;
    @Generated(hash = 724096593)
    public IndexArticle(int id, String author, String link, boolean collect,
            String chapterName, String envelopePic, String niceDate,
            String projectLink, String publishTime, int superChapterId,
            String superChapterName, String title, int visible, int zan,
            String apkLink, String desc, String origin) {
        this.id = id;
        this.author = author;
        this.link = link;
        this.collect = collect;
        this.chapterName = chapterName;
        this.envelopePic = envelopePic;
        this.niceDate = niceDate;
        this.projectLink = projectLink;
        this.publishTime = publishTime;
        this.superChapterId = superChapterId;
        this.superChapterName = superChapterName;
        this.title = title;
        this.visible = visible;
        this.zan = zan;
        this.apkLink = apkLink;
        this.desc = desc;
        this.origin = origin;
    }
    @Generated(hash = 2129560883)
    public IndexArticle() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getLink() {
        return this.link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public boolean getCollect() {
        return this.collect;
    }
    public void setCollect(boolean collect) {
        this.collect = collect;
    }
    public String getChapterName() {
        return this.chapterName;
    }
    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }
    public String getEnvelopePic() {
        return this.envelopePic;
    }
    public void setEnvelopePic(String envelopePic) {
        this.envelopePic = envelopePic;
    }
    public String getNiceDate() {
        return this.niceDate;
    }
    public void setNiceDate(String niceDate) {
        this.niceDate = niceDate;
    }
    public String getProjectLink() {
        return this.projectLink;
    }
    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }
    public String getPublishTime() {
        return this.publishTime;
    }
    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }
    public int getSuperChapterId() {
        return this.superChapterId;
    }
    public void setSuperChapterId(int superChapterId) {
        this.superChapterId = superChapterId;
    }
    public String getSuperChapterName() {
        return this.superChapterName;
    }
    public void setSuperChapterName(String superChapterName) {
        this.superChapterName = superChapterName;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getVisible() {
        return this.visible;
    }
    public void setVisible(int visible) {
        this.visible = visible;
    }
    public int getZan() {
        return this.zan;
    }
    public void setZan(int zan) {
        this.zan = zan;
    }
    public String getApkLink() {
        return this.apkLink;
    }
    public void setApkLink(String apkLink) {
        this.apkLink = apkLink;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getOrigin() {
        return this.origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }

}
