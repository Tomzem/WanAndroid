package com.wanandroid.tomzem.fragmentlayout.FragmentIndex.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.BallPulseView;
import com.wanandroid.tomzem.R;
import com.wanandroid.tomzem.adapter.IndexArticleAdapter;
import com.wanandroid.tomzem.base.BaseFragment;
import com.wanandroid.tomzem.bean.IndexArticle;
import com.wanandroid.tomzem.bean.IndexImage;
import com.wanandroid.tomzem.fragmentlayout.FragmentIndex.presenter.FragmentIndexPresenterImpl;
import com.wanandroid.tomzem.loader.GlideImageLoader;
import com.wanandroid.tomzem.utils.Jump2WebView;
import com.wanandroid.tomzem.utils.NetUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Tomzem on 2018/3/17.
 */

public class FragmentIndex extends BaseFragment implements FragmentIndexView, AdapterView.OnItemClickListener{

    @BindView(R.id.lv_index_article)
    ListView mLvIndexArticle;

    @BindView(R.id.trl_refresh)
    TwinklingRefreshLayout mTrlRefresh;

    private Banner banner;
    private Context mContext;
    private FragmentIndexPresenterImpl fragmentIndexPresenter;
    private IndexArticleAdapter mIndexArticleAdapter;
    private int INDEX_POSITION = 0;
    private List<IndexArticle> articles;

    @Override
    public int getLayoutRes() {
        mContext = this.getActivity();
        return R.layout.fragment_index;
    }

    @Override
    public void initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_header_index, mLvIndexArticle, false);
        banner = view.findViewById(R.id.banner);
        mLvIndexArticle.addHeaderView(view);

        articles = new ArrayList<>();
        mIndexArticleAdapter = new IndexArticleAdapter(articles, mContext, R.layout.item_list_index_article);
        mLvIndexArticle.setAdapter(mIndexArticleAdapter);
        mLvIndexArticle.setOnItemClickListener(this);

        mTrlRefresh.setEnableRefresh(false);
        mTrlRefresh.setDefaultFooter(BallPulseView.class.getName());
        mTrlRefresh.setMaxHeadHeight(0);
        mTrlRefresh.setOnRefreshListener(new RefreshListenerAdapter(){
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {

            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                //强行睡两秒，不然这里得反应时间太短
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (NetUtils.isNetworkConnected(mContext)){
                            fragmentIndexPresenter.getIndexArticle(++INDEX_POSITION);
                        }else{
                            showToast("网络不可用");
                        }
                    }
                },2000);
            }
        });
        initData();
    }

    private void initData() {
        fragmentIndexPresenter = new FragmentIndexPresenterImpl(this);
        fragmentIndexPresenter.getImagesBanner();
        fragmentIndexPresenter.getIndexArticle(INDEX_POSITION);
    }

    @Override
    public void setProgressCancelListener(DialogInterface.OnCancelListener onCancelListener) {

    }

    @Override
    public void showBanner(final List<IndexImage> images) {
        List<String> imagesPath = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for(IndexImage image : images){
            imagesPath.add(image.getImagePath());
            titles.add(image.getTitle());
        }
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(imagesPath);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        banner.setBannerAnimation(Transformer.Accordion);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        banner.setDelayTime(3500);
        banner.start();
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                Jump2WebView.jump2Web(mContext, images.get(position-1).getUrl());
            }
        });
    }

    @Override
    public void showArticleList(List<IndexArticle> articleList) {
        if (articleList != null){
            if(articleList.size() == 0){
                showToast("已无更多文章加载");
            }
            articles.addAll(articleList);
            mIndexArticleAdapter.onDataChange(articles);
            if (mTrlRefresh.isShown()){
                mTrlRefresh.finishLoadmore();
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Jump2WebView.jump2Web(mContext, articles.get(i-1).getLink());
    }

}
