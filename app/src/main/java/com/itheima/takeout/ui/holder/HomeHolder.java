package com.itheima.takeout.ui.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.takeout.R;

/**
 * @author WJQ
 */
public class HomeHolder extends BaseHolderRV<String> {
    private TextView tvTitle;

    public HomeHolder(Context context, ViewGroup parent,
                      BaseAdapterRV<String> adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_order_by);
    }

    @Override
    public void onFindViews(View itemView) {
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
    }

    @Override
    protected void onRefreshView(String bean, int position) {
        tvTitle.setText(bean);
    }
}
