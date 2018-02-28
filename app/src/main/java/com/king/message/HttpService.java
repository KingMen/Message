package com.king.message;


import com.king.message.bean.CommonBean;
import com.king.message.bean.IsReg;
import com.king.message.bean.LoginBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by 陈尘 on 2018/2/24.
 */

public interface HttpService {



    //注册  http://www.bwstudent.com/instantMessaging/user/register

    @POST("instantMessaging/user/register")
    Observable<CommonBean> regPhone(@FieldMap HashMap<String,String> hashMap);

    //登录  http://www.bwstudent.com/instantMessaging/user/login
    @GET("instantMessaging/user/login")
    Observable<LoginBean> logInto(@QueryMap HashMap<String,String> hashMap);


    //忘记密码  http://www.bwstudent.com/instantMessaging/user/forgetPassword
    @FormUrlEncoded
    @POST("instantMessaging/user/forgetPassword")
    Observable<CommonBean> forgetPsd(@FieldMap HashMap<String,String> hashMap);

    //手机号是否注册  http://www.bwstudent.com/beidou/user/v1/isRepeatPhone
    @GET("user/v1/isRepeatPhone")
    Observable<IsReg> isReg(@QueryMap HashMap<String,String> hashMap);

    //发送验证码  http://www.bwstudent.com/instantMessaging/user/smsVerification
    @GET("instantMessaging/user/smsVerification")
    Call<CommonBean> getCode(@QueryMap HashMap<String,String> hashMap);
}
