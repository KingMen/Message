package com.king.message.activity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.king.message.MainActivity;
import com.king.message.R;
import com.king.message.base.BaseActivity;
import com.king.message.bean.CommonBean;
import com.king.message.net.RetrofitManager;
import com.king.message.presenter.RegisterPresenter;
import com.king.message.view.IRegisterView;

import java.util.HashMap;

import butterknife.Bind;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 陈尘 on 2018/2/23.
 */

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements IRegisterView {
    @Bind(R.id.edit_phone)
    EditText editPhone;
    @Bind(R.id.edit_password)
    EditText editPassword;
    @Bind(R.id.edit_password1)
    EditText editPassword1;
    @Bind(R.id.edit_name)
    EditText editName;
    @Bind(R.id.edit_code)
    EditText editCode;

    @Override
    protected RegisterPresenter providePresenter() {
        return new RegisterPresenter(this);
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    public int provideLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public Context context() {
        return this;
    }


    public void btnRegister(View view){
        presenter.regPhone(editPhone.getText().toString().trim(),
                editPassword.getText().toString().trim(),
                editPassword1.getText().toString().trim(),
                editName.getText().toString().trim(),
                editCode.getText().toString().trim());
    }
    @Override
    public void success(CommonBean commonBean) {
        if (commonBean.getStatus().equals("0000")){
            Toast.makeText(this, commonBean.getMessage(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        
        }
    }

    @Override
    public void failure(Exception e) {
        Log.i("reg",String.valueOf(e));
    }


    public void getCode(View view) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phoneNumber", editPhone.getText().toString().trim());
        hashMap.put("type", "1");

        Call<CommonBean> code = RetrofitManager.getService().getCode(hashMap);

        code.enqueue(new Callback<CommonBean>() {
            @Override
            public void onResponse(Call<CommonBean> call, Response<CommonBean> response) {
                CommonBean body = response.body();
                Toast.makeText(RegisterActivity.this, body.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CommonBean> call, Throwable t) {
                Log.i("failure", ":" + t);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

}
