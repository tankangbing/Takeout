package com.itheima.takeout.ui.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.Home;

import java.util.Objects;

/**
 * @author WJQ
 */
public class HomeHeaderHolder extends BaseHolderRV {

    private TextView tvTitle;

    public HomeHeaderHolder(Context context, ViewGroup parent,
                            BaseAdapterRV adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_order_by);
    }

    @Override
    public void onFindViews(View itemView) {
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
    }

    @Override
    protected void onRefreshView(Object bean, int position) {
        tvTitle.setText("头部");
    }
}
