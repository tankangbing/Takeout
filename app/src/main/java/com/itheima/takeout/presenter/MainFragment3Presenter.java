package com.itheima.takeout.presenter;

import com.itheima.takeout.base.BasePresenter;
import com.itheima.takeout.base.BaseView;
import com.itheima.takeout.db.greendao.AddressDao;
import com.itheima.takeout.model.dao.GreenDaoHelper;

/**
 * @author admin
 */

public class MainFragment3Presenter extends BasePresenter {

    public MainFragment3Presenter(BaseView baseView) {
        super(baseView);
    }

    /** 获取订单列表数据 */
    public void getOrderList(String username, String token) {
        mProtocol.getOrderList(mBaseCallback, token, username);
    }
}
