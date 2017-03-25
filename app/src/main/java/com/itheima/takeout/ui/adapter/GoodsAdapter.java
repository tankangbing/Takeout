package com.itheima.takeout.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itheima.common.base.Global;
import com.itheima.common.ui.BaseAdapterLV;
import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderLV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.ShopDetail;
import com.itheima.takeout.ui.holder.GoodsHolder;

import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * 右侧列表商品显示
 *
 * @author admin
 */
public class GoodsAdapter extends BaseAdapterLV<ShopDetail.CategoryBean.GoodsBean>
    implements StickyListHeadersAdapter {

    public GoodsAdapter(Context context, List<ShopDetail.CategoryBean.GoodsBean> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderLV<ShopDetail.CategoryBean.GoodsBean>
        createViewHolder(Context context, ViewGroup parent,
                         ShopDetail.CategoryBean.GoodsBean bean, int position) {
        return new GoodsHolder(context, parent, this, position, bean);
    }

    //=============带头部的列表的适配器要实现的接口方法(begin)===============
    private TextView tvGoodsCategory;

    // 显示列表头部
    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        View headItem = null;
        if (convertView == null) {
            headItem = Global.inflate(R.layout.item_goods_category_header, parent);
        } else {
            headItem = convertView;
        }
        tvGoodsCategory = (TextView) headItem.findViewById(R.id.tv_goods_category);
        // 显示该商品的类别
        tvGoodsCategory.setText(getItem(position).getCategoryName());
        return headItem;
    }

    @Override
    public long getHeaderId(int position) {
        return getItem(position).getCategoryId();
    }
    //=============带头部的列表的适配器要实现的接口方法(end)===============
}
