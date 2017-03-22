package com.itheima.takeout.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.takeout.model.bean.Home;
import com.itheima.takeout.ui.holder.HomeCategoryHolder;

import java.util.List;

/**
 * @author WJQ
 */
public class HomeCategoryAdapter extends BaseAdapterRV<Home.PromotionTypesBean> {

    public HomeCategoryAdapter(Context context, List<Home.PromotionTypesBean> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV<Home.PromotionTypesBean> createViewHolder(
            Context context, ViewGroup parent, int viewType) {
        return new HomeCategoryHolder(context, parent, this, viewType);
    }
}
