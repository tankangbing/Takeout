package com.itheima.takeout.ui.holder;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.common.util.Utils;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.OrderList;
import com.itheima.takeout.model.bean.local.OrderStatus;
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

        // 显示订单状态
        tvOrderStatus.setText(OrderStatus.getInfo(bean.getOrderStatus()));
        if (bean.getOrderStatus() == OrderStatus.CONFIRM.status             // 商家确认订单
                || bean.getOrderStatus() == OrderStatus.DELIVERING.status)  // 外卖已送出
        {
            tvOrderStatus.setTextColor(Color.RED);
        } else {
            tvOrderStatus.setTextColor(Color.GRAY);
        }

        // 操作菜单
        if (OrderStatus.CREATE.status == bean.getOrderStatus()) {
            tvLeft.setText("再来一单");
            tvRight.setText("去支付");
        } else if (OrderStatus.PAY.status == bean.getOrderStatus()) {
            tvLeft.setText("取消订单");
            tvRight.setText("催单");
        } else if (OrderStatus.CONFIRM.status == bean.getOrderStatus()) {
            tvLeft.setText("取消订单");
            tvRight.setText("催单");
        } else if (OrderStatus.DELIVERING.status == bean.getOrderStatus()) {
            tvLeft.setText("再来一单");
            tvRight.setText("催单");
        } else if (OrderStatus.DELIVERED.status == bean.getOrderStatus()) {
            tvLeft.setText("再来一单");
            tvRight.setText("去评价");
        } else if (OrderStatus.FINISH.status == bean.getOrderStatus()) {
            tvLeft.setText("再来一单");
            tvRight.setText("查看评价");
        } else if (OrderStatus.CANCEL.status == bean.getOrderStatus()) {
            tvLeft.setText("再来一单");
            tvRight.setText("投拆");
        }
    }
}
