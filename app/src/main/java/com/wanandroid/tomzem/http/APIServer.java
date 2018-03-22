package com.wanandroid.tomzem.http;

import com.wanandroid.tomzem.bean.JsonResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Tomzem on 2018/3/15.
 */

public interface APIServer {

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    @POST("user/login")
    @FormUrlEncoded
    Call<JsonResponse> postLogin(@Field("username") String username, @Field("password") String password);

    @POST("user/register")
    @FormUrlEncoded
    Call<JsonResponse> postLogon(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);


    @GET("banner/json")
    Call<JsonResponse> getImagesBanner();

    /**
     * 获取收藏列表
     * @return
     */
    @GET("lg/collect/usertools/json")
    Call<JsonResponse> getCoolectList();
}
