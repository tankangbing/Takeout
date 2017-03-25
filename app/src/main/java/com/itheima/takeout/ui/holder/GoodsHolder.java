package com.itheima.takeout.ui.holder;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.common.base.Global;
import com.itheima.common.ui.BaseAdapterLV;
import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderLV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.common.util.Utils;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.ShopDetail;
import com.squareup.picasso.Picasso;

/**
 * @author admin
 */

public class GoodsHolder extends BaseHolderLV<ShopDetail.CategoryBean.GoodsBean> {
    private ImageView ivIcon;
    private TextView tvName;
    private TextView tvDetail;
    private TextView tvSaleInfo;
    private TextView tvNewPrice;
    private TextView tvOldPrice;
    private ImageButton ibMinus;
    private TextView tvBuyCount;
    private ImageButton ibPlus;

    public GoodsHolder(Context context, ViewGroup parent,
                       BaseAdapterLV<ShopDetail.CategoryBean.GoodsBean> adapter,
                       int position, ShopDetail.CategoryBean.GoodsBean bean) {
        super(context, parent, adapter, position, bean);
    }

    @Override
    public View onCreateView(Context context, ViewGroup parent) {
        View item = Global.inflate(R.layout.item_shop_detail_goods, parent);

        ivIcon = (ImageView) item.findViewById(R.id.iv_icon);
        tvName = (TextView) item.findViewById(R.id.tv_name);
        tvDetail = (TextView) item.findViewById(R.id.tv_detail);
        tvSaleInfo = (TextView) item.findViewById(R.id.tv_sale_info);
        tvNewPrice = (TextView) item.findViewById(R.id.tv_new_price);
        tvOldPrice = (TextView) item.findViewById(R.id.tv_old_price);
        tvBuyCount = (TextView) item.findViewById(R.id.tv_buy_count);

        ibMinus = (ImageButton) item.findViewById(R.id.ib_minus);
        ibPlus = (ImageButton) item.findViewById(R.id.ib_plus);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == ibPlus) {      // 点击加号
                    onBtnPlusClick();
                    return;
                }

                if (v == ibMinus) {      // 点击减号
                    onBtnMinusClick();
                    return;
                }
            }
        };
        ibMinus.setOnClickListener(listener);
        ibPlus.setOnClickListener(listener);

        return item;
    }

    /** 点击了列表项加号按钮 */
    private void onBtnPlusClick() {
        // （1）更新点击的商品的数量
        int count = ++super.bean.mBuyCount;     // 购买数量加一
        tvBuyCount.setText(count + "");

        if (count == 1) {
            // （2）数量从0到1时,显示减号
            ibMinus.setVisibility(View.VISIBLE);
            tvBuyCount.setVisibility(View.VISIBLE);

            // 设置减号开始位置
            ibMinus.setTranslationX(Global.dp2px(55));
            tvBuyCount.setTranslationX(Global.dp2px(30));
            // 向左移动的动画
            ibMinus.animate().translationX(0).rotation(360);
            tvBuyCount.animate().translationX(0).rotation(360);
        }

        // （3）更新购物车总金额和总数量

        // （4）加号的抛物线动画和左下角购物车图标的缩放动画

        // （5）数据缓存
    }

    /** 点击了列表项减号按钮 */
    private void onBtnMinusClick() {

    }

    // 显示列表项子控件
    @Override
    protected void onRefreshView(ShopDetail.CategoryBean.GoodsBean bean, int position) {
        // 商品名称
        tvName.setText(bean.getName());
        // 图片: 转换ip为正确的ip
        String imageUrl = Utils.replaceIp(bean.getImage());
        Picasso.with(context).load(imageUrl).into(ivIcon);
        // 商品详情
        tvDetail.setText(bean.getDetail());
        // 月销量和好评率
        String saleInfo = "月销售"+ bean.getMonthSaleCount() +"份";
        String score = "好评率"+ bean.getFeedbackRate() +"%";
        tvSaleInfo.setText(saleInfo + " | " + score);
        // 价格显示
        tvNewPrice.setText("￥" + bean.getNewPrice());
        if (bean.isBargainPrice()) { // 特价商品
            tvOldPrice.setVisibility(View.VISIBLE);
            tvOldPrice.setText("￥" + bean.getOldPrice());
            //中间横线
            tvOldPrice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);
        } else {
            tvOldPrice.setVisibility(View.GONE);
        }

        // 显示购买数量
        if (bean.mBuyCount > 0) {   // 有添加到购物车
            ibMinus.setVisibility(View.VISIBLE);
            tvBuyCount.setVisibility(View.VISIBLE);
            tvBuyCount.setText("" + bean.mBuyCount);
        } else {
            ibMinus.setVisibility(View.GONE);
            tvBuyCount.setVisibility(View.GONE);
        }
    }
}
