package com.wanandroid.tomzem.fragmentlayout.FragmentIndex;

import java.util.List;

/**
 * Created by Tomzem on 2018/3/22.
 */

public interface OnCallBack {
    interface OnImagesPathCallBack{
        void onSeccess(List<String> imagesPath,List<String> titles);
        void OnFailure();
    }
}
