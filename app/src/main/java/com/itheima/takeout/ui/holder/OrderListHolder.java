package com.itheima.takeout.ui.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.common.util.Utils;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.OrderList;
import com.squareup.picasso.Picasso;

/**
 * @author admin
 */
public class OrderListHolder extends BaseHolderRV<OrderList.OrderListBean> {

    private ImageView ivShop;
    private TextView tvShopName;
    private TextView tvGoodsName;
    private TextView tvOrderTime;
    private TextView tvAmount;
    private TextView tvOrderStatus;
    private TextView tvLeft;
    private TextView tvRight;

    public OrderListHolder(Context context, ViewGroup parent,
                           BaseAdapterRV<OrderList.OrderListBean> adapter,
                           int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_order_list);
    }

    @Override
    public void onFindViews(View itemView) {
        ivShop = (ImageView) itemView.findViewById(R.id.iv_shop);
        tvShopName = (TextView) itemView.findViewById(R.id.tv_shop_name);
        tvGoodsName = (TextView) itemView.findViewById(R.id.tv_goods_name);
        tvOrderTime = (TextView) itemView.findViewById(R.id.tv_order_time);
        tvAmount = (TextView) itemView.findViewById(R.id.tv_amount);
        tvOrderStatus = (TextView) itemView.findViewById(R.id.tv_order_status);
        tvLeft = (TextView) itemView.findViewById(R.id.tv_left);
        tvRight = (TextView) itemView.findViewById(R.id.tv_right);
    }

    @Override
    protected void onRefreshView(OrderList.OrderListBean bean, int position) {
        // 显示商家名称
        tvShopName.setText(bean.getShop().getName());
        // 显示商家logo
        String imageUrl = Utils.replaceIp(bean.getShop().getImage());
        Picasso.with(context).load(imageUrl).into(ivShop);

        // 显示购买的商品
        String goodsInfo = "";
        if (bean.getGoods().size() == 1) {
            goodsInfo = bean.getGoods().get(0).getName();
        } else {
            goodsInfo = bean.getGoods().get(0).getName()
                    + " 等"+ bean.getGoods().size() +"件商品";
        }
        tvGoodsName.setText(goodsInfo);

        // 显示价格
        float amount = 0;
        for (OrderList.OrderListBean.GoodsBean goods : bean.getGoods()) {
            // 一件商品的单价 * 数量
            amount += goods.getNewPrice() * goods.getQuantity();
        }
        tvAmount.setText("￥" + amount);

        // 订单时间
        tvOrderTime.setText(Utils.formatDate(bean.getCreateTime()));
    }
}
