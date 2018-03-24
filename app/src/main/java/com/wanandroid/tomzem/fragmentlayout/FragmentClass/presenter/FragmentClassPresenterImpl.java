package com.wanandroid.tomzem.fragmentlayout.FragmentClass.presenter;

import com.wanandroid.tomzem.bean.ClassDatas;
import com.wanandroid.tomzem.fragmentlayout.FragmentClass.OnCallBackClassData;
import com.wanandroid.tomzem.fragmentlayout.FragmentClass.model.FragmentClassModelImpl;
import com.wanandroid.tomzem.fragmentlayout.FragmentClass.view.FragmentClass;

import java.util.List;

/**
 * Created by Tomzem on 2018/3/24.
 */

public class FragmentClassPresenterImpl implements FragmentClassPresenter{

    private FragmentClass fragmentClass;
    private FragmentClassModelImpl fragmentClassModel;

    public FragmentClassPresenterImpl(FragmentClass fragmentClass){
        this.fragmentClass = fragmentClass;
        fragmentClassModel = new FragmentClassModelImpl();
    }


    @Override
    public void getClassDatas() {
        fragmentClassModel.getClassData(new OnCallBackClassData() {
            @Override
            public void onSeccess(List<ClassDatas> datas) {
                fragmentClass.returnClassData(datas);
            }

            @Override
            public void onFailure() {

            }
        });
    }
}
