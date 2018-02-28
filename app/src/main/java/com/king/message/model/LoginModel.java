package com.king.message.model;

import com.king.message.bean.Bean;
import com.king.message.bean.IsReg;
import com.king.message.bean.LoginBean;
import com.king.message.net.RetrofitManager;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by 陈尘 on 2018/2/23.
 */

public class LoginModel {


    public void logInto(String phone, String password, String imageVerify, final ILoginModel iLoginModel){

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phoneNumber",phone);
        hashMap.put("password",password);
        hashMap.put("imagevaildate",imageVerify);

        Observable<LoginBean> logInto = RetrofitManager.getService().logInto(hashMap);

        logInto.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        iLoginModel.success(loginBean);
                    }
                });
    }

    public interface ILoginModel{
        void success(LoginBean loginBean);
        void failure(Exception e);
    }


//    public void isReg(final ILoginModel iLoginModel){
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("phone","15231681727");
//
//        Observable<IsReg> observable = RetrofitManager.getService().isReg(hashMap);
//
//
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<IsReg>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(@NonNull IsReg isRegBean) {
//                        iLoginModel.success(isRegBean);
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });



}
