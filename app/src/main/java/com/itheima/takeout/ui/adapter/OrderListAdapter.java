package com.itheima.takeout.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.takeout.model.bean.OrderList;
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
}
