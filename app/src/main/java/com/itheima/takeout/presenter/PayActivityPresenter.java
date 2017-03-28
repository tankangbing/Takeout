package com.itheima.takeout.presenter;

import com.itheima.takeout.base.BasePresenter;
import com.itheima.takeout.base.BaseView;
import com.itheima.takeout.db.greendao.AddressDao;
import com.itheima.takeout.model.dao.GreenDaoHelper;

/**
 * @author admin
 */

public class PayActivityPresenter extends BasePresenter {

    public PayActivityPresenter(BaseView baseView) {
        super(baseView);
    }

    /** 创建订单 */
    public void createOrder(String payInfo) {
        mProtocol.createOrder(mBaseCallback, payInfo);
    }
}
