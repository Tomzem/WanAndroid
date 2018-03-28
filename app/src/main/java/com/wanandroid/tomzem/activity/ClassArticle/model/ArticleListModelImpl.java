package com.wanandroid.tomzem.activity.ClassArticle.model;

import com.wanandroid.tomzem.bean.IndexArticle;
import com.wanandroid.tomzem.bean.JsonResponse;
import com.wanandroid.tomzem.bean.ListResponse;
import com.wanandroid.tomzem.fragmentlayout.FragmentIndex.OnCallBack;
import com.wanandroid.tomzem.http.APIServer;
import com.wanandroid.tomzem.http.ServiceManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tomzem on 2018/3/25.
 */

public class ArticleListModelImpl implements ArticleListModel{

    private Call<JsonResponse<ListResponse<IndexArticle>>> callData;

    @Override
    public void getClassArticle(int postion, int id, final OnCallBack.OnIndexArticleCallBack onIndexArticleCallBack) {
        callData = ServiceManager.getInstance()
                .getService(APIServer.class)
                .getClassArticleList(postion,id);
        callData.enqueue(new Callback<JsonResponse<ListResponse<IndexArticle>>>() {
            @Override
            public void onResponse(Call<JsonResponse<ListResponse<IndexArticle>>> call, Response<JsonResponse<ListResponse<IndexArticle>>> response) {
                if (response == null|| response.body() == null){
                    onIndexArticleCallBack.onFailure();
                    return;
                }
                if (response.body().getData() != null){
                    onIndexArticleCallBack.onSeccess(response.body().getData().getDatas());
                }else{
                    onIndexArticleCallBack.onFailure();
                }
            }

            @Override
            public void onFailure(Call<JsonResponse<ListResponse<IndexArticle>>> call, Throwable t) {
                onIndexArticleCallBack.onFailure();
            }
        });
    }
}
