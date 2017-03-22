package com.itheima.takeout.model.protocol;

import com.itheima.takeout.model.bean.Home;
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

    /** 获取附近商家列表 */
    public void getShopList(final OnHttpCallback callback,
                            int pageNo, int pageCount,
                            int categoryId, int orderBy) {

        Map<String, Object> map = new HashMap<String, Object>() ;
        map.put("latitude", 23d);   // 写死
        map.put("longitude", 113d);
        map.put("pageNo", pageNo);
        map.put("pageCount", pageCount);
        map.put("categoryId", categoryId);
        map.put("orderBy", orderBy);

        super.execute(super.getHttpService().getShopList(map),
                callback, IHttpService.TYPE_SHOP_LIST, ShopList.class);
    }
}
