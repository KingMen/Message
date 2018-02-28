package com.king.message.model;

import com.king.message.bean.CommonBean;
import com.king.message.net.RetrofitManager;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈尘 on 2018/2/27.
 */

public class ForgetPsdModel {



    public void forgetPsd(String phone, String verify, String password, String password1, final IForgetPsdModel iForgetPsdModel){
        HashMap<String, String> hashMap = new HashMap<>();


        hashMap.put("phoneNumber",phone);
        hashMap.put("verify",verify);
        hashMap.put("password",password);
        hashMap.put("password1",password1);


        Observable<CommonBean> forgetPsd = RetrofitManager.getService().forgetPsd(hashMap);

        forgetPsd.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CommonBean>() {
                    @Override
                    public void accept(CommonBean commonBean) throws Exception {
                        iForgetPsdModel.success(commonBean);
                    }
                });
    }

    public interface IForgetPsdModel{
        void success(CommonBean commonBean);
        void failure(Exception e);
    }
}
