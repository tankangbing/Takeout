package com.itheima.takeout.presenter;

import android.os.Message;

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
    private int pageNo = 1;
    /** 每页多少条 */
    private int pageCount = 10;

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

    public void getShopList() {
        // 0: 获取所有的商家
        mProtocol.getShopList(mCallback, pageNo,
                pageCount, 0, 0);
    }
}
