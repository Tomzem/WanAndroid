package com.wanandroid.tomzem.activity.ClassArticle.model;

import com.wanandroid.tomzem.fragmentlayout.FragmentIndex.OnCallBack;

/**
 * Created by Tomzem on 2018/3/25.
 */

public interface ArticleListModel {
    void getClassArticle(int postion, int id, OnCallBack.OnIndexArticleCallBack onIndexArticleCallBack);
}
