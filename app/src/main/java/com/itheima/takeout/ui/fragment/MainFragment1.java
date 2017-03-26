package com.itheima.takeout.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.itheima.common.base.BaseFragment;
import com.itheima.common.base.Const;
import com.itheima.common.base.Global;
import com.itheima.takeout.R;
import com.itheima.takeout.dagger2.module.MainFragment1Module;
import com.itheima.takeout.db.greendao.CartGoods;
import com.itheima.takeout.model.bean.Home;
import com.itheima.takeout.model.bean.OrderBy;
import com.itheima.takeout.model.bean.ShopCategory;
import com.itheima.takeout.model.bean.ShopList;
import com.itheima.takeout.model.protocol.IHttpService;
import com.itheima.takeout.presenter.HomeFragment1Presenter;
import com.itheima.takeout.ui.activity.MainActivity;
import com.itheima.takeout.ui.adapter.HomeAdapter;
import com.itheima.takeout.ui.adapter.OrderByAdapter;
import com.itheima.takeout.ui.adapter.ShopCategoryAdapter;
import com.liaoinstan.springview.container.MeituanFooter;
import com.liaoinstan.springview.container.MeituanHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private ShopCategoryAdapter mParentCategoryAdapter;
    private ShopCategoryAdapter mChildCategoryAdapter;
    private OrderByAdapter mOrderByAdapter;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_01;
    }

    private int mTitleBar2LeftWidth = Global.dp2px(100);
    private int mTitleBar2RightWidth = (int) (Global.mScreenWidth - Global.dp2px(100));

    @Override
    public void initView() {
        springView = (SpringView) findView(R.id.spring_view);
        recyclerView = (RecyclerView) findView(R.id.recycler_view);
        llTitleBar1 = (LinearLayout) findView(R.id.ll_title_bar1);
        tvLocation = (TextView) findView(R.id.tv_location);
        tvSearch01 = (TextView) findView(R.id.tv_search_01);
        llTopLayout = (LinearLayout) findView(R.id.ll_top_layout);
        cbCategory = (CheckBox) findView(R.id.cb_category);
        cbOrderby = (CheckBox) findView(R.id.cb_orderby);
        llPopRoot01 = (LinearLayout) findView(R.id.ll_pop_root_01);
        llPopContent01Category = (LinearLayout) findView(R.id.ll_pop_content_01_category);
        llPopRoot02 = (LinearLayout) findView(R.id.ll_pop_root_02);
        llPopContent02OrderBy = (LinearLayout) findView(R.id.ll_pop_content_02_order_by);

        lvCategory01 = (ListView) findView(R.id.lv_category_01);
        lvCategory02 = (ListView) findView(R.id.lv_category_02);
        lvOrderBy = (ListView) findView(R.id.lv_order_by);

        // 设置顶部padding, 否则沉侵式显示有问题
        Global.setStatusBarPadding(llTitleBar1);
        Global.setStatusBarPadding(llTopLayout);

        // 不显示分割线
        lvCategory01.setDividerHeight(0);
        lvCategory02.setDividerHeight(0);
        lvOrderBy.setDividerHeight(0);

        mParentCategoryAdapter = new ShopCategoryAdapter(mActivity, null);
        mChildCategoryAdapter = new ShopCategoryAdapter(mActivity, null);
        mOrderByAdapter = new OrderByAdapter(mActivity, null);

        lvCategory01.setAdapter(mParentCategoryAdapter);
        lvCategory02.setAdapter(mChildCategoryAdapter);
        lvOrderBy.setAdapter(mOrderByAdapter);

        // 标题栏2
        llTitleBar2 = (LinearLayout) findView(R.id.ll_title_bar2);
        llTitleBar2Left = (LinearLayout) findView(R.id.ll_title_bar2_left);
        llTitleBar2Right = (TextView) findView(R.id.ll_title_bar2_right);
        // 隐藏左右两部分
        llTitleBar2Left.setTranslationX(-mTitleBar2LeftWidth);
        llTitleBar2Right.setTranslationX(mTitleBar2RightWidth);

        llPopContent01Category.setTranslationY(-Global.dp2px(250));
        llPopContent02OrderBy.setTranslationY(-Global.dp2px(250));

        initRecyclerView();
        initSpringView();
    }

    private void initSpringView() {
        // springView.setHeader(new BaiduHeader(mActivity));
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
                presenter.getShopList(getShopCategory(), getOrderBy(), false);
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
    // 标题栏2隐藏状态
    private boolean mTitleBar2Show = false;

    RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() {
        // 监听RecyclerView的滚动
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            mDistance += dy;

            // (1) 滚动列表时，改变标题栏1的透明度
            if (mDistance < 0) {
                tvLocation.setAlpha(1);
                tvSearch01.setAlpha(1);
            } else {
                // 0到1
                float percent = Math.min(mDistance, mRageHeight) / ((float)
                        mRageHeight);
                tvLocation.setAlpha(1 - percent);
                tvSearch01.setAlpha(1 - percent);
            }

            // (2) 标题栏2的显示与隐藏
            if (!mTitleBar2Show && mDistance > mRageHeight) {
                // 隐藏 -> 显示
                mTitleBar2Show = true;
                showTitleBar2();
                // 状态栏设为黑包
                Global.setStatusBarColor(mActivity, Color.BLACK);

            } else if (mTitleBar2Show && mDistance < mRageHeight) {
                // 显示 -> 隐藏
                mTitleBar2Show = false;
                hideTitleBar2();

                // 状态栏透明
                Global.getMainHandler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Global.setNoStatusBarFullMode(mActivity);
                    }
                }, 300);
            }
        }
    };

    @Override
    public void initListener() {
        recyclerView.setOnScrollListener(mScrollListener);

        // 标题栏2两个CheckBox设置点击监听
        cbCategory.setOnClickListener(this);
        cbOrderby.setOnClickListener(this);
        llPopRoot01.setOnClickListener(this);
        llPopRoot02.setOnClickListener(this);

        lvCategory01.setOnItemClickListener(mOnItemClickListener);
        lvCategory02.setOnItemClickListener(mOnItemClickListener);
        lvOrderBy.setOnItemClickListener(mOnItemClickListener);
    }

    /** 当前选中的商家类别 */
    private ShopCategory.CategoryListBean mSelectedCategory;
    private OrderBy.OrderByListBean mSelectedOrderBy;

    private int getShopCategory() {
        // 0: 表示获取所有的商家
        return (mSelectedCategory == null) ? 0 : mSelectedCategory.getId();
    }

    private int orderBy = 0;

    private int getOrderBy() {
        return (mSelectedOrderBy == null) ? 0 : mSelectedOrderBy.getTag();
    }

    /** 列表项点击事件 */
    AdapterView.OnItemClickListener mOnItemClickListener
            = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (parent == lvCategory01) {   // 父类别列表
                // 点击选中的类别
                ShopCategory.CategoryListBean bean = (ShopCategory.CategoryListBean)
                        parent.getItemAtPosition(position);

                // (1) 高亮选中项
                mParentCategoryAdapter.mSelectedCategory = bean;
                mParentCategoryAdapter.notifyDataSetChanged();  // 刷新，高亮显示选中类别

                // (2) 显示右边子类别列表
                mChildCategoryAdapter.setDatas(bean.childCategory);

                // (3) 根据类别搜索商家数据
                boolean hasChildCategory = bean.childCategory.size() > 0;
                if (!hasChildCategory) {
                    // 没有子类别，请求对应的商家列表数据
                    mSelectedCategory = bean;
                    // 隐藏弹出窗口
                    showOrHideCategoryLayout();
                    // 重新根据类别搜索商家
                    presenter.getShopList(getShopCategory(), getOrderBy(), true);
                }
                return;
            }

            if (parent == lvCategory02) {   // 子类别列表
                // 点击选中的类别
                ShopCategory.CategoryListBean bean = (ShopCategory.CategoryListBean)
                        parent.getItemAtPosition(position);

                // (1) 高亮选中项
                mChildCategoryAdapter.mSelectedCategory = bean;
                mChildCategoryAdapter.notifyDataSetChanged();  // 刷新，高亮显示选中类别

                // (2) 根据类别搜索商家
                mSelectedCategory = bean;
                // 隐藏弹出窗口
                showOrHideCategoryLayout();
                // 重新根据类别搜索商家
                presenter.getShopList(getShopCategory(), getOrderBy(), true);

                return;
            }

            if (parent == lvOrderBy) {      // 排序条件列表
                // 点击选中的类别
                OrderBy.OrderByListBean bean = (OrderBy.OrderByListBean)
                        parent.getItemAtPosition(position);

                // (1) 高亮选中项
                mOrderByAdapter.mSelectedOrderBy = bean;
                mOrderByAdapter.notifyDataSetChanged();  // 刷新，高亮显示选中类别

                // (2) 根据排序条件搜索商家
                mSelectedOrderBy = bean;
                // 隐藏弹出窗口
                showOrHideOrderByLayout();
                // 重新根据排序条件搜索商家
                presenter.getShopList(getShopCategory(), getOrderBy(), true);
                return;
            }
        }
    };

    // 显示标题栏2
    private void showTitleBar2() {
        llTitleBar2.setVisibility(View.VISIBLE);
        llTitleBar2Left.animate().translationX(0)
                .setInterpolator(new OvershootInterpolator(1)).setDuration(300);
        llTitleBar2Right.animate().translationX(0)
                .setInterpolator(new OvershootInterpolator(1)).setDuration(300);
    }

    // 隐藏标题栏2
    private void hideTitleBar2() {
        llTitleBar2Left.animate().translationX(-mTitleBar2LeftWidth)
                .setInterpolator(new OvershootInterpolator(1)).setDuration(300);
        llTitleBar2Right.animate().translationX(mTitleBar2RightWidth)
                .setInterpolator(new OvershootInterpolator(1)).setDuration(300);
        Global.getMainHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                llTitleBar2.setVisibility(View.GONE);
            }
        }, 300);
    }

    @Inject
    HomeFragment1Presenter presenter;

    public HomeFragment1Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void initData() {
        // mProtocol = new CommonProtocol();
        // mProtocol.getHomeData(this);

         presenter = new HomeFragment1Presenter(this);
         // 注入并初始化presenter对象
//        DaggerMainFragment1Component.builder()
//                .mainFragment1Module(new MainFragment1Module(this))
//                .build().inject(this);

        presenter.getHomeData();
        presenter.getShopCategoryData();
        presenter.getOrderByData();
    }


    @Override
    public void onClick(View v, int id) {
        switch (id) {
            case R.id.ll_pop_root_01:
            case R.id.cb_category:      // 标题栏2类别CheckBox
                showOrHideCategoryLayout();
                break;
            case R.id.ll_pop_root_02:
            case R.id.cb_orderby:       // 标题栏2排序条件CheckBox
                showOrHideOrderByLayout();
                break;
        }
    }

    private void showOrHideCategoryLayout() {
        cbOrderby.setChecked(false);
        if (llPopRoot01.getVisibility() == View.GONE) {
            //  隐藏 -> 显示 类别窗口
            llPopRoot01.setVisibility(View.VISIBLE);
            llPopRoot02.setVisibility(View.GONE);

            // 从上往下移动
            llPopContent01Category.animate().translationY(0);
        } else { //  显示 -> 隐藏

            // 从下往上移动
            llPopContent01Category.animate().translationY(-Global.dp2px(250));
            Global.getMainHandler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    llPopRoot01.setVisibility(View.GONE);
                }
            }, 300);
        }
    }

    private void showOrHideOrderByLayout() {
        cbCategory.setChecked(false);

        if (llPopRoot02.getVisibility() == View.GONE) {
            //  隐藏 -> 显示 类别窗口
            llPopRoot02.setVisibility(View.VISIBLE);
            llPopRoot01.setVisibility(View.GONE);
            // 从上往下移动
            llPopContent02OrderBy.animate().translationY(0);
        } else { //  显示 -> 隐藏
            // 从下往上移动
            llPopContent02OrderBy.animate().translationY(-Global.dp2px(250));
            Global.getMainHandler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    llPopRoot02.setVisibility(View.GONE);
                }
            }, 300);
        }
    }

    /** RecyclerView显示的数据集合 */
    private List listData = new ArrayList();

    public List getListData() {
        return listData;
    }

    public HomeAdapter getHomeAdapter() {
        return homeAdapter;
    }


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
            presenter.getShopList(getShopCategory(), getOrderBy(), true);
            return;
        }

        if (reqType == IHttpService.TYPE_SHOP_CATEGORY) {
            // 所有的商家父类别
            ArrayList<ShopCategory.CategoryListBean> parentCategory =
                    (ArrayList<ShopCategory.CategoryListBean>) msg.obj;
            // 显示父类别
            mParentCategoryAdapter.setDatas(parentCategory);
            return;
        }

        if (reqType == IHttpService.TYPE_ORDER_BY) {
            OrderBy bean = (OrderBy) msg.obj;
            mOrderByAdapter.setDatas(bean.getOrderByList());
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

            // 刷新商家购物车商品数量
            ((MainActivity) mActivity).updateShopGoodsCount();
            return;
        }
    }

    @Override
    public void onHttpError(int reqType, String error) {
        if (reqType == IHttpService.TYPE_HOME) {
            showToast("请求失败：" + error);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
