package com.king.message.presenter;

import com.king.message.base.BasePresenter;
import com.king.message.bean.CommonBean;
import com.king.message.model.RegisterModel;
import com.king.message.view.IRegisterView;

/**
 * Created by 陈尘 on 2018/2/23.
 */

public class RegisterPresenter extends BasePresenter<IRegisterView>{
    private RegisterModel registerModel;
    public RegisterPresenter(IRegisterView view) {
        super(view);
    }

    @Override
    protected void initModel() {
       registerModel =  new RegisterModel();
    }



    public void regPhone(String phone, String password, String password1, String realName,final String verify){


        registerModel.regPhone(phone, password, password1, realName, verify,  new RegisterModel.IRegisterModel() {
            @Override
            public void success(CommonBean commonBean) {
                if (view != null){
                    view.success(commonBean);
                }
            }

            @Override
            public void failure(Exception e) {
                    view.failure(e);
            }
        });

    }



}
