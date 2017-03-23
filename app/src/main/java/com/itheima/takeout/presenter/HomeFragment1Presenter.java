package com.itheima.takeout.presenter;

import android.os.Message;

import com.itheima.common.base.Global;
import com.itheima.takeout.base.BasePresenter;
import com.itheima.takeout.base.BaseView;
import com.itheima.takeout.model.bean.ShopList;
import com.itheima.takeout.model.protocol.BaseProtocol;
import com.itheima.takeout.model.protocol.IHttpService;

import java.util.ArrayList;

/**
 * Presenter层
 * @author WJQ
 */
public class HomeFragment1Presenter extends BasePresenter {

    /** 第几页数据 */
    private int mPageNo = 1;
    /** 每页多少条 */
    private int mPageCount = 10;

    public BaseProtocol.OnHttpCallback mCallback
            = new BaseProtocol.OnHttpCallback() {
        @Override
        public void onHttpSuccess(int reqType, Message msg) {
            if (reqType == IHttpService.TYPE_SHOP_LIST) {
                // 处理并转换数据，回调用界面
                // 处理并转换数据
                ShopList bean = (ShopList) msg.obj;
                ArrayList pageData = new ArrayList();
                // 一页数据：10个商家
                pageData.addAll(bean.getShopList());

                // 加载显示一则广告
                if (bean.getShopList() != null
                        && bean.getShopList().size() == 10
                        && bean.getRecommendList() != null
                        && bean.getRecommendList().size() > 0) {
                    // 显示了10个家商后，才显示一则广告
                    pageData.add(bean.getRecommendList().get(0));
                }
                msg.obj = pageData;

                mPageNo++;

                if (pageData.size() < 1) {
                    Global.showToast("已经是最后一页了");
                }

                // 返回到界面
                baseView.onHttpSuccess(reqType, msg);
                return;
            }
        }

        @Override
        public void onHttpError(int reqType, String error) {
            baseView.onHttpError(reqType, error);
        }
    };

    public HomeFragment1Presenter(BaseView baseView) {
        super(baseView);
    }

    public void getHomeData() {
        // P层 调用 M层
        mProtocol.getHomeData(mBaseCallback);
    }

    /**
     * 传true表示加载第一页数据
     *
     * @param firstPage
     */
    public void getShopList(boolean firstPage) {
        if (firstPage)
            mPageNo = 1;
        // 0: 获取所有的商家
        mProtocol.getShopList(mCallback, mPageNo,
                mPageCount, 0, 0, firstPage);
    }

    /** 下拉刷新 */
    public void getShopListRefresh() {
        mPageNo = 1;
        // 0: 获取所有的商家
        mProtocol.getShopList(mCallback, mPageNo,
                mPageCount, 0, 0, true);
    }

    /** 加载分页数据 */
    public void getShopList() {
        // 0: 获取所有的商家
        mProtocol.getShopList(mCallback, mPageNo,
                mPageCount, 0, 0, false);
    }
}
