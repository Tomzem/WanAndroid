package com.wanandroid.tomzem.activity.loadpage.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wanandroid.tomzem.R;
import com.wanandroid.tomzem.activity.main.MainActivity;
import com.wanandroid.tomzem.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

public class LoadPageActivity extends BaseActivity {

    private Timer timer;

    @Override
    protected int getContentResId() {
        return R.layout.activity_load_page;
    }

    @Override
    public void initView() {
        toNextActivity();
//        countNum();
    }

    @Override
    public void initPresenter() {

    }

    private void countNum() {//数秒
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toNextActivity();
            }
        }, 3000);
    }

    public void toNextActivity() {//根据是否保存有 token 判断去登录界面还是主界面
        Intent intent = new Intent(LoadPageActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (timer != null){
            timer.cancel();
        }
    }
}
