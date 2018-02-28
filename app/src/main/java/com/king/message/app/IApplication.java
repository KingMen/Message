package com.king.message.app;

import android.app.Application;

/**
 * Created by 陈尘 on 2018/2/10.
 */

public class IApplication extends Application{

    public static IApplication mApplication;
    @Override
    public void onCreate() {
        super.onCreate();

        mApplication = this;
    }

    public static IApplication getApplication(){
        return mApplication;
    }
}
