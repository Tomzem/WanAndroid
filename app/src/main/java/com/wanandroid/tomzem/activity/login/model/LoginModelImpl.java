package com.wanandroid.tomzem.activity.login.model;


import com.wanandroid.tomzem.activity.login.OnLoginListener;
import com.wanandroid.tomzem.app.BaseApplication;
import com.wanandroid.tomzem.http.HttpControl;
import com.wanandroid.tomzem.bean.JsonResponse;
import com.wanandroid.tomzem.http.APIServer;
import com.wanandroid.tomzem.http.ServiceManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tomzem on 2018/3/18.
 */

public class LoginModelImpl implements LoginModel{
    private static final String TAG = "LoginModelImpl";
    private Call<JsonResponse> mCall;

    @Override
    public void Login(String name, String password, final OnLoginListener onLoginListener) {
        mCall = HttpControl.getInstance(BaseApplication.getInstance())
                .createService(APIServer.class)
                .postLogin(name, password);
        mCall.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                if (response == null || response.body() == null){
                    onLoginListener.OnFailure("服务器出错");
                    return;
                }
                if (response.body().getErrorCode() == 0){
                    onLoginListener.OnSeccess();
                }else if(response.body().getErrorCode() == -1){
                    onLoginListener.OnFailure(response.body().getErrorMsg());
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                onLoginListener.OnFailure("网络出错");
            }
        });

    }

    @Override
    public void Logon(String name, String password, String passwordConfim, final OnLoginListener onLoginListener) {
        mCall = ServiceManager.getInstance()
                .getService(APIServer.class)
                .postLogon(name, password, passwordConfim);
        mCall.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                if (response == null || response.body() == null){
                    onLoginListener.OnFailure("服务器出错");
                    return;
                }
                if (response.body().getErrorCode() == 0){
                    onLoginListener.OnSeccess();
                }else if(response.body().getErrorCode() == -1){
                    onLoginListener.OnFailure(response.body().getErrorMsg());
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                onLoginListener.OnFailure("网络出错");
            }
        });
    }
}
