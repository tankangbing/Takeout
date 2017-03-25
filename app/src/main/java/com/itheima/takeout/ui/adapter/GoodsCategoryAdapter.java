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

    /** 当前列表中第几项选中 */
    private int mCurrentPosition;

    /** 获取当前选中的列表项位置 */
    public int getCurrentPosition() {
        return mCurrentPosition;
    }

    /**
     * 选中指定的位置，选中后会高亮
     * @param currentPosition 要选中的列表项位置
     */
    public void checkPosition(int currentPosition) {
        this.mCurrentPosition = currentPosition;
        notifyDataSetChanged(); // 刷新列表显示
    }
}
