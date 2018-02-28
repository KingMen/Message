package com.king.message.presenter;

import com.king.message.base.BasePresenter;
import com.king.message.bean.CommonBean;
import com.king.message.model.ForgetPsdModel;
import com.king.message.view.IForgetPswView;

/**
 * Created by 陈尘 on 2018/2/27.
 */

public class ForgetPsdPresenter extends BasePresenter<IForgetPswView>{
    private ForgetPsdModel forgetPsdModel;
    public ForgetPsdPresenter(IForgetPswView view) {
        super(view);
    }

    @Override
    protected void initModel() {
        forgetPsdModel = new ForgetPsdModel();
    }

    public void forgetPsd(String phone, final String verify, String password, String password1){
        forgetPsdModel.forgetPsd(phone, verify, password, password1, new ForgetPsdModel.IForgetPsdModel() {
            @Override
            public void success(CommonBean commonBean) {
                if (view != null){
                    view.success(commonBean);
                }
            }

            @Override
            public void failure(Exception e) {

            }
        });
    }
}
