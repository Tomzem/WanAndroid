package com.wanandroid.tomzem.utils;

import android.content.Context;
import android.content.Intent;

import com.wanandroid.tomzem.activity.webview.view.WebViewActivity;

/**
 * Created by Tomzem on 2018/3/25.
 */

public class Jump2WebView {

    public static void jump2Web(Context mContext, String url){
        Intent jump2WebView = new Intent(mContext, WebViewActivity.class);
        jump2WebView.putExtra("web_view_url",url);
        mContext.startActivity(jump2WebView);
    }

}
