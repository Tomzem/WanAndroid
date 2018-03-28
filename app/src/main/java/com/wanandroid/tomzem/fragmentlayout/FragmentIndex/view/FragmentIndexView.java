package com.wanandroid.tomzem.fragmentlayout.FragmentIndex.view;

import com.wanandroid.tomzem.bean.IndexArticle;
import com.wanandroid.tomzem.bean.IndexImage;

import java.util.List;

/**
 * Created by Tomzem on 2018/3/22.
 */

public interface FragmentIndexView {
    void showBanner(List<IndexImage> images);
    void showArticleList(List<IndexArticle> articleList);
}
