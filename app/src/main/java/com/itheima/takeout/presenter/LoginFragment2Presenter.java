package com.itheima.takeout.presenter;

import com.itheima.takeout.base.BasePresenter;
import com.itheima.takeout.base.BaseView;

/**
 * @author admin
 */
public class LoginFragment2Presenter extends BasePresenter {

    public LoginFragment2Presenter(BaseView baseView) {
        super(baseView);
    }

    /** 登录:使用账号密码登录 */
    public void login(String username, String password) {
        mProtocol.login(mBaseCallback, username, password);
    }
}










