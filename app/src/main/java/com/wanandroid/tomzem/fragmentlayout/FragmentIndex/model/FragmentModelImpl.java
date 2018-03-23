package com.wanandroid.tomzem.fragmentlayout.FragmentIndex.model;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.wanandroid.tomzem.bean.IndexArticle;
import com.wanandroid.tomzem.bean.IndexImage;
import com.wanandroid.tomzem.bean.JsonResponse;
import com.wanandroid.tomzem.bean.ListResponse;
import com.wanandroid.tomzem.fragmentlayout.FragmentIndex.OnCallBack;
import com.wanandroid.tomzem.http.APIServer;
import com.wanandroid.tomzem.http.ServiceManager;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tomzem on 2018/3/22.
 */

public class FragmentModelImpl implements FragmentModel{

    private Call<JsonResponse<List<IndexImage>>> callImage;
    private Call<JsonResponse<ListResponse<IndexArticle>>> callArticle;

    @Override
    public void getImagesPath(final OnCallBack.OnImagesPathCallBack onImagesPathCallBack) {
        callImage = ServiceManager.getInstance()
                .getService(APIServer.class)
                .getImagesBanner();
        callImage.enqueue(new Callback<JsonResponse<List<IndexImage>>>() {
            @Override
            public void onResponse(Call<JsonResponse<List<IndexImage>>> call, Response<JsonResponse<List<IndexImage>>> response) {
                if (response == null||response.body() == null){
                    onImagesPathCallBack.onFailure();
                    return;
                }
                if (response.body().getData() != null){
                    List<IndexImage> images = response.body().getData();
                    List<String> image = new ArrayList<>();
                    List<String> titles = new ArrayList<>();
                    for (IndexImage indexImage: images) {
                        image.add(indexImage.getImagePath());
                        titles.add(indexImage.getTitle());
                    }
                    onImagesPathCallBack.onSeccess(image,titles);
                }else{
                    onImagesPathCallBack.onFailure();
                }
            }

            @Override
            public void onFailure(Call<JsonResponse<List<IndexImage>>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getIndexArticle(int postion, final OnCallBack.OnIndexArticleCallBack onIndexArticleCallBack) {
        callArticle = ServiceManager.getInstance()
                .getService(APIServer.class)
                .getIndexArticleList(postion);
        callArticle.enqueue(new Callback<JsonResponse<ListResponse<IndexArticle>>>() {
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

