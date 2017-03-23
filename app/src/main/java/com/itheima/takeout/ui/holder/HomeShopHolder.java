package com.itheima.takeout.ui.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.common.util.Utils;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.ShopList;
import com.squareup.picasso.Picasso;

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
    }
}