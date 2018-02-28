package com.king.message.net;

import com.king.message.HttpService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 陈尘 on 2018/2/24.
 */

public class RetrofitManager {


    private static String baseUrl = "http://www.bwstudent.com/";
    private static RetrofitManager retrofitManager = null;
    private final HttpService service;

    private RetrofitManager(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.connectTimeout(15, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();

        service = retrofit.create(HttpService.class);
    }

    public static RetrofitManager getInstance(){
        if (retrofitManager == null){
            synchronized (RetrofitManager.class){
                if (retrofitManager == null){
                    retrofitManager =  new RetrofitManager();
                }
            }
        }
        return retrofitManager;
    }

    public static HttpService getService(){
        return getInstance().service;
    }
}
