package com.wanandroid.tomzem.activity.webview.view;


import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wanandroid.tomzem.R;
import com.wanandroid.tomzem.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class WebViewActivity extends BaseActivity {

    @BindView(R.id.tv_title_web)
    TextView mTvWebViewTitle;

    @BindView(R.id.pb_load_web)
    ProgressBar mPbLoadWeb;

    @BindView(R.id.wv_web_view)
    WebView mWvWebView;

    private WebSettings mWebSettings;
    private String mUrl;
    private String mTitle = "加载中...";

    @Override
    protected int getContentResId() {
        return R.layout.activity_web_view;
    }

    @Override
    public void initView() {
        mWebSettings = mWvWebView.getSettings();
        mUrl = getIntent().getStringExtra("web_view_url");
        mWvWebView.loadUrl(mUrl);
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        mWebSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        mWebSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        mWebSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
        mWebSettings.setLoadsImagesAutomatically(true); //支持自动加载图片

        initWebClient();
    }

    private void initWebClient() {
        //设置不用系统浏览器打开,直接显示在当前Webview
        mWvWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //设置WebChromeClient类
        mWvWebView.setWebChromeClient(new WebChromeClient() {

            //获取网站标题
            @Override
            public void onReceivedTitle(WebView view, String title) {
                mTitle = title;
            }

            //获取加载进度
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress < 100) {
                    mPbLoadWeb.setVisibility(View.VISIBLE);
                    mPbLoadWeb.setProgress(newProgress);
                    mTvWebViewTitle.setText(newProgress + "%" + mTitle);
                } else if (newProgress == 100) {
                    mPbLoadWeb.setVisibility(View.GONE);
                    mTvWebViewTitle.setText(mTitle);
                }
            }
        });
    }

    @Override
    public void initPresenter() {

    }

    @OnClick({R.id.img_back_web})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.img_back_web:
                finish();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWvWebView.canGoBack()) {
            mWvWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //销毁Webview
    @Override
    protected void onDestroy() {
        if (mWvWebView != null) {
            mWvWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWvWebView.clearHistory();
            ((ViewGroup) mWvWebView.getParent()).removeView(mWvWebView);
            mWvWebView.destroy();
            mWvWebView = null;
        }
        super.onDestroy();
    }
}
