package com.itheima.takeout.presenter;

import com.itheima.takeout.base.BasePresenter;
import com.itheima.takeout.base.BaseView;

/**
 * @author admin
 */
public class LoginFragment1Presenter extends BasePresenter {

    public LoginFragment1Presenter(BaseView baseView) {
        super(baseView);
    }

    /** 登录:使用电话号码 */
    public void login(String phone) {
        mProtocol.login(mBaseCallback, phone);
    }
}










