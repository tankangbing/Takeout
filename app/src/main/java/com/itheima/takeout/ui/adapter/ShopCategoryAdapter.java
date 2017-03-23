package com.itheima.takeout.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.itheima.common.ui.BaseAdapterLV;
import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderLV;
import com.itheima.takeout.model.bean.ShopCategory;
import com.itheima.takeout.ui.holder.ShopCategoryHolder;

import java.util.List;

/**
 * @author WJQ
 */

public class ShopCategoryAdapter extends BaseAdapterLV<ShopCategory.CategoryListBean> {

    /** 当前选中的类别 */
    public ShopCategory.CategoryListBean mSelectedCategory;

    public ShopCategoryAdapter(Context context,
         List<ShopCategory.CategoryListBean> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderLV<ShopCategory.CategoryListBean> createViewHolder(
            Context context, ViewGroup parent,
            ShopCategory.CategoryListBean bean, int position) {
        return new ShopCategoryHolder(context, parent, this, position, bean);
    }
}
