package com.itheima.takeout.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.itheima.common.base.BaseFragment;
import com.itheima.common.base.Const;
import com.itheima.common.base.Global;
import com.itheima.common.base.OttoBus;
import com.itheima.common.ui.EditLayout;
import com.itheima.common.util.SharedPreUtil;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.Login;
import com.itheima.takeout.model.protocol.IHttpService;
import com.itheima.takeout.presenter.LoginFragment1Presenter;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

import static android.R.attr.countDown;
import static cn.smssdk.SMSSDK.registerEventHandler;

/**
 * 短信快捷登录
 *
 * @author admin
 */
public class LoginFragment1 extends BaseFragment {

    private LinearLayout llInputPhone;
    private EditLayout elPhone;
    private Button btnGetSmsCode;
    private LinearLayout llInputSmsCode;
    private TextView tvPhone;
    private EditLayout elInputSmsCode;
    private Button btnResend;
    private Button btnCommit;

    /** 电话号码 */
    private String phone;

    private LoginFragment1Presenter mPresenter;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_login_01;
    }

    @Override
    public void initView() {
        llInputPhone = (LinearLayout) findView(R.id.ll_input_phone);
        llInputSmsCode = (LinearLayout) findView(R.id.ll_input_sms_code);
        elPhone = (EditLayout) findView(R.id.el_phone);
        btnGetSmsCode = (Button) findView(R.id.btn_get_sms_code);
        tvPhone = (TextView) findView(R.id.tv_phone);
        elInputSmsCode = (EditLayout) findView(R.id.el_input_sms_code);
        btnResend = (Button) findView(R.id.btn_resend);
        btnCommit = (Button) findView(R.id.btn_commit);

        elPhone.setHint("请输入电话号码");
        elInputSmsCode.setHint("请输入短信验证码");
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        mPresenter = new LoginFragment1Presenter(this);
    }

    @Override
    public void onClick(View v, int id) {
        if (id == R.id.btn_get_sms_code) {      // 获取短信验证码
            getSmsCode();
            return;
        }

        if (id == R.id.btn_resend) {            // 重新发送短信验证码
            getSmsCode();
            btnResend.setEnabled(false);        // 按钮不可点
            return;
        }

        if (id == R.id.btn_commit) {            // 提交验证码
            commitSmsCode();
            return;
        }
    }

    /** 提交短信验证码 */
    private void commitSmsCode() {
        String smsCode = elInputSmsCode.getText();
        if (TextUtils.isEmpty(smsCode)) {
            showToast("请输入短信验证码");
            return;
        }

        // 发请求，提交验证码到服务器进行验证
        // submitVerificationCode(String country, String phone, String code)
        SMSSDK.submitVerificationCode("86", phone, smsCode);

        mActivity.showProgressDialog("正在验证...");

        /*// 模拟代码：
        Global.getMainHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mActivity.dismissProgressDialog();
                // 验证通过，使用电话号码登录到服务器
                login();
            }
        }, 3000); */      // 3秒后下发了验证码
    }

    /** 验证通过，使用电话号码登录到服务器*/
    private void login() {
        mActivity.showProgressDialog("正在登录...");
        mPresenter.login(phone);
    }

    /** 获取短信验证码*/
    private void getSmsCode() {
        phone = elPhone.getText();

        if (TextUtils.isEmpty(phone)) {
            showToast("请输入电话号码");
            return;
        }

        // 发请求，获取验证码
        // 	getVerificationCode(String country, String phone)
        SMSSDK.getVerificationCode("86", phone);
        mActivity.showProgressDialog("正在获取验证码...");

        /*// 模拟代码：
        Global.getMainHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mActivity.dismissProgressDialog();
                onGetSmsCodeSuccess();
            }
        }, 3000);       // 3秒后下发了验证码*/
    }

    /** 获取验证码成功 */
    private void onGetSmsCodeSuccess() {
        llInputPhone.setVisibility(View.GONE);
        llInputSmsCode.setVisibility(View.VISIBLE);
        tvPhone.setText(phone);

        btnResend.setEnabled(false);    // 重发按钮不可用
        countDown();                    // 倒计时60秒
    }

    //============倒计时60秒(begin)===================
    private static final int MAX_SECOND = 10;
    private static final int WHAT_COUNT_DOWN = 1;
    private int second = MAX_SECOND;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == WHAT_COUNT_DOWN) {
                if (second > 0) {
                    countDown();
                } else {    // 倒数完毕
                    second = MAX_SECOND;            // 重置时间
                    btnResend.setEnabled(true);     // 按钮可点
                    btnResend.setText("重新发送");
                }
            }
        }
    };

    /** 倒计时60秒 */
    private void countDown() {
        btnResend.setText("重新发送("+ ( second--) +")");
        mHandler.sendEmptyMessageDelayed(WHAT_COUNT_DOWN, 1000);
    }

    //============倒计时60秒(end)===================

    @Override
    public void onHttpSuccess(int reqType, Message msg) {
        if (reqType == IHttpService.TYPE_LOGIN) {
            // 登录成功，返回主界面，并显示用户个人信息
            Login login = (Login) msg.obj;

            // 保存token,用启名和其它用户相关信息
            SharedPreUtil.saveString(mActivity, Const.SP_TOKEN, login.getToken());
            SharedPreUtil.saveString(mActivity, Const.SP_USER_NAME, login.getUsername());

            // 发送otto事件，通知界面刷新
            Message ottoMsg = new Message();
            ottoMsg.what = IHttpService.TYPE_LOGIN;
            // ottoMsg.obj = null;
            OttoBus.getDefault().post(ottoMsg);

            // 回到主界面，显示用户信息
            mActivity.setResult(Activity.RESULT_OK);
            mActivity.finish();     // 退出登录界面
        }
    }

    //============Mod短信验证(begin)====================
    private EventHandler mEventHandler = new EventHandler() {

        @Override
        public void afterEvent(int event, int result, Object data) {
            if (result == SMSSDK.RESULT_COMPLETE) { // 回调成功
                // 获取验证码成功 (子线程回调)
                if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                    mActivity.dismissProgressDialog();
                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            onGetSmsCodeSuccess();
                        }
                    });
                    return;
                }

                // 提交验证码成功
                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                    mActivity.dismissProgressDialog();
                    // 验证通过，使用电话号码登录到服务器
                    login();
                    return;
                }

                // 返回支持发送验证码的国家列表
                if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                    return;
                }
            } else {        // 回调失败
                ((Throwable) data).printStackTrace();
                mActivity.dismissProgressDialog();
                mActivity.showDialog("提示", ((Throwable) data).getMessage());
            }
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 注册短信回调
        registerEventHandler(mEventHandler);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 删除所有的消息，避免内存泄漏
        mHandler.removeCallbacksAndMessages(null);
        // 注销短信回调
        SMSSDK.unregisterEventHandler(mEventHandler);
    }
    //============Mod短信验证(end)====================
}
