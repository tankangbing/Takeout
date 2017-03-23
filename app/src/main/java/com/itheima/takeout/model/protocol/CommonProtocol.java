package com.itheima.takeout.model.protocol;

import com.itheima.common.base.Const;
import com.itheima.takeout.model.bean.Home;
import com.itheima.takeout.model.bean.OrderBy;
import com.itheima.takeout.model.bean.ShopCategory;
import com.itheima.takeout.model.bean.ShopList;

import java.util.HashMap;
import java.util.Map;


/**
 * 网络请求
 *
 * @author WJQ
 */
public class CommonProtocol extends BaseProtocol {

    public CommonProtocol() {
    }

    /** 获取首页数据 */
    public void getHomeData(final OnHttpCallback callback) {
        super.execute(super.getHttpService().getHomeData(),
                callback, IHttpService.TYPE_HOME, Home.class);
    }

    /** 获取商家排序条件数据 */
    public void getOrderBy(final OnHttpCallback callback) {
        super.execute(super.getHttpService().getOrderBy(),
                callback, IHttpService.TYPE_ORDER_BY, OrderBy.class);
    }

    /** 获取商家类别 */
    public void getShopCategory(final OnHttpCallback callback) {
        super.execute(super.getHttpService().getShopCategory(),
                callback, IHttpService.TYPE_SHOP_CATEGORY, ShopCategory.class);
    }

    /**
     * 获取附近商家列表
     *
     * @param callback
     * @param pageNo
     * @param pageCount
     * @param categoryId
     * @param orderBy
     * @param firstPage true:表示第一页，也就是下拉刷新
     */
    public void getShopList(final OnHttpCallback callback,
                            int pageNo, int pageCount,
                            int categoryId, int orderBy,
                            boolean firstPage) {

        Map<String, Object> map = new HashMap<String, Object>() ;
        map.put("latitude", 23d);   // 写死
        map.put("longitude", 113d);
        map.put("pageNo", pageNo);
        map.put("pageCount", pageCount);
        map.put("categoryId", categoryId);
        map.put("orderBy", orderBy);

        int what =  firstPage? Const.TYPE_REFRESH : Const.TYPE_LOAD_MORE;
        super.execute(super.getHttpService().getShopList(map),
                callback, IHttpService.TYPE_SHOP_LIST, ShopList.class, what);
    }
}
