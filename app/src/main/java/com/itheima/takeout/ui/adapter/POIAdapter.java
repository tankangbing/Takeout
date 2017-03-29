package com.itheima.takeout.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.amap.api.services.core.PoiItem;
import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.takeout.ui.holder.POIHolder;

import java.util.List;

/**
 * @author admin
 */

public class POIAdapter extends BaseAdapterRV <PoiItem>{

    public POIAdapter(Context context, List<PoiItem> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV<PoiItem> createViewHolder(
            Context context, ViewGroup parent, int viewType) {
        return new POIHolder(context, parent, this, viewType);
    }
}
