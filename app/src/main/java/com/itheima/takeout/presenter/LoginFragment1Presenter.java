package com.itheima.takeout.presenter;

import android.os.Message;

import com.itheima.takeout.base.BasePresenter;
import com.itheima.takeout.base.BaseView;
import com.itheima.takeout.db.greendao.CartGoods;
import com.itheima.takeout.model.bean.ShopDetail;
import com.itheima.takeout.model.bean.local.CartInfo;
import com.itheima.takeout.model.bean.local.ShopGoods;
import com.itheima.takeout.model.dao.MyCartGoodsDao;
import com.itheima.takeout.model.protocol.BaseProtocol;
import com.itheima.takeout.model.protocol.IHttpService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 */
public class LoginFragment1Presenter extends BasePresenter {

    public LoginFragment1Presenter(BaseView baseView) {
        super(baseView);
    }

    /** 登录:使用电话号码 */
    public void login(String phone) {
        mProtocol.login(mBaseCallback, phone);
    }
}










