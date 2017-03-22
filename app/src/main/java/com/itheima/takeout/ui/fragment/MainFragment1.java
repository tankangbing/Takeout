package com.itheima.takeout.ui.fragment;

import android.os.Message;
import android.view.View;

import com.itheima.common.base.BaseFragment;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.Home;
import com.itheima.takeout.model.bean.ShopList;
import com.itheima.takeout.model.protocol.CommonProtocol;
import com.itheima.takeout.model.protocol.IHttpService;

/**
 * @author WJQ
 */
public class MainFragment1 extends BaseFragment
        implements CommonProtocol.OnHttpCallback{

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_01;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initListener() {
    }

    private CommonProtocol mProtocol;

    @Override
    public void initData() {
        mProtocol = new CommonProtocol();
        mProtocol.getHomeData(this);
    }

    @Override
    public void onClick(View v, int id) {
    }

    @Override
    public void onHttpSuccess(int reqType, Message msg) {
        if (reqType == IHttpService.TYPE_HOME) {
            Home home = (Home) msg.obj;
            showToast("显示首页数据：" + home);
            mProtocol.getShopList(this, 1, 10, 0, 0);
            return;
        }

        if (reqType == IHttpService.TYPE_SHOP_LIST) {
            ShopList bean = (ShopList) msg.obj;
            showToast("商家数据：" + bean.getShopList().size());
            return;
        }
    }

    @Override
    public void onHttpError(int reqType, String error) {
        if (reqType == IHttpService.TYPE_HOME) {
            showToast("请求失败：" + error);
        }
    }
}
