package com.itheima.takeout.ui.fragment;

import android.app.Activity;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.itheima.common.base.BaseFragment;
import com.itheima.common.base.Const;
import com.itheima.common.ui.EditLayout;
import com.itheima.common.util.MD5;
import com.itheima.common.util.SharedPreUtil;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.Login;
import com.itheima.takeout.model.protocol.IHttpService;
import com.itheima.takeout.presenter.LoginFragment2Presenter;
import com.squareup.picasso.Picasso;

/**
 * 账号密码登录
 *
 * @author admin
 */
public class LoginFragment2 extends BaseFragment {

    private LoginFragment2Presenter mPresenter;

    private EditLayout elUsername;
    private EditLayout elPassword;
    private Button btnLogin;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_login_02;
    }

    @Override
    public void initView() {
        elUsername = (EditLayout) findView(R.id.el_username);
        elPassword = (EditLayout) findView(R.id.el_password);
        btnLogin = (Button) findView(R.id.btn_login);
        elUsername.setHint("请输入账号/电话号/邮箱");
        elPassword.setHint("请输入密码");
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        mPresenter = new LoginFragment2Presenter(this);
    }

    @Override
    public void onClick(View v, int id) {
        if (id == R.id.btn_login)  {        // 登录
            login();
            return;
        }
    }

    private void login() {
        String username = elUsername.getText();
        String password = elPassword.getText();

        if (TextUtils.isEmpty(username)) {
            showToast("请输入账号");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            showToast("请输入密码");
            return;
        }

        mActivity.showProgressDialog("正在登录...");
        // 密码需要md5后再传输
        mPresenter.login(username, MD5.getMessageDigest(password.getBytes()));
    }

    @Override
    public void onHttpSuccess(int reqType, Message msg) {
        if (reqType == IHttpService.TYPE_LOGIN_2) {
            mActivity.dismissProgressDialog();
            // 登录成功，返回主界面，并显示用户个人信息
            Login login = (Login) msg.obj;

            // 保存token,用启名和其它用户相关信息
            SharedPreUtil.saveString(mActivity, Const.SP_TOKEN, login.getToken());
            SharedPreUtil.saveString(mActivity, Const.SP_USER_NAME, login.getUsername());
            // 回到主界面，显示用户信息
            mActivity.setResult(Activity.RESULT_OK);
            mActivity.finish();     // 退出登录界面
        }
    }
}












