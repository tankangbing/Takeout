package com.itheima.takeout.ui.fragment;

import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.itheima.common.base.BaseFragment;
import com.itheima.common.base.Const;
import com.itheima.common.base.Global;
import com.itheima.takeout.R;
import com.itheima.takeout.dagger2.component.DaggerMainFragment1Component;
import com.itheima.takeout.dagger2.module.MainFragment1Module;
import com.itheima.takeout.model.bean.Home;
import com.itheima.takeout.model.bean.ShopList;
import com.itheima.takeout.model.protocol.CommonProtocol;
import com.itheima.takeout.model.protocol.IHttpService;
import com.itheima.takeout.presenter.HomeFragment1Presenter;
import com.itheima.takeout.ui.adapter.HomeAdapter;
import com.liaoinstan.springview.container.MeituanFooter;
import com.liaoinstan.springview.container.MeituanHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author WJQ
 */
public class MainFragment1 extends BaseFragment {

    private RecyclerView recyclerView;
    private HomeAdapter homeAdapter;

    private SpringView springView;
    private LinearLayout llTitleBar1;
    private TextView tvLocation;
    private TextView tvSearch01;
    private LinearLayout llTopLayout;
    private LinearLayout llTitleBar2;
    private LinearLayout llTitleBar2Left;
    private CheckBox cbCategory;
    private CheckBox cbOrderby;
    private TextView llTitleBar2Right;
    private LinearLayout llPopRoot01;
    private LinearLayout llPopContent01Category;
    private ListView lvCategory01;
    private ListView lvCategory02;
    private LinearLayout llPopRoot02;
    private LinearLayout llPopContent02OrderBy;
    private ListView lvOrderBy;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_01;
    }

    @Override
    public void initView() {
        springView = (SpringView) findView(R.id.spring_view);
        recyclerView = (RecyclerView) findView(R.id.recycler_view);
        llTitleBar1 = (LinearLayout) findView(R.id.ll_title_bar1);
        tvLocation = (TextView) findView(R.id.tv_location);
        tvSearch01 = (TextView) findView(R.id.tv_search_01);
        llTopLayout = (LinearLayout) findView(R.id.ll_top_layout);
        llTitleBar2 = (LinearLayout) findView(R.id.ll_title_bar2);
        llTitleBar2Left = (LinearLayout) findView(R.id.ll_title_bar2_left);
        cbCategory = (CheckBox) findView(R.id.cb_category);
        cbOrderby = (CheckBox) findView(R.id.cb_orderby);
        llTitleBar2Right = (TextView) findView(R.id.ll_title_bar2_right);
        llPopRoot01 = (LinearLayout) findView(R.id.ll_pop_root_01);
        llPopContent01Category = (LinearLayout) findView(R.id.ll_pop_content_01_category);
        lvCategory01 = (ListView) findView(R.id.lv_category_01);
        lvCategory02 = (ListView) findView(R.id.lv_category_02);
        llPopRoot02 = (LinearLayout) findView(R.id.ll_pop_root_02);
        llPopContent02OrderBy = (LinearLayout) findView(R.id.ll_pop_content_02_order_by);
        lvOrderBy = (ListView) findView(R.id.lv_order_by);
        
        initRecyclerView();
        initSpringView();
    }

    private void initSpringView() {
        springView.setHeader(new MeituanHeader(mActivity));
        springView.setFooter(new MeituanFooter(mActivity));
        springView.setType(SpringView.Type.FOLLOW);

        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {   // 下拉刷新
                // showToast("下拉刷新");

                presenter.getHomeData();
                // springView.onFinishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {  // 加载更多
                showToast("加载更多");
                presenter.getShopList();
            }
        });
    }

    private void initRecyclerView() {
        // 模拟数据
//        List<String> listData = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            listData.add("item " + (i + 1));
//        }

        // 模拟数据2
        // List listData = new ArrayList();
        // 集合中会保存三种类型的javabean对象
        // Home : 头部数据
        // ShopListBean ： 商家数据
        // RecommendListBean  ： 广告
        /*listData.add(new Home());
        for (int i = 0; i < 10; i++) {
            listData.add(new ShopList.ShopListBean());
        }
        listData.add(new ShopList.RecommendListBean());*/

        recyclerView = findView(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        homeAdapter = new HomeAdapter(mActivity, null);
        recyclerView.setAdapter(homeAdapter);
    }

    /**  recyclerView垂直方向滚动的距离 */
    private int mDistance;
    private int mRageHeight = Global.dp2px(150);

    @Override
    public void initListener() {
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            // 监听RecyclerView的滚动
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                mDistance += dy;

                // (1) 滚动列表时，改变标题栏1的透明度
                if (mDistance < 0) {
                    tvLocation.setAlpha(1);
                    tvSearch01.setAlpha(1);
                } else  {
                    // 0到1
                    float percent = Math.min(mDistance, mRageHeight) / ((float)mRageHeight);
                    tvLocation.setAlpha(1 - percent);
                    tvSearch01.setAlpha(1 - percent);
                }

                // (2)
            }
        });
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

    /** RecyclerView显示的数据集合 */
    private List listData = new ArrayList();

    @Override
    public void onHttpSuccess(int reqType, Message msg) {
        if (reqType == IHttpService.TYPE_HOME) {
            Home home = (Home) msg.obj;
            // showToast("显示首页数据：" + home);
            // 显示首页数据
            listData = new ArrayList();
            listData.add(home);
            // homeAdapter.setDatas(listData);

            // 加载商家列表数据
            // mProtocol.getShopList(this, 0, 0);
            presenter.getShopListRefresh();
            // presenter.getShopList(true);
            return;
        }

        if (reqType == IHttpService.TYPE_SHOP_LIST) {
            ArrayList pageDatas = (ArrayList) msg.obj;

            // 隐藏springView的头部和尾部
            springView.onFinishFreshAndLoad();

            // showToast("商家数据：" + bean.getShopList().size());
            // pageDatas: 10个商家+1则广告
            if (msg.what == Const.TYPE_REFRESH) {   // 下拉刷新
                ArrayList newDatas = new ArrayList();
                //  列表头部数据
                newDatas.add(listData.get(0));
                // 第一页数据和广告
                newDatas.addAll(pageDatas);

                listData = newDatas;
            } else { // 加载更多
                listData.addAll(pageDatas);
            }

            // 刷新列表显示
            homeAdapter.setDatas(listData);
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
