package com.wanandroid.tomzem.eventbus;

/**
 * Created by Tomzem on 2018/3/25.
 */

public class ClassArticleEvent {

    private int Cid;

    public ClassArticleEvent(int Cid){
        this.Cid=Cid;
    }

    public int getCid() {
        return Cid;
    }

    public void setCid(int cid) {
        Cid = cid;
    }
}
