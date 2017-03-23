package com.itheima.takeout.ui.holder;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewAnimator;

import com.itheima.common.base.Global;
import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.common.util.Utils;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.ShopList;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.itheima.common.util.Utils.replaceIp;

/**
 * 显示商家
 *
 * @author WJQ
 */
public class HomeShopHolder extends BaseHolderRV {

    private TextView tvTitle;
    private ImageView ivGoodsImage;
    private TextView tvCartGoodsAmount;
    private ImageView ivIsNewShop;
    private RatingBar ratingBar;
    private TextView tvMonthSale;
    private TextView tvSendPrice;
    private TextView tvDistance;
    private RelativeLayout rlActivityLayout;
    private LinearLayout llActivityList;
    private TextView tvActivityCount;

    public HomeShopHolder(Context context, ViewGroup parent,
                          BaseAdapterRV adapter,
                          int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_home_shop);
    }

    @Override
    public void onFindViews(View itemView) {
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        ivGoodsImage = (ImageView) itemView.findViewById(R.id.iv_goods_image);
        tvCartGoodsAmount = (TextView) itemView.findViewById(R.id.tv_cart_goods_amount);
        ivIsNewShop = (ImageView) itemView.findViewById(R.id.iv_is_new_shop);
        ratingBar = (RatingBar) itemView.findViewById(R.id.rating_bar);
        tvMonthSale = (TextView) itemView.findViewById(R.id.tv_month_sale);
        tvSendPrice = (TextView) itemView.findViewById(R.id.tv_send_price);
        tvDistance = (TextView) itemView.findViewById(R.id.tv_distance);
        rlActivityLayout = (RelativeLayout) itemView.findViewById(R.id.rl_activity_layout);
        llActivityList = (LinearLayout) itemView.findViewById(R.id.ll_activity_list);
        tvActivityCount = (TextView) itemView.findViewById(R.id.tv_activity_count);

        // 折叠与展开监听
        rlActivityLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 展开与折叠
                ShopList.ShopListBean shop = (ShopList.ShopListBean) bean;
//                shop.expanded = !shop.expanded;
//                adapter.notifyDataSetChanged();

                // 动画效果
                if (shop.expanded) {    // 展开 -> 折叠
                    shop.expanded = false;

                    int start = llActivityList.getLayoutParams().height;
                    int end = itemHeight * 2;
                    // 改变活动布局的高度
                    changeActivityItem(start, end);

                } else {    // 折叠 -> 展开
                    shop.expanded = true;
                    int start = llActivityList.getLayoutParams().height;
                    int end = shop.getActivityList().size() * itemHeight;
                    // 改变活动布局的高度
                    changeActivityItem(start, end);
                }
            }
        });
    }

    /** 改变活动布局的高度*/
    private void changeActivityItem(int start, int end) {
        ValueAnimator animator = ValueAnimator.ofInt(start, end);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 变化的高度
                int height = (int) animation.getAnimatedValue();

                // 设置活动父控件的高度
                ViewGroup.LayoutParams param = llActivityList.getLayoutParams();
                param.height = height;
                llActivityList.setLayoutParams(param);
            }
        });
        animator.setDuration(300);
        animator.start();
    }

    @Override
    protected void onRefreshView(Object bean, int position) {
        ShopList.ShopListBean shop = (ShopList.ShopListBean) bean;
        tvCartGoodsAmount.setVisibility(View.GONE);
        // 显示标题
        tvTitle.setText(shop.getName());
        // 显示商家图标
        String imageUrl = Utils.replaceIp(shop.getImage());
        Picasso.with(context).load(imageUrl).into(ivGoodsImage);
        // 是否是新店
        if (shop.getTag() == 1) {   // 新店
            ivIsNewShop.setVisibility(View.VISIBLE);
        } else {
            ivIsNewShop.setVisibility(View.GONE);
        }
        // 评分
        ratingBar.setRating((float) shop.getScore());
        // 显示月销量
        tvMonthSale.setText("月销"+ shop.getMonthSaleCount() +"单");
        // 起送配送价
        String sendInfo = "起送￥" +  shop.getSendPrice() + "";
        String deliverInfo = shop.getDeliveryFee() == 0
                ? "免费配送" : "配送费￥" + shop.getDeliveryFee();
        tvSendPrice.setText(sendInfo + " | " + deliverInfo);
        // 显示距离
        if (shop.getDistance() < 1000) {
            tvDistance.setText(shop.getDistance() + "m");
        } else { // 1.5km
            String disStr = (shop.getDistance()/100)/10f + "km";
            tvDistance.setText(disStr);
        }

        // 显示活动
        List<ShopList.ShopListBean.ActivityListBean> activityList = shop
                .getActivityList();
        boolean hasActivity = activityList != null
                && activityList.size() > 0;
        if (hasActivity) {  // 有商家活动
            rlActivityLayout.setVisibility(View.VISIBLE);
            // 显示商家活动
            showShopActivity(shop);
        } else {    // 没有隐藏界面
            rlActivityLayout.setVisibility(View.GONE);
        }
    }

    // 一个活动的高度
    int itemHeight = Global.dp2px(20);  // 20dp

    /** 显示商家活动*/
    private void showShopActivity(ShopList.ShopListBean shop) {
        List<ShopList.ShopListBean.ActivityListBean> activityList
                = shop.getActivityList();

        int count = activityList.size();
        tvActivityCount.setText(count+"个活动");

        if (count <= 2) {
            tvActivityCount.setVisibility(View.GONE);
            rlActivityLayout.setEnabled(false);
        } else {
            tvActivityCount.setVisibility(View.VISIBLE);
            rlActivityLayout.setEnabled(true);
        }

        ViewGroup.LayoutParams param = llActivityList.getLayoutParams();
        // 设置活动显示的高度
        if (count <= 2) {
            param.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        } else {
            int tempCount = shop.expanded ? count : 2;
            param.height = itemHeight * tempCount;
        }

        // 先清除之前的活动显示
        llActivityList.removeAllViews();
        for (ShopList.ShopListBean.ActivityListBean activity : activityList) {
            View item = Global.inflate(R.layout.item_activity, llActivityList);

            ImageView ivActivityIcon = (ImageView) item.findViewById(R.id.iv_activity_icon);
            TextView tvActivityName = (TextView) item.findViewById(R.id.tv_activity_name);
            tvActivityName.setText(activity.getTitle());
            String imageUrl = Utils.replaceIp(activity.getIcon());
            Picasso.with(context).load(imageUrl).into(ivActivityIcon);

            // 动态加载活动选项
            llActivityList.addView(item);
        }
    }
}
