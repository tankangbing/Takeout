package com.itheima.takeout.ui.holder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.services.core.PoiItem;
import com.itheima.common.base.Const;
import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.takeout.R;
import com.itheima.takeout.ui.activity.LocationActivity;

/**
 * @author admin
 */

public class POIHolder extends BaseHolderRV<PoiItem> {

    private ImageView ivIcon;
    private TextView tvLocationTitle;
    private TextView tvLocationDetail;

    public POIHolder(Context context, ViewGroup parent,
                     BaseAdapterRV<PoiItem> adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_nearby_address);
    }

    @Override
    public void onFindViews(View itemView) {
        ivIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
        tvLocationTitle = (TextView) itemView.findViewById(R.id.tv_location_title);
        tvLocationDetail = (TextView) itemView.findViewById(R.id.tv_location_detail);
    }

    @Override
    protected void onRefreshView(PoiItem bean, int position) {
        if (position == 0) {
            // 粗体显示
            tvLocationTitle.getPaint().setFakeBoldText(true);
            ivIcon.setVisibility(View.VISIBLE);
        } else {
            tvLocationTitle.getPaint().setFakeBoldText(false);
            ivIcon.setVisibility(View.INVISIBLE);
        }

        // 显示地址名称
        tvLocationTitle.setText(bean.getTitle());

        // 显示详细地址
        tvLocationDetail.setText(bean.getSnippet());
    }

    @Override
    protected void onItemClick(View itemView, int position, PoiItem bean) {
        Intent intent = new Intent();
        intent.putExtra(Const.KEY_BEAN, bean);      // 回传数据到上一个界面
        ((LocationActivity) context).setResult(Activity.RESULT_OK, intent);
        ((LocationActivity) context).finish();      // 退出当前界面
    }
}
