package com.itheima.takeout.ui.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.ShopDetail;

/**
 * @author admin
 */
public class GoodsCategoryHolder extends BaseHolderRV<ShopDetail.CategoryBean> {

    private TextView tvCartGoodsAmount;
    private TextView tvGoodsCategory;

    public GoodsCategoryHolder(Context context, ViewGroup parent,
                               BaseAdapterRV<ShopDetail.CategoryBean> adapter,
                               int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_goods_category);
    }

    @Override
    public void onFindViews(View itemView) {
        tvCartGoodsAmount = (TextView) itemView.findViewById(R.id.tv_cart_goods_amount);
        tvGoodsCategory = (TextView) itemView.findViewById(R.id.tv_goods_category);
    }

    @Override
    protected void onRefreshView(ShopDetail.CategoryBean bean, int position) {
        // 显示商品类别
        tvGoodsCategory.setText(bean.getName());
    }
}
