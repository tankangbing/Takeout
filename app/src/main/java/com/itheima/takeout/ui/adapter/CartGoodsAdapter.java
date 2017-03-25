package com.itheima.takeout.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.itheima.common.ui.BaseAdapterLV;
import com.itheima.common.ui.BaseHolderLV;
import com.itheima.takeout.model.bean.ShopDetail;
import com.itheima.takeout.ui.holder.CartGoodsHolder;

import java.util.List;

/**
 * @author admin
 */
public class CartGoodsAdapter extends BaseAdapterLV<ShopDetail.CategoryBean.GoodsBean> {

    public CartGoodsAdapter(Context context,
                            List<ShopDetail.CategoryBean.GoodsBean> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderLV<ShopDetail.CategoryBean.GoodsBean> createViewHolder(
            Context context, ViewGroup parent,
            ShopDetail.CategoryBean.GoodsBean bean, int position) {
        return new CartGoodsHolder(context, parent, this, position, bean);
    }
}
