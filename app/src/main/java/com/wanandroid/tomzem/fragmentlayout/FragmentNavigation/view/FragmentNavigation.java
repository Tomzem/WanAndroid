package com.wanandroid.tomzem.fragmentlayout.FragmentNavigation.view;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.wanandroid.tomzem.R;
import com.wanandroid.tomzem.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Tomzem on 2018/3/17.
 */

public class FragmentNavigation extends BaseFragment implements OnTabSelectListener {

    private final String[] mTitles = {
            "热门", "iOS", "Android"
            , "前端", "后端", "设计", "工具资源"
    };

    @BindView(R.id.tl_2)
    SlidingTabLayout tabLayout_2;

    @BindView(R.id.vp)
    ViewPager vp;

    private MyPagerAdapter mAdapter;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private Context mContext;

    @Override
    public void setProgressCancelListener(DialogInterface.OnCancelListener onCancelListener) {

    }

    @Override
    public int getLayoutRes() {
        mContext = this.getContext();
        return R.layout.fragment_navigation;
    }

    @Override
    public void initView() {
        for (String title : mTitles) {
            mFragments.add(FragmentNavigationList.getInstance(title));
        }
        mAdapter = new MyPagerAdapter(this.getChildFragmentManager());
        vp.setAdapter(mAdapter);

        tabLayout_2.setViewPager(vp);
        tabLayout_2.setOnTabSelectListener(this);
    }

    @Override
    public void onTabSelect(int position) {
        showToast(mTitles[position]);
    }

    @Override
    public void onTabReselect(int position) {
        showToast(""+position);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
