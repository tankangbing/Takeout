package com.itheima.takeout.ui.fragment;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.itheima.common.base.BaseFragment;
import com.itheima.common.base.Const;
import com.itheima.common.util.SharedPreUtil;
import com.itheima.takeout.R;
import com.itheima.takeout.ui.activity.LoginActivity;

/**
 * @author WJQ
 */
public class MainFragment4 extends BaseFragment {

    private TextView tvTitle;
    private Button btnLogin;
    private Button btnLogout;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_04;
    }

    @Override
    public void initView() {
        tvTitle = (TextView) findView(R.id.tv_title);
        btnLogin = (Button) findView(R.id.btn_login);
        btnLogout = (Button) findView(R.id.btn_logout);
    }

    @Override
    public void initListener() {
    }

    @Override
    public void initData() {
        checkLogin();
    }

    /** 显示登录状态，根据登录状态显示不同的界面 */
    private void checkLogin() {
        String token = SharedPreUtil.getString(mActivity, Const.SP_TOKEN, "");
        String userName = SharedPreUtil.getString(mActivity, Const.SP_USER_NAME, "");

        if (TextUtils.isEmpty(token)) { // 没有登录
            tvTitle.setText("");        // 用户名置空
            btnLogin.setVisibility(View.VISIBLE);       // 显示登录按钮
            btnLogout.setVisibility(View.GONE);          // 隐藏注销按钮
        } else {    // 已登录
            tvTitle.setText(userName);                  // 显示用户名(实际项目还有其它用户信息)
            btnLogin.setVisibility(View.GONE);          // 隐藏登录按钮
            btnLogout.setVisibility(View.VISIBLE);       // 显示注销按钮
        }
    }

    @Override
    public void onClick(View v, int id) {
        if (id == R.id.btn_login) {         // 登录
            enterLoginActivity();
            return;
        }

        if (id == R.id.btn_logout) {        // 注销
            logout();
            return;
        }
    }

    /** 注销 */
    private void logout() {
    }

    /** 进入登录界面*/
    private void enterLoginActivity() {
        Intent intent = new Intent(mActivity, LoginActivity.class);
        mActivity.startActivityForResult(intent, Const.REQUEST_CODE_MINE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (Const.REQUEST_CODE_MINE == requestCode) {
            // 重新检测登录状态，并刷新界面
            checkLogin();
        }
    }
}
