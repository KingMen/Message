package com.king.message.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.king.message.app.IApplication;

import java.lang.ref.WeakReference;

/**
 * Created by 陈尘 on 2018/2/10.
 */

public abstract class BasePresenter<V extends BaseView>  {

    protected V view;
    protected WeakReference weakReference;

    public BasePresenter(V view) {
        this.view = view;
        this.weakReference = new WeakReference(view);
        initModel();
    }

    protected abstract void initModel();


    public void detach(){
        weakReference.clear();
    }

    public Context context(){
        if (view != null && view.context() != null){
            return view.context();
        }
        return IApplication.getApplication();
    }


}
