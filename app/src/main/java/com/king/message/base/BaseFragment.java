package com.king.message.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 陈尘 on 2018/2/10.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    protected P presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(provideLayoutId(), null);

        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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
}
