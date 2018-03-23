package com.wanandroid.tomzem.fragmentlayout.FragmentIndex.view;

import android.content.DialogInterface;

import com.wanandroid.tomzem.R;
import com.wanandroid.tomzem.base.BaseFragment;
import com.wanandroid.tomzem.fragmentlayout.FragmentIndex.presenter.FragmentIndexPresenterImpl;
import com.wanandroid.tomzem.loader.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Tomzem on 2018/3/17.
 */

public class FragmentIndex extends BaseFragment implements FragmentIndexView{

    @BindView(R.id.banner)
    Banner banner;

    private FragmentIndexPresenterImpl fragmentIndexPresenter;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_index;
    }

    @Override
    public void initView() {
        fragmentIndexPresenter = new FragmentIndexPresenterImpl(this);
        fragmentIndexPresenter.getImagesBanner();
        fragmentIndexPresenter.getIndexArticle(0);
    }

    @Override
    public void setProgressCancelListener(DialogInterface.OnCancelListener onCancelListener) {

    }

    @Override
    public void showBanner(final List<String> imagesPath,List<String> titles) {
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(imagesPath);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        banner.setBannerAnimation(Transformer.Accordion);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        banner.setDelayTime(3500);
        banner.start();
    }
}
