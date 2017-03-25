package com.itheima.takeout.model.bean.local;

import com.itheima.takeout.model.bean.ShopCategory;
import com.itheima.takeout.model.bean.ShopDetail;

import java.util.ArrayList;

/**
 * 商家商品类别和所有的商品
 *
 * @author admin
 */
public class ShopGoods {

    public ShopGoods(ArrayList<ShopDetail.CategoryBean> mAllCategory,
                     ArrayList<ShopDetail.CategoryBean.GoodsBean> mAllGoods) {
        this.mAllCategory = mAllCategory;
        this.mAllGoods = mAllGoods;
    }

    /** 左侧列表显示的数据：所有商品类别 */
    public ArrayList<ShopDetail.CategoryBean> mAllCategory;

    /** 右侧列表显示的数据：所有的商品 */
    public ArrayList<ShopDetail.CategoryBean.GoodsBean> mAllGoods;

}
