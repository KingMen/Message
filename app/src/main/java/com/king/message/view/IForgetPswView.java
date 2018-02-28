package com.king.message.view;

import com.king.message.base.BaseView;
import com.king.message.bean.CommonBean;

/**
 * Created by 陈尘 on 2018/2/27.
 */

public interface IForgetPswView extends BaseView {
    void success(CommonBean commonBean);
    void failure(Exception e);
}
