package com.wanandroid.tomzem.fragmentlayout.FragmentIndex.presenter;

import com.wanandroid.tomzem.fragmentlayout.FragmentIndex.OnCallBack;
import com.wanandroid.tomzem.fragmentlayout.FragmentIndex.model.FragmentModelImpl;
import com.wanandroid.tomzem.fragmentlayout.FragmentIndex.view.FragmentIndex;

import java.util.List;

/**
 * Created by Tomzem on 2018/3/22.
 */

public class FragmentIndexPresenterImpl implements FragmentIndexPresenter{
    private FragmentIndex fragmentIndex;
    private FragmentModelImpl fragmentModel;

    public FragmentIndexPresenterImpl(FragmentIndex fragmentIndex){
        this.fragmentIndex = fragmentIndex;
        fragmentModel = new FragmentModelImpl();
    }

    @Override
    public void getImagesBanner() {
        fragmentModel.getImagesPath(new OnCallBack.OnImagesPathCallBack() {
            @Override
            public void onSeccess(List<String> imagesPath,List<String> titles) {
                fragmentIndex.showBanner(imagesPath,titles);
            }

            @Override
            public void OnFailure() {

            }
        });
    }
}
