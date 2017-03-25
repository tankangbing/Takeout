package com.itheima.takeout.presenter;

import android.os.Message;

import com.itheima.takeout.base.BasePresenter;
import com.itheima.takeout.base.BaseView;
import com.itheima.takeout.model.bean.ShopDetail;
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










