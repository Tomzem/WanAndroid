package com.wanandroid.tomzem.activity.login.model;

import com.wanandroid.tomzem.activity.login.OnLoginListener;

/**
 * Created by Tomzem on 2018/3/18.
 */

public interface LoginModel {
    void Login(String name, String password, OnLoginListener onLoginListener);
    void Logon(String name, String password, String passwordConfim, OnLoginListener onLoginListener);
}
