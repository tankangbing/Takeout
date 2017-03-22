package com.itheima.takeout.ui.fragment;

import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.itheima.common.base.BaseFragment;
import com.itheima.takeout.R;
import com.itheima.takeout.dagger2.component.DaggerMainFragment1Component;
import com.itheima.takeout.dagger2.module.MainFragment1Module;
import com.itheima.takeout.model.bean.Home;
import com.itheima.takeout.model.bean.ShopList;
import com.itheima.takeout.model.protocol.CommonProtocol;
import com.itheima.takeout.model.protocol.IHttpService;
import com.itheima.takeout.presenter.HomeFragment1Presenter;
import com.itheima.takeout.ui.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author WJQ
 */
public class MainFragment1 extends BaseFragment
        implements CommonProtocol.OnHttpCallback{

    private RecyclerView recyclerView;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_01;
    }

    @Override
    public void initView() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView = findView(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        // 模拟数据
//        List<String> listData = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            listData.add("item " + (i + 1));
//        }

        List listData = new ArrayList();
        // 集合中会保存三种类型的javabean对象
        // Home : 头部数据
        // ShopListBean ： 商家数据
        // RecommendListBean  ： 广告
        listData.add(new Home());
        for (int i = 0; i < 10; i++) {
            listData.add(new ShopList.ShopListBean());
        }
        listData.add(new ShopList.RecommendListBean());

        HomeAdapter homeAdapter = new HomeAdapter(mActivity, listData);
        recyclerView.setAdapter(homeAdapter);
    }

    @Override
    public void initListener() {
    }

    @Inject
    HomeFragment1Presenter presenter;

    @Override
    public void initData() {
        // mProtocol = new CommonProtocol();
        // mProtocol.getHomeData(this);

        // presenter = new HomeFragment1Presenter(this);
        // 注入并初始化presenter对象
        DaggerMainFragment1Component.builder()
                .mainFragment1Module(new MainFragment1Module(this))
                .build().inject(this);

        presenter.getHomeData();
    }

    @Override
    public void onClick(View v, int id) {
    }

    @Override
    public void onHttpSuccess(int reqType, Message msg) {
        if (reqType == IHttpService.TYPE_HOME) {
            Home home = (Home) msg.obj;
            showToast("显示首页数据：" + home);
            // mProtocol.getShopList(this, 1, 10, 0, 0);
            presenter.getShopList(1, 10, 0, 0);
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
