package com.wanandroid.tomzem.activity.login.view;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.dd.processbutton.iml.GenerateProcessButton;
import com.wanandroid.tomzem.R;
import com.wanandroid.tomzem.activity.login.presenter.LoginPresenterImpl;
import com.wanandroid.tomzem.activity.main.MainActivity;
import com.wanandroid.tomzem.base.BaseActivity;
import com.wanandroid.tomzem.utils.SharePrefUtil;
import com.xw.repo.XEditText;


import net.lemonsoft.lemonhello.LemonHello;
import net.lemonsoft.lemonhello.LemonHelloAction;
import net.lemonsoft.lemonhello.LemonHelloInfo;
import net.lemonsoft.lemonhello.LemonHelloView;
import net.lemonsoft.lemonhello.interfaces.LemonHelloActionDelegate;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView{

    @BindView(R.id.btnSignIn)
    GenerateProcessButton mBtnSignIn;

    @BindView(R.id.ed_user_name)
    XEditText mEdUserName;

    @BindView(R.id.ed_password)
    XEditText mEdPassWord;

    @BindView(R.id.ed_password_confirm)
    XEditText mEdPassWordConfirm;

    @BindView(R.id.tv_2_logon)
    TextView mTvLogon;

    private Context mContext;
    private ProgressDialog mProgressDialog;
    private LoginPresenterImpl mLoginPresenterImpl;

    private Boolean FLAG = true; //true  登陆   false  注册

    @Override
    protected int getContentResId() {
        mContext = this;
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        setUserName();
        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FLAG){
                    mLoginPresenterImpl.Login();
                }else{
                    mLoginPresenterImpl.Logon();
                }
            }
        });
    }

    @Override
    public void initPresenter() {
        if (mLoginPresenterImpl ==null){
            mLoginPresenterImpl = new LoginPresenterImpl(this);
        }
    }

    @OnClick({R.id.ll_back, R.id.tv_2_logon})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.ll_back:
                jump2Main();
                break;
            case R.id.tv_2_logon:
                if (FLAG){
                    change2Logon();
                }else{
                    change2Login();
                }
                break;
        }
    }

    private void change2Logon() {
        mEdPassWordConfirm.setVisibility(View.VISIBLE);
        mBtnSignIn.setText("注册");
        mTvLogon.setText("前去登陆");
        FLAG = false;
        reset();

    }

    private void change2Login() {
        mEdPassWordConfirm.setVisibility(View.GONE);
        mBtnSignIn.setText("登陆");
        mTvLogon.setText("前去注册");
        FLAG = true;
    }

    @Override
    public void showDialog(String msg) {
        if (mProgressDialog == null){
            mProgressDialog = new ProgressDialog(mContext);
            mProgressDialog.setMessage(msg);
        }
        if (!mProgressDialog.isShowing()){
            mProgressDialog.show();
        }
    }

    @Override
    public void disMissDialog() {
        if (mProgressDialog != null){
            if (mProgressDialog.isShowing()){
                mProgressDialog.dismiss();
            }
        }
    }

    @Override
    public String getUserName() {
        return mEdUserName.getText().toString().trim();
    }

    @Override
    public String getPassWord() {
        return mEdPassWord.getText().toString().trim();
    }

    @Override
    public String getPassWordConfirm() {
        return mEdPassWordConfirm.getText().toString().trim();
    }

    @Override
    public void jump2Main() {
        Intent intent2Main = new Intent(mContext, MainActivity.class);
        intent2Main.putExtra("pageFlag", 3);
        startActivity(intent2Main);
        finish();
    }

    @Override
    public void showRemindDialog() {
        LemonHello.getSuccessHello("提示", "恭喜您,注册成功!")
                .addAction(new LemonHelloAction("前去登陆", new LemonHelloActionDelegate() {
                    @Override
                    public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                        change2Login();
                        helloView.hide();
                    }
                }))
                .show(mContext);
    }

    public void setUserName(){
        mEdUserName.setText(SharePrefUtil.getString(mContext, "userName",""));
        mEdPassWord.setText(SharePrefUtil.getString(mContext, "passWord",""));
    }

    private void reset(){
        mEdUserName.setText("");
        mEdPassWord.setText("");
        mEdPassWordConfirm.setText("");
    }
}
