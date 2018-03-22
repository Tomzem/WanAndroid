package com.wanandroid.tomzem.eventbus;

/**
 * Created by Tomzem on 2018/3/18.
 */

public class MainEvent {

    private int falg;

    public MainEvent(int falg){
        this.falg=falg;
    }

    public int getFalg() {
        return falg;
    }

    public void setFalg(int falg) {
        this.falg = falg;
    }
}
