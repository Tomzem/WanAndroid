package com.wanandroid.tomzem.fragmentlayout.FragmentIndex;

import com.wanandroid.tomzem.bean.IndexArticle;
import com.wanandroid.tomzem.bean.IndexImage;

import java.util.List;

/**
 * Created by Tomzem on 2018/3/22.
 */

public interface OnCallBack {
    interface OnImagesPathCallBack{
        void onSeccess(List<IndexImage> images);
        void onFailure();
    }

    interface OnIndexArticleCallBack{
        void onSeccess(List<IndexArticle> articleList);
        void onFailure();
    }
}
