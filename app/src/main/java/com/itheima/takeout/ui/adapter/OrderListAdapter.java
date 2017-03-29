package com.itheima.takeout.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.takeout.model.bean.OrderList;
import com.itheima.takeout.model.bean.local.OrderUpdate;
import com.itheima.takeout.ui.holder.OrderListHolder;

import java.util.List;

/**
 * @author admin
 */
public class OrderListAdapter extends BaseAdapterRV <OrderList.OrderListBean>{

    public OrderListAdapter(Context context, List<OrderList.OrderListBean> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV<OrderList.OrderListBean> createViewHolder(
            Context context, ViewGroup parent, int viewType) {
        return new OrderListHolder(context, parent, this, viewType);
    }

    /**  更新列表中对应的订单状态*/
    public void updateOrderStatus(OrderUpdate bean) {
        if (bean == null) return;

        for (int i = 0; i < getItemCount(); i++) {
            OrderList.OrderListBean  order = getItem(i);
            if (order.getId() == bean.getOrderId()) {
                // 设置新的订单状态
                order.setOrderStatus(bean.getOrderStatus());
                notifyDataSetChanged();     // 刷新列表显示
                return;
            }
        }
    }
}
