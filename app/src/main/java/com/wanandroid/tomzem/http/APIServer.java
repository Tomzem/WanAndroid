package com.wanandroid.tomzem.http;

import com.wanandroid.tomzem.bean.IndexArticle;
import com.wanandroid.tomzem.bean.IndexImage;
import com.wanandroid.tomzem.bean.JsonResponse;
import com.wanandroid.tomzem.bean.ListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

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

    /**
     * 用户注册
     * @param username
     * @param password
     * @param repassword
     * @return
     */
    @POST("user/register")
    @FormUrlEncoded
    Call<JsonResponse> postLogon(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

    /**
     * 获取主页banner
     * @return
     */
    @GET("banner/json")
    Call<JsonResponse<List<IndexImage>>> getImagesBanner();

    @GET("article/list/{position}/json")
    Call<JsonResponse<ListResponse<IndexArticle>>> getIndexArticleList(@Path("position") int position);

    /**
     * 获取收藏列表
     * @return
     */
    @GET("lg/collect/usertools/json")
    Call<JsonResponse> getCoolectList();
}
