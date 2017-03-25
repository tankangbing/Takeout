package com.itheima.takeout.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.itheima.common.base.BaseActivity;
import com.itheima.common.base.Const;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.ShopList;
import com.itheima.takeout.ui.adapter.MyFragmentAdapter;
import com.itheima.takeout.ui.fragment.ShopDetailFragment1;
import com.itheima.takeout.ui.fragment.ShopDetailFragment2;
import com.itheima.takeout.ui.fragment.ShopDetailFragment3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 商家详情界面
 * @author admin
 */
public class ShopDetailActivity extends BaseActivity {

    private ShopList.ShopListBean mShop;
    private BottomSheetLayout bottomSheepLayout;
    private RelativeLayout rlTitleBar;
    private ImageButton btnBack;
    private TextView tvTitle;
    private LinearLayout llShopInfoLayout;
    private ImageView ivShopLogo;
    private TextView tvShopName;
    private TextView tvShopInfo;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private LinearLayout llBottomCardLayout01;
    private TextView tvSendPrice;
    private LinearLayout llBottomCardLayout02;
    private TextView tvAmount;
    private TextView tvDeliveryFee;
    private TextView tvSubmit;
    private FrameLayout flMycartZoom;
    private TextView tvSelectCount;
    private ImageButton ibPlus;

    private ShopDetailFragment1 shopDetailFragment1;

    public ShopDetailFragment1 getFragment1() {
        return shopDetailFragment1;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_shop_detail;
    }

    @Override
    public void initView() {
        // 接收主界面传过来的数据
        mShop = (ShopList.ShopListBean) getIntent().getSerializableExtra(Const.KEY_BEAN);

        bottomSheepLayout = (BottomSheetLayout) findViewById(R.id.bottom_sheep_layout);
        rlTitleBar = (RelativeLayout) findViewById(R.id.rl_title_bar);
        btnBack = (ImageButton) findViewById(R.id.btn_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        llShopInfoLayout = (LinearLayout) findViewById(R.id.ll_shop_info_layout);
        ivShopLogo = (ImageView) findViewById(R.id.iv_shop_logo);
        tvShopName = (TextView) findViewById(R.id.tv_shop_name);
        tvShopInfo = (TextView) findViewById(R.id.tv_shop_info);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        llBottomCardLayout01 = (LinearLayout) findViewById(R.id.ll_bottom_card_layout_01);
        tvSendPrice = (TextView) findViewById(R.id.tv_send_price);
        llBottomCardLayout02 = (LinearLayout) findViewById(R.id.ll_bottom_card_layout_02);
        tvAmount = (TextView) findViewById(R.id.tv_amount);
        tvDeliveryFee = (TextView) findViewById(R.id.tv_delivery_fee);
        tvSubmit = (TextView) findViewById(R.id.tv_submit);
        flMycartZoom = (FrameLayout) findViewById(R.id.fl_mycart_zoom);
        tvSelectCount = (TextView) findViewById(R.id.tv_select_count);
        ibPlus = (ImageButton) findViewById(R.id.ib_plus);

        initTitleBar();
        initViewPager();
    }

    private void initViewPager() {
        final List<Fragment> fragments = new ArrayList<>();

        shopDetailFragment1 = new ShopDetailFragment1();
        // (1) 从Activity传递参数到Fragment
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.KEY_BEAN, mShop);
        shopDetailFragment1.setArguments(bundle);
        fragments.add(shopDetailFragment1);


        fragments.add(new ShopDetailFragment2());
        fragments.add(new ShopDetailFragment3());

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            String[] titles = new String[] {
                    "点菜", "评价", "商家" };

            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initTitleBar() {
        // 设置背景颜色
        int mColor = getResources().getColor(R.color.shop_detail_bg_01 + new Random().nextInt(4));
        rlTitleBar.setBackgroundColor(mColor);
        super.setPageTitle(mShop.getName());
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v, int id) {

    }
}
