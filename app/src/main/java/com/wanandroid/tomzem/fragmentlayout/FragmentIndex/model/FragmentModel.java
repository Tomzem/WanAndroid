package com.wanandroid.tomzem.fragmentlayout.FragmentIndex.model;

import com.wanandroid.tomzem.fragmentlayout.FragmentIndex.OnCallBack;

/**
 * Created by Tomzem on 2018/3/22.
 */

public interface FragmentModel {
    void getImagesPath(OnCallBack.OnImagesPathCallBack onImagesPathCallBack);
    void getIndexArticle(int postion, OnCallBack.OnIndexArticleCallBack onIndexArticleCallBack);
}
