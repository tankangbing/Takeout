package com.itheima.takeout.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.itheima.common.base.BaseActivity;
import com.itheima.common.base.Const;
import com.itheima.takeout.R;

/**
 * 确认订单界面
 *
 * @author admin
 */
public class ConfirmOrderActivity extends BaseActivity {

    @Override
    public int getLayoutRes() {
        return R.layout.activity_confirm_order;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        findViewById(R.id.ll_recipients).setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v, int id) {
        if (id == R.id.ll_recipients) {  // 进入地址列表界面
            enterSelectAddressActivity();
            return;
        }
    }

    private void enterSelectAddressActivity() {
        Intent view = new Intent(this, AddressListActivity.class);
        startActivityForResult(view, Const.REQUEST_CODE_CONFIRM_ORDER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 用户选择了某个地址，需要回显到确认订单界面对应的控件中
        if (requestCode == Const.REQUEST_CODE_CONFIRM_ORDER &&
                resultCode == Activity.RESULT_OK) {

        }
    }
}
