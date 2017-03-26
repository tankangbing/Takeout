package com.itheima.takeout.ui.holder;

import android.app.Activity;
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
import com.itheima.takeout.ui.activity.ShopDetailActivity;

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
    public View onCreateView(final Context context, ViewGroup parent) {
        View item = Global.inflate(R.layout.item_shopping_cart, parent);

        tvName = (TextView) item.findViewById(R.id.tv_name);
        tvTypeAllPrice = (TextView) item.findViewById(R.id.tv_type_all_price);
        ll = (LinearLayout) item.findViewById(R.id.ll);
        tvCartGoodsAmount = (TextView) item.findViewById(R.id.tv_cart_goods_amount);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == ibPlus) {          // 点击加号
                    onBtnPlusClick();
                    // 设置结果码为RESULT_OK
                    ((ShopDetailActivity) context).setResult(Activity.RESULT_OK);
                    return;
                }

                if (v == ibMinus) {         // 点击减号
                    onBtnMinusClick();
                    // 设置结果码为RESULT_OK
                    ((ShopDetailActivity) context).setResult(Activity.RESULT_OK);
                    return;
                }
            }
        };

        ibMinus = (ImageButton) item.findViewById(R.id.ib_minus);
        ibPlus = (ImageButton) item.findViewById(R.id.ib_plus);
        ibPlus.setOnClickListener(listener);
        ibMinus.setOnClickListener(listener);

        return item;
    }

    /** 点击了加号 */
    private void onBtnPlusClick() {
        // （1）更新当前列表项金额和数量的显示
        super.bean.mBuyCount++;
        super.adapter.notifyDataSetChanged();

        // （2）更新右侧商品列表显示
        ((ShopDetailActivity) context).getFragment1()
                .getRightAdapter().notifyDataSetChanged();

        // （3）更新底部购物车数量和总金额的显示
        ((ShopDetailActivity) context).updateShoppingCartUI();

        // （4）数据缓存: 更新记录，购买数量加1
        ((ShopDetailActivity) context).getFragment1()
                .getPresenter().getGoodsDao().increment(bean.getId());
    }

    /** 点击了减号 */
    private void onBtnMinusClick() {
        // （1）更新当前列表项金额和数量的显示
        super.bean.mBuyCount--;
        super.adapter.notifyDataSetChanged();

        // （2）更新右侧商品列表显示
        ((ShopDetailActivity) context).getFragment1()
                .getRightAdapter().notifyDataSetChanged();

        // （3）更新底部购物车数量和总金额的显示
        ((ShopDetailActivity) context).updateShoppingCartUI();

        // （4）与删除一行与隐藏弹窗
        if (super.bean.mBuyCount == 0) {
            // 删除一行: 从列表数据集合中删除对应列表项的javabean
            super.adapter.remove(super.bean);

            // 购物车中没有商品，隐藏弹窗
            if (super.adapter.getCount() < 1) {
                ((ShopDetailActivity) context).hideBottomSheetLayout();
            }

            // （5）数据缓存: 删除数据库表中的一条记录
            ((ShopDetailActivity) context).getFragment1()
                    .getPresenter().getGoodsDao().delete(bean.getId());
        } else {
            // （5）数据缓存: 购买商品数量减1
            ((ShopDetailActivity) context).getFragment1()
                    .getPresenter().getGoodsDao().decrement(bean.getId());
        }
    }

    @Override
    protected void onRefreshView(ShopDetail.CategoryBean.GoodsBean bean, int position) {
        // 商品名称
        tvName.setText(bean.getName());
        // 购买数量
        tvCartGoodsAmount.setText("" + bean.mBuyCount);
        // 金额:  单价 * 购买数量
        float amount = bean.getNewPrice() * bean.mBuyCount;
        tvTypeAllPrice.setText(amount + "");
    }
}
