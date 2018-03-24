package com.wanandroid.tomzem.fragmentlayout.FragmentClass.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wanandroid.tomzem.R;
import com.wanandroid.tomzem.adapter.ClassAdapter;
import com.wanandroid.tomzem.base.BaseFragment;
import com.wanandroid.tomzem.bean.ClassDatas;
import com.wanandroid.tomzem.fragmentlayout.FragmentClass.presenter.FragmentClassPresenterImpl;

import java.util.List;
import java.util.Timer;

import butterknife.BindView;
import iammert.com.expandablelib.ExpandCollapseListener;
import iammert.com.expandablelib.ExpandableLayout;
import iammert.com.expandablelib.Section;

/**
 * Created by Tomzem on 2018/3/17.
 */

public class FragmentClass extends BaseFragment implements FragmentClassView{

    @BindView(R.id.el_class_list)
    ExpandableLayout mElClassList;

    private Context mContext;
    private ClassAdapter classAdapter;
    private FragmentClassPresenterImpl fragmentClassPresenter;

    @Override
    public void setProgressCancelListener(DialogInterface.OnCancelListener onCancelListener) {

    }

    @Override
    public int getLayoutRes() {
        mContext = this.getActivity();
        fragmentClassPresenter = new FragmentClassPresenterImpl(this);
        return R.layout.fragment_class;
    }


    @Override
    public void initView() {
        classAdapter = new ClassAdapter(mElClassList);
        mElClassList.setRenderer(new ExpandableLayout.Renderer<ClassDatas, ClassDatas>() {
            @Override
            public void renderParent(View view, ClassDatas model, boolean isExpanded, int parentPosition) {
                ((TextView) view.findViewById(R.id.tvParent)).setText(model.getName());
                ImageView imageView = view.findViewById(R.id.arrow);
                imageView.setBackgroundResource(R.drawable.ic_arrow_down);
            }

            @Override
            public void renderChild(View view, final ClassDatas model, int parentPosition, final int childPosition) {
                Animation animation= AnimationUtils.loadAnimation(mContext, R.anim.scale);
                view.startAnimation(animation);
                ((TextView) view.findViewById(R.id.tvChild)).setText(model.getName());
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showToast(model.getName());
                    }
                });
            }
        });

        initData();
    }

    private void initData() {
        fragmentClassPresenter.getClassDatas();
    }

    @Override
    public void returnClassData(final List<ClassDatas> data) {
        classAdapter.setData(data);
    }
}