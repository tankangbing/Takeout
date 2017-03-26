package com.itheima.takeout.ui.fragment;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.itheima.common.base.BaseFragment;
import com.itheima.common.base.Global;
import com.itheima.common.ui.EditLayout;
import com.itheima.takeout.R;

import static android.R.attr.countDown;

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
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v, int id) {
        if (id == R.id.btn_get_sms_code) {      // 获取短信验证码
            getSmsCode();
            return;
        }

        if (id == R.id.btn_resend) {            // 重新发送短信验证码
            getSmsCode();
            second = MAX_SECOND;                // 重置时间
            btnResend.setEnabled(false);        // 按钮不可点
            return;
        }
    }

    /** 获取短信验证码*/
    private void getSmsCode() {
        phone = elPhone.getText();

        if (TextUtils.isEmpty(phone)) {
            showToast("请输入电话号码");
            return;
        }

        // 发请求，获取验证码
        // ...
        mActivity.showProgressDialog("正在获取验证码...");

        // 模拟代码：
        Global.getMainHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mActivity.dismissProgressDialog();
                onGetSmsCodeSuccess();
            }
        }, 3000);       // 3秒后下发了验证码
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 删除所有的消息，避免内存泄漏
        mHandler.removeCallbacksAndMessages(null);
    }

    //============倒计时60秒(end)===================

}
