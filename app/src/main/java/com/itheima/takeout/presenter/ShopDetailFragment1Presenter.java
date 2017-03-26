package com.itheima.takeout.presenter;

import android.os.Message;

import com.itheima.takeout.base.BasePresenter;
import com.itheima.takeout.base.BaseView;
import com.itheima.takeout.model.bean.ShopDetail;
import com.itheima.takeout.model.bean.local.CartInfo;
import com.itheima.takeout.model.bean.local.ShopGoods;
import com.itheima.takeout.model.protocol.BaseProtocol;
import com.itheima.takeout.model.protocol.IHttpService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 */
public class ShopDetailFragment1Presenter extends BasePresenter {

    public BaseProtocol.OnHttpCallback mCallback
            = new BaseProtocol.OnHttpCallback() {

        @Override
        public void onHttpSuccess(int reqType, Message msg) {
            if (reqType == IHttpService.TYPE_SHOP_DETAIL) {
                ShopDetail shopDetail = (ShopDetail) msg.obj;
                // 转换数据结构后，再返回到界面，以方便在界面直接就能显示了
                msg.obj = transformShopDetailData(shopDetail);
                baseView.onHttpSuccess(reqType, msg);
                return;
            }
        }

        @Override
        public void onHttpError(int reqType, String error) {
            baseView.onHttpError(reqType, error);
        }
    };

    /** 左列表显示的数据：某商家所有的商品类别*/
    private ArrayList<ShopDetail.CategoryBean> mAllCategory;
    /** 右列表显示的数据：某商家所有的商品 */
    private ArrayList<ShopDetail.CategoryBean.GoodsBean> mAllGoods;

    /** 清空购物车 */
    public void clearShoppingCart() {
        if (mAllGoods == null || mAllGoods.size() < 1)
            return;

        for (ShopDetail.CategoryBean.GoodsBean goods : mAllGoods) {
            if (goods.mBuyCount > 0) {  // 有添加到购物车
                goods.mBuyCount = 0;
            }
        }
    }

    /**
     * 获取购物车总金额与总数量
     * @return
     */
    public CartInfo getCartInfo() {
        int count = 0;
        float amount = 0;
        if (mAllGoods != null) {
            for (ShopDetail.CategoryBean.GoodsBean goods : mAllGoods) {
                if (goods.mBuyCount > 0) {
                    count += goods.mBuyCount;
                    // 一件商品的购买金额
                    amount += goods.mBuyCount * goods.getNewPrice();
                }
            }
        }
        return new CartInfo(count, amount);
    };

    /**
     * 获取添加到购物车中的所有的商品
     * @return
     */
    public ArrayList<ShopDetail.CategoryBean.GoodsBean> getAllShoppingCartGoods() {
        ArrayList<ShopDetail.CategoryBean.GoodsBean> allCartGoods = new ArrayList<>();
        // 没有商品
        if (mAllGoods == null || mAllGoods.size() < 1) {
            return allCartGoods;
        }
        for (ShopDetail.CategoryBean.GoodsBean goods : mAllGoods) {
            if (goods.mBuyCount > 0) {  // 有添加到购物车
                allCartGoods.add(goods);
            }
        }
        return allCartGoods;
    };

    /**
     * 计算左侧列表第几个列表项的类别id是categoryId
     * @param categoryId
     * @return
     */
    public int getRecyclerViewPosition(int categoryId) {
        for (int i = 0; i < mAllCategory.size() ; i++) {
            ShopDetail.CategoryBean categoryBean = mAllCategory.get(i);
            if (categoryBean.getId() == categoryId) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 获取以categoryId作为类别id的列表项位置
     * @param categoryId
     * @return
     */
    public int getListViewPosition(int categoryId) {
        for (int i = 0; i < mAllGoods.size(); i++) {
            // 一个商品
            ShopDetail.CategoryBean.GoodsBean goods = mAllGoods.get(i);
            if (goods.getCategoryId() == categoryId) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 转换数据结构后，再返回到界面，以方便在界面直接就能显示了
     * @param shopDetail
     * @return
     */
    private ShopGoods transformShopDetailData(ShopDetail shopDetail) {
        // （1）获取某商家所有的商品类别
        mAllCategory = new ArrayList<>();
        for (ShopDetail.CategoryBean category : shopDetail.getCategory()) {
            mAllCategory.add(category);
        }

        // （2）获取某商家所有的商品
        mAllGoods = new ArrayList<>();
        for (ShopDetail.CategoryBean category : mAllCategory) {
            // 某类别下所有的商品
            for (ShopDetail.CategoryBean.GoodsBean good : category.getGoods()) {

                // 设置该商品的类别id (指定外键)
                good.setCategoryId(category.getId());
                // 指定该商品所属的类别名称
                good.setCategoryName(category.getName());

                mAllGoods.add(good);
            }
        }
        return new ShopGoods(mAllCategory, mAllGoods);
    }

    public ShopDetailFragment1Presenter(BaseView baseView) {
        super(baseView);
    }

    /**
     * 获取商家详情数据(所有的商品)
     * @param shopId
     */
    public void getShopDetail(int shopId) {
        mProtocol.getShopDetail(mCallback, shopId);
    }
}










