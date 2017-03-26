package com.itheima.takeout.presenter;

import android.os.Message;

import com.itheima.common.base.Global;
import com.itheima.takeout.base.BasePresenter;
import com.itheima.takeout.base.BaseView;
import com.itheima.takeout.model.bean.ShopCategory;
import com.itheima.takeout.model.bean.ShopList;
import com.itheima.takeout.model.dao.MyCartGoodsDao;
import com.itheima.takeout.model.protocol.BaseProtocol;
import com.itheima.takeout.model.protocol.IHttpService;

import java.util.ArrayList;

/**
 * Presenter层
 * @author WJQ
 */
public class HomeFragment1Presenter extends BasePresenter {

    /** 第几页数据 */
    private int mPageNo = 1;
    /** 每页多少条 */
    private int mPageCount = 10;

    private MyCartGoodsDao goodsDao = new MyCartGoodsDao();

    public MyCartGoodsDao getGoodsDao() {
        return goodsDao;
    }

    public BaseProtocol.OnHttpCallback mCallback
            = new BaseProtocol.OnHttpCallback() {
        @Override
        public void onHttpSuccess(int reqType, Message msg) {
            if (reqType == IHttpService.TYPE_SHOP_CATEGORY) {
                // 处理并转换数据，回调用界面
                ShopCategory shopCategory = (ShopCategory) msg.obj;
                // 转换数据
                msg.obj = transformShopCategory(shopCategory);
                // 返回到界面
                baseView.onHttpSuccess(reqType, msg);
                return;
            }

            if (reqType == IHttpService.TYPE_SHOP_LIST) {
                // 处理并转换数据，回调用界面
                // 处理并转换数据
                ShopList bean = (ShopList) msg.obj;
                ArrayList pageData = new ArrayList();
                // 一页数据：10个商家
                pageData.addAll(bean.getShopList());

                // 加载显示一则广告
                if (bean.getShopList() != null
                        && bean.getShopList().size() == 10
                        && bean.getRecommendList() != null
                        && bean.getRecommendList().size() > 0) {
                    // 显示了10个家商后，才显示一则广告
                    pageData.add(bean.getRecommendList().get(0));
                }
                msg.obj = pageData;

                mPageNo++;

                if (pageData.size() < 1) {
                    Global.showToast("已经是最后一页了");
                }

                // 返回到界面
                baseView.onHttpSuccess(reqType, msg);
                return;
            }
        }

        @Override
        public void onHttpError(int reqType, String error) {
            baseView.onHttpError(reqType, error);
        }
    };

    /**
     * 转换数据
     * @param shopCategory
     * @return
     */
    private ArrayList<ShopCategory.CategoryListBean>
            transformShopCategory(ShopCategory shopCategory) {

        // （1）查找所有的商家父类别
        ArrayList<ShopCategory.CategoryListBean> parentCategory
                = new ArrayList<ShopCategory.CategoryListBean>();
        for (ShopCategory.CategoryListBean bean :
                shopCategory.getCategoryList()) {
            // id为-1表示父类别
            if (bean.getParentCategory() == -1) {
                parentCategory.add(bean);
            }
        }

        // （2）给每个父类别添加子类别
        for (ShopCategory.CategoryListBean parent : parentCategory) {
            // 遍历所有的类别
            for (ShopCategory.CategoryListBean bean :
                    shopCategory.getCategoryList()) {
                if (bean.getParentCategory() == parent.getId()) {
                    parent.childCategory.add(bean);
                }
            }
        }

        // （3）添加“全部”
        ShopCategory.CategoryListBean allBean =
                new ShopCategory.CategoryListBean();
        allBean.setId(0);
        allBean.setName("全部");
        allBean.setParentCategory(-1);
        // 总商家个数
        int totalCount = 0;
        for (ShopCategory.CategoryListBean category : parentCategory) {
            totalCount += category.getShopCount();
        }
        allBean.setShopCount(totalCount);
        // 加到集合的第一个位置
        parentCategory.add(0, allBean);

        return parentCategory;
    }

    public HomeFragment1Presenter(BaseView baseView) {
        super(baseView);
    }

    public void getHomeData() {
        // P层 调用 M层
        mProtocol.getHomeData(mBaseCallback);
    }

    public void getShopCategoryData() {
        mProtocol.getShopCategory(mCallback);
    }

    public void getOrderByData() {
        mProtocol.getOrderBy(mBaseCallback);
    }

    /**
     * 传true表示加载第一页数据
     *
     * @param firstPage
     */
    public void getShopList(boolean firstPage) {
        if (firstPage)
            mPageNo = 1;
        // 0: 获取所有的商家
        mProtocol.getShopList(mCallback, mPageNo,
                mPageCount, 0, 0, firstPage);
    }

    /**
     * 搜索商家
     *
     * @param shopCategory 商家类别
     * @param orderBy 排序条件
     * @param firstPage 是否是搜索第一页数据
     */
    public void getShopList(int shopCategory, int orderBy, boolean firstPage) {
        if (firstPage)
            mPageNo = 1;
        // 0: 获取所有的商家
        mProtocol.getShopList(mCallback, mPageNo,
                mPageCount, shopCategory, orderBy, firstPage);
    }

    /** 下拉刷新 */
    public void getShopListRefresh() {
        mPageNo = 1;
        // 0: 获取所有的商家
        mProtocol.getShopList(mCallback, mPageNo,
                mPageCount, 0, 0, true);
    }

    /** 加载分页数据 */
    public void getShopList() {
        // 0: 获取所有的商家
        mProtocol.getShopList(mCallback, mPageNo,
                mPageCount, 0, 0, false);
    }
}
