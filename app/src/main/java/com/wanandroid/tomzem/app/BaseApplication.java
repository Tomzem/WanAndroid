package com.wanandroid.tomzem.app;

import android.app.Application;
import android.content.Context;

import com.wanandroid.tomzem.utils.SharePrefUtil;

/**
 * 自定义应用入口
 *
 * @author Hunter
 */
public class BaseApplication extends Application {
    private static BaseApplication mInstance;

    public static Context getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = (BaseApplication) getApplicationContext();

        APPControl.IS_LOGIN = SharePrefUtil.getBoolean(BaseApplication.getInstance(), "islogin", false);
        APPControl.USER_NAME = SharePrefUtil.getString(BaseApplication.getInstance(), "userName", "WanAndroid");
    }

}
