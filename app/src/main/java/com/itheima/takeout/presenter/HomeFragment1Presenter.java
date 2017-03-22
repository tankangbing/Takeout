package com.itheima.takeout.presenter;

import com.itheima.takeout.base.BasePresenter;
import com.itheima.takeout.base.BaseView;
import com.itheima.takeout.model.protocol.BaseProtocol;
import com.itheima.takeout.model.protocol.CommonProtocol;
import com.itheima.takeout.ui.fragment.MainFragment1;

/**
 * Presenter层
 * @author WJQ
 */
public class HomeFragment1Presenter extends BasePresenter {

    public HomeFragment1Presenter(BaseView baseView) {
        super(baseView);
    }

    public void getHomeData() {
        // P层 调用 M层
        mProtocol.getHomeData(mCallback);
    }

    public void getShopList(int pageNo, int pageCount,
                            int categoryId, int orderBy) {
        mProtocol.getShopList(mCallback, pageNo,
                pageCount, categoryId, orderBy);
    }
}
