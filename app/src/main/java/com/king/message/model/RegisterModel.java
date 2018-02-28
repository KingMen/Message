package com.king.message.model;

import com.king.message.bean.CommonBean;
import com.king.message.net.RetrofitManager;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 陈尘 on 2018/2/23.
 */

public class RegisterModel {


    public void regPhone(String phone, String password, String password1, String realName, String verify, final IRegisterModel iRegisterModel){

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phoneNumber",phone);
        hashMap.put("password",password);
        hashMap.put("password1",password1);
        hashMap.put("realName",realName);
        hashMap.put("verify",verify);

        Observable<CommonBean> regPhone = RetrofitManager.getService().regPhone(hashMap);

        regPhone.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CommonBean>() {
                    @Override
                    public void accept(CommonBean commonBean) throws Exception {
                        iRegisterModel.success(commonBean);
                    }
                });

    }


    public interface IRegisterModel{
        void success(CommonBean commonBean);

        void failure(Exception e);
    }
}
