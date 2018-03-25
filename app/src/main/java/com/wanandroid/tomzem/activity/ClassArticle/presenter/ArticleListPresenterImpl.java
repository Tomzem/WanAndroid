package com.wanandroid.tomzem.activity.ClassArticle.presenter;

import com.wanandroid.tomzem.activity.ClassArticle.model.ArticleListModelImpl;
import com.wanandroid.tomzem.activity.ClassArticle.view.ArticleListActivity;
import com.wanandroid.tomzem.bean.IndexArticle;
import com.wanandroid.tomzem.fragmentlayout.FragmentIndex.OnCallBack;

import java.util.List;

/**
 * Created by Tomzem on 2018/3/25.
 */

public class ArticleListPresenterImpl implements ArticleListPresenter{

    private ArticleListActivity articleListActivity;
    private ArticleListModelImpl articleListModel;

    public ArticleListPresenterImpl(ArticleListActivity articleListActivity){
        this.articleListActivity = articleListActivity;
        this.articleListModel = new ArticleListModelImpl();
    }

    @Override
    public void getClassArticle(int position, int id) {
        articleListModel.getClassArticle(position, id, new OnCallBack.OnIndexArticleCallBack() {
            @Override
            public void onSeccess(List<IndexArticle> articleList) {
                articleListActivity.showArticleList(articleList);
            }

            @Override
            public void onFailure() {

            }
        });
    }
}
