package com.wanandroid.tomzem.fragmentlayout.FragmentClass.model;

import com.wanandroid.tomzem.bean.ClassDatas;
import com.wanandroid.tomzem.bean.JsonResponse;
import com.wanandroid.tomzem.fragmentlayout.FragmentClass.OnCallBackClassData;
import com.wanandroid.tomzem.http.APIServer;
import com.wanandroid.tomzem.http.ServiceManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tomzem on 2018/3/24.
 */

public class FragmentClassModelImpl implements FragmentClassModel{

    private Call<JsonResponse<List<ClassDatas>>> callData;

    @Override
    public void getClassData(final OnCallBackClassData onCallBackClassData) {
        callData = ServiceManager.getInstance().getService(APIServer.class).getClassData();
        callData.enqueue(new Callback<JsonResponse<List<ClassDatas>>>() {
            @Override
            public void onResponse(Call<JsonResponse<List<ClassDatas>>> call, Response<JsonResponse<List<ClassDatas>>> response) {
                if (response == null || response.body() == null){
                    return;
                }
                if (response.body().getErrorCode() == 0){
                    onCallBackClassData.onSeccess(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<JsonResponse<List<ClassDatas>>> call, Throwable t) {

            }
        });
    }
}
