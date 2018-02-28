package com.king.message.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.king.message.MainActivity;
import com.king.message.R;
import com.king.message.base.BaseActivity;
import com.king.message.bean.Bean;
import com.king.message.bean.IsReg;
import com.king.message.bean.LoginBean;
import com.king.message.presenter.LoginPresenter;
import com.king.message.utils.AllCapTransformationMethod;
import com.king.message.view.ILoginView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginView {


    @Bind(R.id.edit_account)
    EditText editAccount;
    @Bind(R.id.edit_password)
    EditText editPassword;
    @Bind(R.id.edit_code)
    EditText editCode;
    @Bind(R.id.image_verify)
    ImageView imageVerify;

    private String imageVerifyUrl = "http://www.bwstudent.com/instantMessaging/user/verification";

    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    public int provideLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        super.initData();
        getImageVerify();
        imageVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImageVerify();
            }
        });
    }


    //登录
    public void btnLogin(View view) {

        presenter.logInto(editAccount.getText().toString().trim(),
                editPassword.getText().toString().trim(),
                editCode.getText().toString().trim());

    }

    //验证码图片
    public void getImageVerify(){

        Glide.with(this)
                .load(imageVerifyUrl)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(imageVerify);
    }

    //新用户注册
    public void btnRegister(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    //忘记密码
    public void btnForget(View view){
        Intent intent = new Intent(LoginActivity.this, ForgetPsdActivity.class);
        startActivity(intent);
    }

    @Override
    public Context context() {
        return this;
    }


    @Override
    public void success(LoginBean loginBean) {
        if (loginBean.getStatus().equals("0000")){
            Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
            System.out.println("sessionId - >"+loginBean.getResult().getSessionId());
            System.out.println("userId - >"+loginBean.getResult().getUserId());
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void failure(Exception e) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }



}
