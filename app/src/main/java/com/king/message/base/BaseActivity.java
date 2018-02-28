package com.king.message.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by 陈尘 on 2018/2/10.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //加载布局
        setContentView(provideLayoutId());
        ButterKnife.bind(this);
        initView();
        initListener();
        presenter = providePresenter();
        initData();
    }

    protected abstract P providePresenter();

    protected void initListener() {

    }

    protected void initData(){

    }


    protected void initView() {

    }

    public abstract int provideLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
