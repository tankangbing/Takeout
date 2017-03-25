package com.itheima.takeout.ui.activity;

import android.animation.Animator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.itheima.common.base.BaseActivity;
import com.itheima.common.base.Const;
import com.itheima.common.base.Global;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.ShopDetail;
import com.itheima.takeout.model.bean.ShopList;
import com.itheima.takeout.model.bean.local.CartInfo;
import com.itheima.takeout.ui.adapter.CartGoodsAdapter;
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
    private int mColor;

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
        ibPlus = (ImageButton) findViewById(R.id.ib_plus);

        // 底部购物车相关的布局
        flMycartZoom = (FrameLayout) findViewById(R.id.fl_mycart_zoom);
        llBottomCardLayout01 = (LinearLayout) findViewById(R.id.ll_bottom_card_layout_01);
        llBottomCardLayout02 = (LinearLayout) findViewById(R.id.ll_bottom_card_layout_02);

        tvAmount = (TextView) findViewById(R.id.tv_amount);
        tvSendPrice = (TextView) findViewById(R.id.tv_send_price);
        tvDeliveryFee = (TextView) findViewById(R.id.tv_delivery_fee);
        tvSelectCount = (TextView) findViewById(R.id.tv_select_count);
        tvSubmit = (TextView) findViewById(R.id.tv_submit);

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
        mColor = getResources().getColor(R.color.shop_detail_bg_01 + new Random().nextInt(4));
        rlTitleBar.setBackgroundColor(mColor);
        super.setPageTitle(mShop.getName());
    }

    @Override
    public void initListener() {
        // 购物车弹窗
        llBottomCardLayout02.setOnClickListener(this);
        flMycartZoom.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v, int id) {
        // 购物车弹窗或隐藏
        if (v == flMycartZoom || v == llBottomCardLayout02) {
            showOrHideCartLayout();
            return;
        }
    }

    private LinearLayout llPopTitleBar;
    private TextView tvClearCart;
    private ListView listView;

    /**
     * 购物车弹窗或隐藏
     */
    private void showOrHideCartLayout() {
        // 弹出来的购物车布局
        if (bottomSheepLayout.isSheetShowing()) { // 显示 -> 隐藏
            bottomSheepLayout.dismissSheet();
        } else {    // 隐藏 -> 显示
            View cartPopLayout = Global.inflate(R.layout.layout_pop_cart);

            llPopTitleBar = (LinearLayout) cartPopLayout.findViewById(R.id.ll_pop_title_bar);
            tvClearCart = (TextView) cartPopLayout.findViewById(R.id.tv_clear_cart);
            llPopTitleBar.setBackgroundColor(mColor);
            listView = (ListView) cartPopLayout.findViewById(R.id.list_view);

            // 获取购物车中所有的商品
            ArrayList<ShopDetail.CategoryBean.GoodsBean> allShoppingCartGoods =
                    shopDetailFragment1.getPresenter().getAllShoppingCartGoods();
            listView.setAdapter(new CartGoodsAdapter(this, allShoppingCartGoods));

            bottomSheepLayout.showWithSheetView(cartPopLayout);
        }
    }

    /**更新购物车总金额和总数量*/
    public void updateShoppingCartUI() {
        // 获取总金额和总数量
        CartInfo cartInfo = shopDetailFragment1
                .getPresenter().getCartInfo();

        // 购物车中有商品
        if (cartInfo != null && cartInfo.mGoodsCount > 0) {
            llBottomCardLayout01.setVisibility(View.GONE);
            llBottomCardLayout02.setVisibility(View.VISIBLE);
            flMycartZoom.setVisibility(View.VISIBLE);

            // 总金额
            tvAmount.setText("共￥" + cartInfo.mTotalAmount);
            tvSelectCount.setText("" + cartInfo.mGoodsCount);
            tvSelectCount.setText("" + cartInfo.mGoodsCount);
            String deliveryInfo = mShop.getDeliveryFee() > 0 ?
                    "另需配送费"+ mShop.getDeliveryFee() +"元" : "免配送费";
            tvDeliveryFee.setText(deliveryInfo);

            // 起送价显示
            if (cartInfo.mTotalAmount > mShop.getSendPrice()) { // 大于起送价, 选好了
                tvSubmit.setText("选好了");
                tvSubmit.setBackgroundColor(getResources().getColor(R.color.title_bar_bg));
                tvSubmit.setEnabled(true);
            } else { // 没有达到起送价
                tvSubmit.setText("还差"+ (mShop.getSendPrice() - cartInfo.mTotalAmount) +"元起送");
                tvSubmit.setBackgroundColor(Color.TRANSPARENT);
                tvSubmit.setEnabled(false);
            }
        } else {
            llBottomCardLayout01.setVisibility(View.VISIBLE);
            llBottomCardLayout02.setVisibility(View.GONE);
            flMycartZoom.setVisibility(View.GONE);
        }
    }

    /**
     * 执行点击了加号按钮的抛物线动画
     * @param start 抛物线执行的开始位置
     */
    public void doBtnPlusAnimation(int[] start) {
        ibPlus.setVisibility(View.VISIBLE);
        // 设置加号的开始位置
        ibPlus.setTranslationX(start[0]);
        // 状态栏高度： 24dp
        ibPlus.setTranslationY(start[1] - Global.dp2px(24));

        // 动画执行的结束位置
        int[] end = new int[2];
        flMycartZoom.getLocationInWindow(end);

        // 执行水平向左移动的动画: 匀速
        ibPlus.animate()
                .translationX(end[0])
                .setInterpolator(new LinearInterpolator())
                .setDuration(400).start();

        // 执行垂直向下移动的动画： 加速: Accelerate
        ibPlus.animate()
                .translationY(end[1])
                .setInterpolator(new AccelerateInterpolator())
                .setDuration(400)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                    }

                    @Override   // 抛物线动画执行结束
                    public void onAnimationEnd(Animator animation) {
                        // 隐藏加号
                        ibPlus.setVisibility(View.GONE);
                        // 左下角购物车图标的先放大再缩小的动画
                        flMycartZoom.animate().scaleX(1.1f).scaleY(1.1f).setDuration(200);
                        Global.getMainHandler().postDelayed(new Runnable() {
                            @Override
                            public void run() { // 还原原来的大小
                                flMycartZoom.animate().scaleX(1f).scaleY(1f).setDuration(200);
                            }
                        }, 200);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                    }
                }).start();
    }
}











