package com.wanandroid.tomzem.fragmentlayout.FragmentSelf.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.lzy.widget.PullZoomView;
import com.wanandroid.tomzem.R;
import com.wanandroid.tomzem.activity.login.view.LoginActivity;
import com.wanandroid.tomzem.app.APPControl;
import com.wanandroid.tomzem.app.BaseApplication;
import com.wanandroid.tomzem.base.BaseFragment;
import com.wanandroid.tomzem.utils.SharePrefUtil;

import net.lemonsoft.lemonhello.LemonHello;
import net.lemonsoft.lemonhello.LemonHelloAction;
import net.lemonsoft.lemonhello.LemonHelloInfo;
import net.lemonsoft.lemonhello.LemonHelloView;
import net.lemonsoft.lemonhello.interfaces.LemonHelloActionDelegate;

import butterknife.BindView;
import butterknife.OnClick;
import info.hoang8f.widget.FButton;

/**
 * Created by Tomzem on 2018/3/17.
 */

public class FragmentSelf extends BaseFragment{

    private static final String TAG = "FragmentSelf";

    @BindView(R.id.pzv_self)
    PullZoomView mPullZoomView;

    @BindView(R.id.fbt_self_login)
    FButton mFbLogin;

    @BindView(R.id.tv_user_name)
    TextView mTvUserName;

    private Context mContext;

    @Override
    public void setProgressCancelListener(DialogInterface.OnCancelListener onCancelListener) {

    }

    @Override
    public int getLayoutRes() {
        mContext = this.getActivity();
        return R.layout.fragment_self;
    }

    @Override
    public void initView() {
        mPullZoomView.setIsParallax(false);    //允许视差动画
        mPullZoomView.setIsZoomEnable(true);  //允许头部放大
        mPullZoomView.setSensitive(2.0f);     //敏感度1.5
        mPullZoomView.setZoomTime(700);       //头部缩放时间500毫秒
    }

    @OnClick({R.id.fbt_self_collection,R.id.fbt_self_about,R.id.fbt_self_login})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.fbt_self_collection:

                break;
            case R.id.fbt_self_about:break;
            case R.id.fbt_self_login:
                if(APPControl.IS_LOGIN){
                    LoginOut();
                }else{
                    Intent intent = new Intent(mContext, LoginActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

    private void LoginOut() {

        LemonHello.getInformationHello("提示","确定注销登陆？")
                .addAction(new LemonHelloAction("取消",
                        new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView lemonHelloView, LemonHelloInfo lemonHelloInfo, LemonHelloAction lemonHelloAction) {
                                lemonHelloView.hide();
                            }
                        }))
                .addAction(new LemonHelloAction("确定",Color.RED,
                        new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView lemonHelloView, LemonHelloInfo lemonHelloInfo, LemonHelloAction lemonHelloAction) {
                                APPControl.IS_LOGIN = false;
                                SharePrefUtil.clear(mContext);
                                mFbLogin.setButtonColor(getResources().getColor(R.color.fbutton_color_peter_river));
                                mFbLogin.setText("前往登陆");
                                setUserName();
                                lemonHelloView.hide();
                            }
                        }))
                .show(mContext);

    }

    @Override
    public void onStart() {
        super.onStart();
        setUserName();
        if (APPControl.IS_LOGIN){
            mFbLogin.setButtonColor(getResources().getColor(R.color.fbutton_color_alizarin));
            mFbLogin.setText("注销登陆");
        }
    }

    private void setUserName(){
        mTvUserName.setText(SharePrefUtil.getString(mContext, "userName", "WanAndroid"));
    }
}
