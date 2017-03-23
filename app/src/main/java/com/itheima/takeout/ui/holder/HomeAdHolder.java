package com.itheima.takeout.ui.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.ShopList;

/**
 * 显示首页广告
 *
 * @author WJQ
 */
public class HomeAdHolder extends BaseHolderRV {

    private TextView tvTitle;

    public HomeAdHolder(Context context, ViewGroup parent,
                        BaseAdapterRV adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_home_ad);
    }

    @Override
    public void onFindViews(View itemView) {
    }

    @Override
    protected void onRefreshView(Object bean, int position) {
    }
}
