package com.wanandroid.tomzem.fragmentlayout.FragmentIndex.view;

import com.wanandroid.tomzem.bean.IndexArticle;

import java.util.List;

/**
 * Created by Tomzem on 2018/3/22.
 */

public interface FragmentIndexView {
    void showBanner(List<String> imagesPath,List<String> titles);
    void showArticleList(List<IndexArticle> articleList);
}
