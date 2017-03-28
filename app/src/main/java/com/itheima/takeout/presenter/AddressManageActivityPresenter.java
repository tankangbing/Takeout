package com.itheima.takeout.presenter;

import com.itheima.takeout.base.BasePresenter;
import com.itheima.takeout.base.BaseView;
import com.itheima.takeout.db.greendao.AddressDao;
import com.itheima.takeout.model.dao.GreenDaoHelper;

/**
 * @author admin
 */

public class AddressManageActivityPresenter extends BasePresenter {

    private AddressDao addressDao = GreenDaoHelper.getInstance().getAddressDao();

    public AddressDao getAddressDao() {
        return addressDao;
    }

    public AddressManageActivityPresenter(BaseView baseView) {
        super(baseView);
    }
}
