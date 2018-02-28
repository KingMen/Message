package com.king.message.view;

import com.king.message.base.BaseView;
import com.king.message.bean.Bean;
import com.king.message.bean.IsReg;
import com.king.message.bean.LoginBean;

/**
 * Created by 陈尘 on 2018/2/10.
 */

public interface ILoginView extends BaseView{
    void success(LoginBean loginBean);
    void failure(Exception e);
}
