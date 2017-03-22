package com.itheima.takeout.ui.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.Home;
import com.itheima.takeout.model.bean.ShopList;

import java.util.Objects;

/**
 * 显示商家
 *
 * @author WJQ
 */
public class HomeShopHolder extends BaseHolderRV {

    public HomeShopHolder(Context context, ViewGroup parent,
                          BaseAdapterRV adapter,
                          int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_order_by);
    }

    private TextView tvTitle;

    @Override
    public void onFindViews(View itemView) {
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
    }

    @Override
    protected void onRefreshView(Object bean, int position) {
        tvTitle.setText("商家");
    }
}
