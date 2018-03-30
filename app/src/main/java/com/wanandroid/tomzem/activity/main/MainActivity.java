package com.wanandroid.tomzem.activity.main;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.wanandroid.tomzem.R;
import com.wanandroid.tomzem.base.BaseActivity;
import com.wanandroid.tomzem.fragmentlayout.FragmentClass.view.FragmentClass;
import com.wanandroid.tomzem.fragmentlayout.FragmentIndex.view.FragmentIndex;
import com.wanandroid.tomzem.fragmentlayout.FragmentNavigation.view.FragmentNavigation;
import com.wanandroid.tomzem.fragmentlayout.FragmentSelf.view.FragmentSelf;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.frame_main)
    FrameLayout mFrameMain;

    @BindView(R.id.ibt_index)
    ImageButton mImgButtonIndex;

    @BindView(R.id.ibt_class)
    ImageButton mImgButtonClass;

    @BindView(R.id.ibt_navigation)
    ImageButton mImgButtonNavigation;

    @BindView(R.id.ibt_self)
    ImageButton mImgButtonSelf;

    @BindView(R.id.tv_index)
    TextView mTvIndex;

    @BindView(R.id.tv_class)
    TextView mTvClass;

    @BindView(R.id.tv_navigation)
    TextView mTvNavigation;

    @BindView(R.id.tv_self)
    TextView mTvSelf;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    private Context mContext;

    private FragmentIndex mFragmentIndex;
    private FragmentClass mFragmentClass;
    private FragmentNavigation mFragmentNavigation;
    private FragmentSelf mFragmentSelf;

    @Override
    protected int getContentResId() {
        mContext = this;
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        setSelect(0);
    }

    @Override
    public void initPresenter() {

    }

    @OnClick({R.id.tab_index,R.id.tab_class,R.id.tab_navigation,R.id.tab_self})
    public void onClickTab(View view){
        switch(view.getId()){
            case R.id.tab_index:setSelect(0);break;
            case R.id.tab_class:setSelect(1);break;
            case R.id.tab_navigation:setSelect(2);break;
            case R.id.tab_self:setSelect(3);break;
        }
    }

    private void setSelect(int i) {
        resetImg();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                if (mFragmentIndex==null){
                    mFragmentIndex = new FragmentIndex();
                    transaction.add(R.id.frame_main,mFragmentIndex);
                }
                mTvIndex.setTextColor(getResources().getColor(R.color.colorPrimary));
                mImgButtonIndex.setImageResource(R.mipmap.ic_index_select);
                transaction.show(mFragmentIndex);
                mTvTitle.setText("主页");
                break;
            case 1:
                if (mFragmentClass ==null){
                    mFragmentClass = new FragmentClass();
                    transaction.add(R.id.frame_main, mFragmentClass);
                }
                mTvClass.setTextColor(getResources().getColor(R.color.colorPrimary));
                mImgButtonClass.setImageResource(R.mipmap.ic_class_select);
                transaction.show(mFragmentClass);
                mTvTitle.setText("分类");
                break;
            case 2:
                if (mFragmentNavigation ==null){
                    mFragmentNavigation = new FragmentNavigation();
                    transaction.add(R.id.frame_main, mFragmentNavigation);
                }
                mTvNavigation.setTextColor(getResources().getColor(R.color.colorPrimary));
                mImgButtonNavigation.setImageResource(R.mipmap.ic_navigation_select);
                transaction.show(mFragmentNavigation);
                mTvTitle.setText("项目");
                break;
            case 3:
                if (mFragmentSelf ==null){
                    mFragmentSelf = new FragmentSelf();
                    transaction.add(R.id.frame_main, mFragmentSelf);
                }
                mTvSelf.setTextColor(getResources().getColor(R.color.colorPrimary));
                mImgButtonSelf.setImageResource(R.mipmap.ic_self_select);
                transaction.show(mFragmentSelf);
                mTvTitle.setText("个人");
                break;
        }
        transaction.commit();
    }

    /**
     * 将所有Fragment隐藏起来
     * @param transaction
     */
    private void hideFragment(FragmentTransaction transaction) {
        if (mFragmentIndex!=null){
            transaction.hide(mFragmentIndex);
        }
        if (mFragmentClass!=null){
            transaction.hide(mFragmentClass);
        }
        if(mFragmentNavigation!=null) {
            transaction.hide(mFragmentNavigation);
        }
        if(mFragmentSelf!=null){
            transaction.hide(mFragmentSelf);
        }
    }

    /**
     * 将所有图片切换成暗色
     */
    private void resetImg() {
        mImgButtonIndex.setImageResource(R.mipmap.ic_index_normal);
        mImgButtonClass.setImageResource(R.mipmap.ic_class_normal);
        mImgButtonNavigation.setImageResource(R.mipmap.ic_navigation_normal);
        mImgButtonSelf.setImageResource(R.mipmap.ic_self_normal);
        mTvIndex.setTextColor(getResources().getColor(R.color.colorBlack));
        mTvClass.setTextColor(getResources().getColor(R.color.colorBlack));
        mTvNavigation.setTextColor(getResources().getColor(R.color.colorBlack));
        mTvSelf.setTextColor(getResources().getColor(R.color.colorBlack));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode>=-1 || requestCode<4){
            setSelect(requestCode);
        }else{
            setSelect(0);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
