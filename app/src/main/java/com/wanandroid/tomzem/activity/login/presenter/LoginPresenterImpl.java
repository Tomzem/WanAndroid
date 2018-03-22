package com.wanandroid.tomzem.activity.login.presenter;

import com.wanandroid.tomzem.activity.login.OnLoginListener;
import com.wanandroid.tomzem.activity.login.model.LoginModelImpl;
import com.wanandroid.tomzem.activity.login.view.LoginActivity;
import com.wanandroid.tomzem.app.APPControl;
import com.wanandroid.tomzem.utils.SharePrefUtil;

/**
 * Created by Tomzem on 2018/3/18.
 */

public class LoginPresenterImpl implements LoginPresenter{

    private LoginModelImpl mLoginModelImpl;
    private LoginActivity mLoginActivity;
    private String name = "";
    private String password = "";
    private String passwordConfim = "";

    public LoginPresenterImpl(LoginActivity mLoginActivity){
        this.mLoginActivity = mLoginActivity;
        mLoginModelImpl = new LoginModelImpl();
    }


    @Override
    public void Login() {
        mLoginActivity.showDialog("正在登陆...");
        getUserInfo();
        mLoginModelImpl.Login(name, password, new OnLoginListener() {
            @Override
            public void OnSeccess() {
                mLoginActivity.disMissDialog();
                mLoginActivity.showToast("登陆成功");
                saveUserInfo(name, password);
                mLoginActivity.jump2Main();
            }

            @Override
            public void OnFailure(String msg) {
                mLoginActivity.disMissDialog();
                mLoginActivity.showToast(msg);
            }
        });
    }

    @Override
    public void Logon() {
        mLoginActivity.showDialog("正在注册...");
        getUserInfo();
        mLoginModelImpl.Logon(name, password, passwordConfim, new OnLoginListener() {
            @Override
            public void OnSeccess() {
                mLoginActivity.disMissDialog();
                mLoginActivity.showRemindDialog();
            }

            @Override
            public void OnFailure(String msg) {
                mLoginActivity.disMissDialog();
                mLoginActivity.showToast(msg);
            }
        });
    }

    private void saveUserInfo(String name, String password) {
        APPControl.USER_NAME = name;
        APPControl.IS_LOGIN = true;
        SharePrefUtil.saveBoolean(mLoginActivity, "islogin", true);
        SharePrefUtil.saveString(mLoginActivity,"userName", name);
        SharePrefUtil.saveString(mLoginActivity,"passWord", password);
    }

    private void getUserInfo(){
        name = mLoginActivity.getUserName();
        password = mLoginActivity.getPassWord();
        passwordConfim = mLoginActivity.getPassWordConfirm();
    }

}
