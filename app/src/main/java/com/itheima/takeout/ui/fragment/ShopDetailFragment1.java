package com.itheima.takeout.ui.fragment;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.itheima.common.base.BaseFragment;
import com.itheima.common.base.Const;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.ShopList;
import com.itheima.takeout.model.bean.local.ShopGoods;
import com.itheima.takeout.model.protocol.IHttpService;
import com.itheima.takeout.presenter.ShopDetailFragment1Presenter;
import com.itheima.takeout.ui.adapter.GoodsAdapter;
import com.itheima.takeout.ui.adapter.GoodsCategoryAdapter;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * 商家详情子界面1： 点菜
 *
 * @author admin
 */
public class ShopDetailFragment1 extends BaseFragment {

    private RecyclerView recyclerView;
    private StickyListHeadersListView mListViewRight;

    /** 商家数据 */
    private ShopList.ShopListBean mShop;

    private ShopDetailFragment1Presenter mPresenter;
    private GoodsCategoryAdapter mCategoryAdapter;
    private GoodsAdapter mGoodsAdapter;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_shop_detail_01;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // (2) 接收从Activity传递过来的参数
        Bundle bundle = getArguments();
        mShop = (ShopList.ShopListBean) bundle.getSerializable(Const.KEY_BEAN);
    }

    @Override
    public void initView() {
        recyclerView = (RecyclerView) findView(R.id.rv_goods_type);
        mListViewRight = (StickyListHeadersListView) findView(R.id.slhlv);

        // 显示左侧列表
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mCategoryAdapter = new GoodsCategoryAdapter(mActivity, null);
        recyclerView.setAdapter(mCategoryAdapter);

        // 显示右侧列表
        mGoodsAdapter = new GoodsAdapter(mActivity, null);
        mListViewRight.setAdapter(mGoodsAdapter);
    }

    @Override
    public void initListener() {
    }

    @Override
    public void initData() {
        mPresenter = new ShopDetailFragment1Presenter(this);
        mPresenter.getShopDetail(mShop.getId());
    }

    @Override
    public void onClick(View v, int id) {
    }

    // 网络请求成功
    @Override
    public void onHttpSuccess(int reqType, Message msg) {
        // 获取商家详情数据
        if (reqType == IHttpService.TYPE_SHOP_DETAIL) {
            ShopGoods bean = (ShopGoods) msg.obj;
            // showToast("类别个数：" + bean.mAllCategory.size());
            // showToast("商品总个数：" + bean.mAllGoods.size());

            // 刷新左侧列表的显示
            mCategoryAdapter.setDatas(bean.mAllCategory);
            // 刷新右侧列表显示
            mGoodsAdapter.setDatas(bean.mAllGoods);
            return;
        }
    }
}
