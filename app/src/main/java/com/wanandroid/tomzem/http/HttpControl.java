package com.wanandroid.tomzem.http;

import android.content.Context;

import com.wanandroid.tomzem.app.GetCookiesInterceptor;
import com.wanandroid.tomzem.app.URLs;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tomzem on 2018/3/18.
 */

public class HttpControl {

    private static HttpControl mInstance;
    private Retrofit retrofit;

    public static HttpControl getInstance(Context context){
        if (mInstance == null){
            synchronized (HttpControl.class){
                if (mInstance == null)
                    mInstance = new HttpControl(context);
            }
        }
        return mInstance;
    }
    public HttpControl(Context context){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(7676, TimeUnit.MILLISECONDS)
                .connectTimeout(7676,TimeUnit.MILLISECONDS)
                .addInterceptor(logging)
                .addInterceptor(new GetCookiesInterceptor(context))
                .build();


        retrofit = new Retrofit.Builder().
                baseUrl(URLs.BASE_URL).
                addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }



    public  <T> T createService(Class<T> clz){
        return retrofit.create(clz);
    }
}