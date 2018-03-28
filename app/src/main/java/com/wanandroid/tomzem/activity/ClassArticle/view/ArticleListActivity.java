package com.wanandroid.tomzem.activity.ClassArticle.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.BallPulseView;
import com.wanandroid.tomzem.R;
import com.wanandroid.tomzem.activity.ClassArticle.presenter.ArticleListPresenterImpl;
import com.wanandroid.tomzem.adapter.IndexArticleAdapter;
import com.wanandroid.tomzem.base.BaseActivity;
import com.wanandroid.tomzem.bean.ClassDatas;
import com.wanandroid.tomzem.bean.IndexArticle;
import com.wanandroid.tomzem.utils.Jump2WebView;
import com.wanandroid.tomzem.utils.NetUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ArticleListActivity extends BaseActivity implements AdapterView.OnItemClickListener,ArticleListView{

    @BindView(R.id.tv_title_web)
    TextView mTvTitle;

    @BindView(R.id.lv_index_article)
    ListView mLvClassArticle;

    @BindView(R.id.trl_refresh)
    TwinklingRefreshLayout mTrlRefresh;

    private Context mContext;
    private List<IndexArticle> articles;
    private int CLASS_POSITION = 0;
    private ClassDatas classDatas;
    private IndexArticleAdapter mClassArticleAdapter;
    private ArticleListPresenterImpl articleListPresenter;


    @Override
    protected int getContentResId() {
        mContext = this;
        return R.layout.activity_article_list;
    }

    @Override
    public void initView() {
        articles = new ArrayList<>();
        mClassArticleAdapter = new IndexArticleAdapter(articles, mContext, R.layout.item_list_index_article);
        mLvClassArticle.setAdapter(mClassArticleAdapter);
        mLvClassArticle.setOnItemClickListener(this);

        mTrlRefresh.setEnableRefresh(false);
        mTrlRefresh.setDefaultFooter(BallPulseView.class.getName());
        mTrlRefresh.setMaxHeadHeight(0);
        mTrlRefresh.setOnRefreshListener(new RefreshListenerAdapter(){
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                return;
            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                //强行睡两秒，不然这里得反应时间太短
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (NetUtils.isNetworkConnected(mContext)){
                            articleListPresenter.getClassArticle(++CLASS_POSITION, classDatas.getId());
                        }else{
                            showToast("网络不可用");
                        }
                    }
                },2000);
            }
        });
    }

    @Override
    public void initPresenter() {
        classDatas = (ClassDatas) getIntent().getSerializableExtra("ClassBean");
        mTvTitle.setText(classDatas.getName());
        articleListPresenter = new ArticleListPresenterImpl(this);
        articleListPresenter.getClassArticle(0,classDatas.getId());
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Jump2WebView.jump2Web(mContext, articles.get(i).getLink());
    }

    @Override
    public void showArticleList(List<IndexArticle> articleList) {
        if (articleList != null){
            if(articleList.size() == 0){
                showToast("已无更多文章加载");
            }
            articles.addAll(articleList);
            mClassArticleAdapter.onDataChange(articles);
            if (mTrlRefresh.isShown()){
                mTrlRefresh.finishLoadmore();
            }
        }
    }

    @OnClick({R.id.img_back_web})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.img_back_web:
                finish();
                break;
        }
    }

}
