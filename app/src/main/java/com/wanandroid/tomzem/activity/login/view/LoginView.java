package com.wanandroid.tomzem.activity.login.view;

/**
 * Created by Tomzem on 2018/3/18.
 */

public interface LoginView {
    void showDialog(String msg);
    void disMissDialog();
    String getUserName();
    String getPassWord();
    String getPassWordConfirm();
    void jump2Main();
    void showRemindDialog();
}
