package com.wanandroid.tomzem.fragmentlayout.FragmentIndex.model;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.wanandroid.tomzem.bean.IndexImage;
import com.wanandroid.tomzem.bean.JsonResponse;
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

    private Call<JsonResponse> call;
    private List<LinkedTreeMap<String, String>> indexImages;

    @Override
    public void getImagesPath(final OnCallBack.OnImagesPathCallBack onImagesPathCallBack) {
        call = ServiceManager.getInstance()
                .getService(APIServer.class)
                .getImagesBanner();
        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                if (response == null||response.body() == null){
                    onImagesPathCallBack.OnFailure();
                    return;
                }
                if (response.body().getData() != null){
                    indexImages = (List<LinkedTreeMap<String, String>>) response.body().getData();
                    List<String> image = new ArrayList<>();
                    List<String> titles = new ArrayList<>();
                    for (LinkedTreeMap<String, String> indexImage : indexImages){
                        image.add(indexImage.get("imagePath"));
                        titles.add(indexImage.get("title"));
                    }
                    onImagesPathCallBack.onSeccess(image,titles);
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                onImagesPathCallBack.OnFailure();
            }
        });
    }
}
