package com.itheima.takeout.ui.holder;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.common.base.Global;
import com.itheima.common.ui.BaseAdapterLV;
import com.itheima.common.ui.BaseHolderLV;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.ShopCategory;
import com.itheima.takeout.ui.adapter.ShopCategoryAdapter;

/**
 * @author WJQ
 */
public class ShopCategoryHolder extends BaseHolderLV <ShopCategory.CategoryListBean> {
    private TextView tvTitle;
    private TextView tvShopCount;
    private ImageView ivArrowRight;

    public ShopCategoryHolder(Context context, ViewGroup parent,
        BaseAdapterLV<ShopCategory.CategoryListBean> adapter,
        int position, ShopCategory.CategoryListBean bean) {

        super(context, parent, adapter, position, bean);
    }

    @Override
    public View onCreateView(Context context, ViewGroup parent) {
        View item = Global.inflate(R.layout.item_shop_category);

        tvTitle = (TextView) item.findViewById(R.id.tv_title);
        tvShopCount = (TextView) item.findViewById(R.id.tv_shop_count);
        ivArrowRight = (ImageView) item.findViewById(R.id.iv_arrow_right);

        return item;
    }

    @Override
    protected void onRefreshView(
            ShopCategory.CategoryListBean bean, int position) {
        // 类别名称
        tvTitle.setText(bean.getName());
        // 商家个数
        tvShopCount.setText("("+ bean.getShopCount() +")");

        // 箭头显示: 有子类别才显示
        if (bean.childCategory.size() > 0) {
            ivArrowRight.setVisibility(View.VISIBLE);
        } else {
            ivArrowRight.setVisibility(View.GONE);
        }

        Resources resources = context.getResources();
        // 选中的item要高亮显示
        ShopCategory.CategoryListBean selectedCategory = ((ShopCategoryAdapter)
                adapter).mSelectedCategory;
        // 高亮显示
        if (selectedCategory != null && selectedCategory.getId() == bean.getId()) {
            tvTitle.setTextColor(resources.getColor(R.color.shop_category_item_selected));
            tvShopCount.setTextColor(resources.getColor(R.color.shop_category_item_selected));
        } else {
            // 普通项
            tvTitle.setTextColor(resources.getColor(R.color.item_text_02));
            tvShopCount.setTextColor(resources.getColor(R.color.item_text_02));
        }
    }
}
