package com.itheima.takeout.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.itheima.common.base.BaseActivity;
import com.itheima.takeout.R;

/**
 * @author admin
 */

public class OrderDetailActivity extends BaseActivity {

    private TextView tvOrderStatus;
    private TextView tvOrderTime;
    private TextView tvOrderDate;
    private TextView tvMoreStatus;
    private TextView tvLeft;
    private TextView tvMiddle;
    private TextView tvRight;
    private ImageView ivShop;
    private TextView tvShopName;
    private LinearLayout llGoods;
    private TextView tvPackageFee;
    private TextView tvDeliveryFee;
    private TextView tvAmount;
    private TextView tvOrderId;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_order_detail;
    }

    @Override
    public void initView() {
        tvOrderStatus = (TextView) findViewById(R.id.tv_order_status);
        tvOrderTime = (TextView) findViewById(R.id.tv_order_time);
        tvOrderDate = (TextView) findViewById(R.id.tv_order_date);
        tvMoreStatus = (TextView) findViewById(R.id.tv_more_status);
        tvLeft = (TextView) findViewById(R.id.tv_left);
        tvMiddle = (TextView) findViewById(R.id.tv_middle);
        tvRight = (TextView) findViewById(R.id.tv_right);
        ivShop = (ImageView) findViewById(R.id.iv_shop);
        tvShopName = (TextView) findViewById(R.id.tv_shop_name);
        llGoods = (LinearLayout) findViewById(R.id.ll_goods);
        tvPackageFee = (TextView) findViewById(R.id.tv_package_fee);
        tvDeliveryFee = (TextView) findViewById(R.id.tv_delivery_fee);
        tvAmount = (TextView) findViewById(R.id.tv_amount);
        tvOrderId = (TextView) findViewById(R.id.tv_order_id);
    }

    @Override
    public void initListener() {
        findViewById(R.id.tv_more_status).setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v, int id) {
        // 进入地图展示界面，展示骑手的配送路线
        if (R.id.tv_more_status == id) {
            enterMapActivity();
        }
    }

    private void enterMapActivity() {
        Intent view = new Intent(this, OrderDetailMapActivity.class);
        startActivity(view);
    }
}
