package com.wanandroid.tomzem.fragmentlayout.FragmentIndex.view;

import android.content.DialogInterface;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wanandroid.tomzem.R;
import com.wanandroid.tomzem.base.BaseFragment;
import com.wanandroid.tomzem.bean.IndexImage;
import com.wanandroid.tomzem.bean.JsonResponse;
import com.wanandroid.tomzem.http.APIServer;
import com.wanandroid.tomzem.http.ServiceManager;
import com.wanandroid.tomzem.loader.GlideImageLoader;
import com.youth.banner.Banner;

import org.greenrobot.greendao.annotation.Index;
import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tomzem on 2018/3/17.
 */

public class FragmentIndex extends BaseFragment{

    @BindView(R.id.banner)
    Banner banner;

    List<IndexImage> images;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_index;
    }

    @Override
    public void initView() {
        Call<JsonResponse> call = ServiceManager.getInstance()
                .getService(APIServer.class)
                .getImagesBanner();
        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                if (response == null||response.body() == null){
                    return;
                }
                if (response.code() == 1){
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<IndexImage>>() {
                    }.getType();
                    images = gson.fromJson(response.body().getData().toString(), type);
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                showToast("sss  ");
            }
        });
        images = new ArrayList<>();
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    @Override
    public void setProgressCancelListener(DialogInterface.OnCancelListener onCancelListener) {

    }

}
