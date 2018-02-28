package com.king.message.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.king.message.R;
import com.king.message.base.BaseActivity;
import com.king.message.bean.CommonBean;
import com.king.message.net.RetrofitManager;
import com.king.message.presenter.ForgetPsdPresenter;
import com.king.message.view.IForgetPswView;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 陈尘 on 2018/2/27.
 */

public class ForgetPsdActivity extends BaseActivity<ForgetPsdPresenter> implements IForgetPswView {


    @Bind(R.id.edit_phone)
    EditText editPhone;
    @Bind(R.id.edit_code)
    EditText editCode;
    @Bind(R.id.edit_password)
    EditText editPassword;
    @Bind(R.id.edit_password1)
    EditText editPassword1;

    @Override
    public Context context() {
        return this;
    }

    @Override
    protected ForgetPsdPresenter providePresenter() {
        return new ForgetPsdPresenter(this);
    }

    @Override
    public int provideLayoutId() {
        return R.layout.activity_forget;
    }

    public void getCode(View view){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phoneNumber",editPhone.getText().toString().trim());
        hashMap.put("type","2");
        Call<CommonBean> code = RetrofitManager.getService().getCode(hashMap);
        code.enqueue(new Callback<CommonBean>() {
            @Override
            public void onResponse(Call<CommonBean> call, Response<CommonBean> response) {
                CommonBean body = response.body();
                Toast.makeText(ForgetPsdActivity.this, body.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CommonBean> call, Throwable t) {

            }
        });
    }

    public void btnChange(View view) {
        presenter.forgetPsd(editPhone.getText().toString().trim(),
                editCode.getText().toString().trim(),
                editPassword.getText().toString().trim(),
                editPassword1.getText().toString().trim());
    }

    @Override
    public void success(CommonBean commonBean) {
        if (commonBean.getStatus().equals("0000")){
            Toast.makeText(this, commonBean.getMessage(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ForgetPsdActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void failure(Exception e) {

    }



}
