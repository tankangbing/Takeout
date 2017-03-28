package com.itheima.takeout.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.itheima.common.base.BaseActivity;
import com.itheima.common.base.Const;
import com.itheima.takeout.R;
import com.itheima.takeout.db.greendao.Address;
import com.itheima.takeout.model.bean.local.Sex;

import java.io.Serializable;

/**
 * 确认订单界面
 *
 * @author admin
 */
public class ConfirmOrderActivity extends BaseActivity {

    private ImageButton btnBack;
    private TextView tvTitle;
    private LinearLayout llRecipients;
    private TextView tvAddress;
    private TextView tvUserInfo;
    private RadioButton rb01;
    private RadioButton rb02;
    private RadioButton rb03;
    private TextView tvShopName;
    private LinearLayout llGoods;
    private TextView tvPackageFee;
    private TextView tvDeliveryFee;
    private TextView tvAmount;
    private TextView tvSubmit;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_confirm_order;
    }

    @Override
    public void initView() {
        btnBack = (ImageButton) findViewById(R.id.btn_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        llRecipients = (LinearLayout) findViewById(R.id.ll_recipients);
        tvAddress = (TextView) findViewById(R.id.tv_address);
        tvUserInfo = (TextView) findViewById(R.id.tv_user_info);
        rb01 = (RadioButton) findViewById(R.id.rb_01);
        rb02 = (RadioButton) findViewById(R.id.rb_02);
        rb03 = (RadioButton) findViewById(R.id.rb_03);
        tvShopName = (TextView) findViewById(R.id.tv_shop_name);
        llGoods = (LinearLayout) findViewById(R.id.ll_goods);
        tvPackageFee = (TextView) findViewById(R.id.tv_package_fee);
        tvDeliveryFee = (TextView) findViewById(R.id.tv_delivery_fee);
        tvAmount = (TextView) findViewById(R.id.tv_amount);
        tvSubmit = (TextView) findViewById(R.id.tv_submit);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        // 用户选择了某个地址，需要回显到确认订单界面对应的控件中
        if (requestCode == Const.REQUEST_CODE_CONFIRM_ORDER &&
                resultCode == Activity.RESULT_OK) {
            // 取出用户选择的地址
            Address address = (Address) intent.getSerializableExtra(Const.KEY_BEAN);
            showAddress(address);
        }
    }

    /** 显示收件人地址信息 */
    private void showAddress(Address address) {
        tvAddress.setText(address.getAddressDetail());
        // 收件人名称和电话
        String userInfo = address.getName()
                + " " + Sex.of(address.getSex()).getSex()
                + "   " + address.getPhone();
        tvUserInfo.setText(userInfo);
    }
}
