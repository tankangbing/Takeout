package com.itheima.takeout.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.itheima.common.ui.BaseAdapterLV;
import com.itheima.common.ui.BaseHolderLV;
import com.itheima.takeout.model.bean.OrderBy;
import com.itheima.takeout.ui.holder.OrderByHolder;

import java.util.List;

/**
 * @author WJQ
 */

public class OrderByAdapter extends BaseAdapterLV<OrderBy.OrderByListBean> {

    /** 选中的排序条件 */
    public OrderBy.OrderByListBean mSelectedOrderBy;

    public OrderByAdapter(Context context, List<OrderBy.OrderByListBean> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderLV<OrderBy.OrderByListBean> createViewHolder(
            Context context, ViewGroup parent, OrderBy.OrderByListBean bean,
            int position) {
        return new OrderByHolder(context, parent, this, position, bean);
    }
}
