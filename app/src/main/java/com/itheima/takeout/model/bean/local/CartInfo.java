package com.itheima.takeout.model.bean.local;

/**
 * 购物车信息：总金额与总数量
 *
 * @author admin
 */
public class CartInfo {

    /** 商品总数量 */
    public int mGoodsCount;

    /** 商品总金额 */
    public float mTotalAmount;

    public CartInfo(int goodsCount, float totalAmount) {
        this.mGoodsCount = goodsCount;
        this.mTotalAmount = totalAmount;
    }
}
