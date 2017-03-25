package com.itheima.takeout.ui.holder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.ShopDetail;
import com.itheima.takeout.ui.activity.ShopDetailActivity;
import com.itheima.takeout.ui.adapter.GoodsCategoryAdapter;
import com.itheima.takeout.ui.adapter.HomeCategoryAdapter;
import com.itheima.takeout.ui.fragment.ShopDetailFragment1;

import javax.annotation.Resource;

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

        // 显示是否高亮
        int currentPosition = ((GoodsCategoryAdapter) adapter).getCurrentPosition();
        Resources resource = context.getResources();
        if (currentPosition == position) {  // 高亮显示
            tvGoodsCategory.setTextColor(resource.getColor(R.color.item_text_selected));
            super.itemView.setBackgroundColor(Color.WHITE);
        } else { // 普通显示
            super.itemView.setBackgroundColor(Color.TRANSPARENT);
            tvGoodsCategory.setTextColor(resource.getColor(R.color.item_text_normal));
        }
    }

    // 列表项点击事件
    @Override
    protected void onItemClick(View itemView, int position,
                               ShopDetail.CategoryBean bean) {
        // （1）选中某一个商品分类
        ((GoodsCategoryAdapter) adapter).checkPosition(position);

        // （2）右侧列表要滚动到指定的位置
        // 选中的商品类别id
        int categoryId = bean.getId();
        // 以categoryId作为类别id的商品的列表项位置
        ShopDetailFragment1 fragment1 = ((ShopDetailActivity) context).getFragment1();
        int pos =  fragment1.getPresenter().getListViewPosition(categoryId);
        // 右侧列表滚动到指定的位置pos
        fragment1.getListViewRight().setSelection(pos);
    }
}
