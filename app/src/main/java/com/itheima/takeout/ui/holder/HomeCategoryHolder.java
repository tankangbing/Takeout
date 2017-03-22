package com.itheima.takeout.ui.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.common.base.Global;
import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.common.util.Utils;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.Home;
import com.squareup.picasso.Picasso;

/**
 * @author WJQ
 */

public class HomeCategoryHolder extends BaseHolderRV<Home.PromotionTypesBean> {

    private ImageView ivIcon;
    private TextView tvTitle;

    public HomeCategoryHolder(Context context, ViewGroup parent,
                              BaseAdapterRV<Home.PromotionTypesBean> adapter,
                              int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_grid);
    }

    @Override
    public void onFindViews(View itemView) {
        ivIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);

        // 设置一个item的宽度
        ViewGroup.LayoutParams param = itemView.getLayoutParams();
        param.width = (int) (Global.mScreenWidth / 5);
    }

    @Override
    protected void onRefreshView(Home.PromotionTypesBean bean, int position) {
        // 显示标题
        tvTitle.setText(bean.getName());
        // 显示图标
        // 修正ip地址
        String imageUrl = Utils.replaceIp(bean.getIcon());
        Picasso.with(context).load(imageUrl).into(ivIcon);
    }

    // item点击事件
    @Override
    protected void onItemClick(View itemView, int position,
                               Home.PromotionTypesBean bean) {
        Global.showToast(bean.getName());
    }
}
