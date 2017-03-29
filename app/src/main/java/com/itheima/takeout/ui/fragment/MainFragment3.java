package com.itheima.takeout.ui.fragment;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.itheima.common.base.BaseFragment;
import com.itheima.common.base.Const;
import com.itheima.common.base.OttoBus;
import com.itheima.common.util.SharedPreUtil;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.OrderList;
import com.itheima.takeout.model.bean.local.OrderUpdate;
import com.itheima.takeout.model.protocol.IHttpService;
import com.itheima.takeout.presenter.MainFragment3Presenter;
import com.itheima.takeout.ui.adapter.OrderListAdapter;
import com.squareup.otto.Subscribe;

import static com.itheima.common.base.Global.mContext;

/**
 * 订单界面
 *
 * @author WJQ
 */
public class MainFragment3 extends BaseFragment {

    private TextView tvTitle;
    private LinearLayout llLoginHint;
    private Button btnLogin;
    private LinearLayout llOrderListLayout;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private OrderListAdapter orderListAdapter;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_03;
    }

    @Override
    public void initView() {
        tvTitle = (TextView) findView(R.id.tv_title);
        btnLogin = (Button) findView(R.id.btn_login);
        swipeRefreshLayout = (SwipeRefreshLayout) findView(R.id.swipe_refresh_layout);

        llLoginHint = (LinearLayout) findView(R.id.ll_login_hint);
        llOrderListLayout = (LinearLayout) findView(R.id.ll_order_list_layout);

        recyclerView = (RecyclerView) findView(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        orderListAdapter = new OrderListAdapter(mActivity, null);
        recyclerView.setAdapter(orderListAdapter);

        mPresenter = new MainFragment3Presenter(this);
        checkLogin();
    }

    /** 根据登录状态，显示不同的布局 */
    private void checkLogin() {
        String token = SharedPreUtil.getString(mActivity, Const.SP_TOKEN, "");
        String userName = SharedPreUtil.getString(mActivity, Const.SP_USER_NAME, "");

        if (TextUtils.isEmpty(token)) { // 没有登录
            llLoginHint.setVisibility(View.VISIBLE);    // 显示登录提示
            llOrderListLayout.setVisibility(View.GONE); // 隐藏订单列表

        } else {    // 已登录
            llLoginHint.setVisibility(View.GONE);
            llOrderListLayout.setVisibility(View.VISIBLE);

            // mActivity.showDialog("提示", "请求订单列表数据");
            mPresenter.getOrderList(userName, token);
        }
    }

    @Override
    public void initListener() {
    }

    private MainFragment3Presenter mPresenter;

    @Override
    public void initData() {
    }

    @Override
    public void onClick(View v, int id) {
    }

    @Override
    public void onHttpSuccess(int reqType, Message msg) {
        // 获取订单列表数据
        if (reqType == IHttpService.TYPE_ORDER_LIST) {
            OrderList orderList = (OrderList) msg.obj;
            // showToast("订单个数：" + orderList.getOrderList().size());
            // 显示订单列表
            orderListAdapter.setDatas(orderList.getOrderList());
            return;
        }
    }

    //============otto事件监听(begin)====================
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 注册otto
        OttoBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 注销otto
        OttoBus.getDefault().unregister(this);
    }

    // 监听otto事件的方法
    @Subscribe
    public void onEvent(Message ottoMsg) {
        if (ottoMsg.what == IHttpService.TYPE_LOGIN
                || ottoMsg.what == IHttpService.TYPE_LOGOUT) {
            showToast("otto");
            checkLogin();
            return;
        }

        // 接收推送消息，更新列表订单状态
        if (ottoMsg.what == Const.TYPE_UPDATE_ORDER_STATUS){
            OrderUpdate bean = (OrderUpdate) ottoMsg.obj;
            // 更新列表中对应的订单状态
            orderListAdapter.updateOrderStatus(bean);
            return;
        }
    }
    //============otto事件监听(end)====================
}
