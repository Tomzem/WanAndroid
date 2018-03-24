package com.wanandroid.tomzem.base;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.trello.rxlifecycle.LifecycleProvider;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.android.ActivityEvent;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

/**
 *  Activity基类
 *
 *  @author Hunter
 */
public abstract class BaseActivity extends RxAppCompatActivity implements IBaseView {
    private Toast toast;
    private ProgressDialog mProgressDialog;


    protected abstract int getContentResId();

    /**
     * 初始化控件
     */
    public abstract void initView();

    /**
     * 初始化控制中心
     */
    public abstract void initPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentResId());
        // 初始化View注入
        ButterKnife.bind(this);
        initPresenter();
        initView();
    }


    @Override
    public void finish() {
        super.finish();
    }

    @Override
    public void showProgress(boolean flag, String message) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(flag);
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setMessage(message);
        }

        mProgressDialog.show();
    }

    @Override
    public void showProgress(String message) {
        showProgress(true, message);
    }

    @Override
    public void setProgressCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        if (mProgressDialog != null) {
            mProgressDialog.setOnCancelListener(onCancelListener);
        }
    }

    @Override
    public void hideProgress() {
        if (mProgressDialog == null)
            return;

        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        if (!isFinishing()) {
            if (toast == null) {
                toast = Toast.makeText(this.getApplicationContext(), msg, Toast.LENGTH_SHORT);
            } else {
                toast.setText(msg);
            }

            toast.show();
        }
    }

    @Override
    public <T> LifecycleTransformer<T> bind() {
        return bindToLifecycle();
    }
}
