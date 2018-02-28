package com.king.message.presenter;

import android.widget.ListView;

import com.king.message.base.BasePresenter;
import com.king.message.bean.Bean;
import com.king.message.bean.IsReg;
import com.king.message.bean.LoginBean;
import com.king.message.model.LoginModel;
import com.king.message.view.ILoginView;

/**
 * Created by 陈尘 on 2018/2/10.
 */

public class LoginPresenter extends BasePresenter<ILoginView>{

    private LoginModel loginModel;

    public LoginPresenter(ILoginView view) {
        super(view);
    }

    @Override
    protected void initModel() {
        loginModel = new LoginModel();
    }


    public void logInto(String phone, String password, String imageVerify){

        loginModel.logInto(phone, password, imageVerify, new LoginModel.ILoginModel() {
            @Override
            public void success(LoginBean loginBean) {
                if (view != null){
                    view.success(loginBean);
                }
            }

            @Override
            public void failure(Exception e) {

            }
        });
    }





    }
