package com.wanandroid.tomzem.fragmentlayout.FragmentIndex.view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.wanandroid.tomzem.R;
import com.wanandroid.tomzem.adapter.IndexArticleAdapter;
import com.wanandroid.tomzem.base.BaseFragment;
import com.wanandroid.tomzem.bean.IndexArticle;
import com.wanandroid.tomzem.fragmentlayout.FragmentIndex.presenter.FragmentIndexPresenterImpl;
import com.wanandroid.tomzem.loader.GlideImageLoader;
import com.wanandroid.tomzem.utils.NetUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.bingoogolapple.refreshlayout.BGAMeiTuanRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout.BGARefreshLayoutDelegate;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;

/**
 * Created by Tomzem on 2018/3/17.
 */

public class FragmentIndex extends BaseFragment implements FragmentIndexView,BGARefreshLayoutDelegate{

    @BindView(R.id.lv_index_article)
    ListView mLvIndexArticle;

    @BindView(R.id.rl_refresh_index)
    BGARefreshLayout mRefreshLayout;

    private Banner banner;
    private Context mContext;
    private FragmentIndexPresenterImpl fragmentIndexPresenter;
    private IndexArticleAdapter mIndexArticleAdapter;
    private int INDEX_POSITION = 0;


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
        mIndexArticleAdapter = new IndexArticleAdapter(new ArrayList<IndexArticle>(), mContext, R.layout.item_list_index_article);
        mLvIndexArticle.setAdapter(mIndexArticleAdapter);
//https://github.com/bingoogolapple/BGARefreshLayout-Android/blob/master/demo/src/main/java/cn/bingoogolapple/refreshlayout/demo/ui/activity/SwipeRecyclerViewActivity.java
        // 为BGARefreshLayout 设置代理
//        mRefreshLayout.setDelegate(this);
//        // 设置下拉刷新和上拉加载更多的风格     参数1：应用程序上下文，参数2：是否具有上拉加载更多功能
//        BGAMeiTuanRefreshViewHolder refreshViewHolder = new BGAMeiTuanRefreshViewHolder(mContext, true);
//        refreshViewHolder.setPullDownImageResource();
//        // 设置下拉刷新和上拉加载更多的风格
//        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);
//        mRefreshLayout.setCustomHeaderView(banner, true);

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

    @Override
    public void showArticleList(List<IndexArticle> articleList) {
        if (articleList != null|| articleList.size() != 0){
            mIndexArticleAdapter.onDataChange(articleList);
        }
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        // 在这里下拉刷新加载数据
        if (NetUtils.isNetworkConnected(mContext)){
            fragmentIndexPresenter.getIndexArticle(0);
        }else{
            showToast("网络不可用");
        }
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        // 在这里加载更多数据，或者更具产品需求实现上拉刷新也可以
        if (NetUtils.isNetworkConnected(mContext)){
            fragmentIndexPresenter.getIndexArticle(++INDEX_POSITION);
        }else{
            showToast("网络不可用");
        }
        return false;
    }
}
