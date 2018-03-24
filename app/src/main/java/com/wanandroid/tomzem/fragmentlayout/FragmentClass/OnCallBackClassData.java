package com.wanandroid.tomzem.fragmentlayout.FragmentClass;

import com.wanandroid.tomzem.bean.ClassDatas;

import java.util.List;

/**
 * Created by Tomzem on 2018/3/24.
 */

public interface OnCallBackClassData {
    void onSeccess(List<ClassDatas> datas);
    void onFailure();
}
