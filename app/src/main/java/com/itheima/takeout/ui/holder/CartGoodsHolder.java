package com.itheima.takeout.ui.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.itheima.common.base.Global;
import com.itheima.common.ui.BaseAdapterLV;
import com.itheima.common.ui.BaseHolderLV;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.ShopDetail;

/**
 * @author admin
 */

public class CartGoodsHolder extends BaseHolderLV<ShopDetail.CategoryBean.GoodsBean> {

    private TextView tvName;
    private TextView tvTypeAllPrice;
    private LinearLayout ll;
    private ImageButton ibMinus;
    private TextView tvCartGoodsAmount;
    private ImageButton ibPlus;

    public CartGoodsHolder(Context context, ViewGroup parent,
                           BaseAdapterLV<ShopDetail.CategoryBean.GoodsBean> adapter,
                           int position, ShopDetail.CategoryBean.GoodsBean bean) {
        super(context, parent, adapter, position, bean);
    }

    @Override
    public View onCreateView(Context context, ViewGroup parent) {
        View item = Global.inflate(R.layout.item_shopping_cart, parent);

        tvName = (TextView) item.findViewById(R.id.tv_name);
        tvTypeAllPrice = (TextView) item.findViewById(R.id.tv_type_all_price);
        ll = (LinearLayout) item.findViewById(R.id.ll);
        ibMinus = (ImageButton) item.findViewById(R.id.ib_minus);
        tvCartGoodsAmount = (TextView) item.findViewById(R.id.tv_cart_goods_amount);
        ibPlus = (ImageButton) item.findViewById(R.id.ib_plus);

        return item;
    }

    @Override
    protected void onRefreshView(ShopDetail.CategoryBean.GoodsBean bean, int position) {
        // 商品名称
        tvName.setText(bean.getName());
        // 购买数量
        tvCartGoodsAmount.setText("" + bean.mBuyCount);
        // 金额:  单价 * 购买数量
        float ammount = bean.getNewPrice() * bean.mBuyCount;
        tvTypeAllPrice.setText(ammount + "");
    }
}
