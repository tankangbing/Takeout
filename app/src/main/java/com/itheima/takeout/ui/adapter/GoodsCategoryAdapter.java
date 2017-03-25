package com.itheima.takeout.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.takeout.model.bean.ShopDetail;
import com.itheima.takeout.ui.holder.GoodsCategoryHolder;

import java.util.List;

/**
 * @author admin
 */

public class GoodsCategoryAdapter extends BaseAdapterRV<ShopDetail.CategoryBean> {

    public GoodsCategoryAdapter(Context context, List<ShopDetail.CategoryBean> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV<ShopDetail.CategoryBean> createViewHolder(
            Context context, ViewGroup parent, int viewType) {
        return new GoodsCategoryHolder(context, parent, this, viewType);
    }
}
