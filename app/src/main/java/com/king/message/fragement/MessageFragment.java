package com.king.message.fragement;

import com.king.message.R;
import com.king.message.base.BaseFragment;
import com.king.message.base.BasePresenter;

/**
 * Created by 陈尘 on 2018/2/25.
 */

public class MessageFragment extends BaseFragment{
    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    public int provideLayoutId() {
        return R.layout.fragment_message;
    }
}
