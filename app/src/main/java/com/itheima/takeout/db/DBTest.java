package com.itheima.takeout.db;

import com.itheima.common.util.LogUtil;
import com.itheima.takeout.db.greendao.CartGoods;
import com.itheima.takeout.model.bean.ShopDetail;
import com.itheima.takeout.model.dao.MyCartGoodsDao;

import java.util.List;

/**
 * @author admin
 */

public class DBTest {

    MyCartGoodsDao dao = new MyCartGoodsDao();

    public void test() {
        // 增
        LogUtil.d("---------------增-------------");
        // 自增id     商品id    类别id     商家id    购买数量
        CartGoods bean1 = new CartGoods(null, 10, 1, 1, 2);
        CartGoods bean2 = new CartGoods(null, 11, 1, 2, 2);
        CartGoods bean3 = new CartGoods(null, 12, 1, 3, 2);
        dao.save(bean1);
        dao.save(bean2);
        dao.save(bean3);
        printAllData();

        // 删
        LogUtil.d("---------------删-------------");
        dao.delete(10L);        // 删除商品id为10的记录
        printAllData();

        // 改
        LogUtil.d("---------------改-------------");
        dao.increment(11);     // id为11的商品购买数量加1
        dao.decrement(12);     // id为12的商品购买数量减1
        printAllData();

        LogUtil.d("---------------清空某商家-------------");
        dao.clear(2);          // 清空商家id为2的所有的商品
        printAllData();

        LogUtil.d("---------------清空所有-------------");
        dao.clear();
        printAllData();
    }

    private void printAllData() {
        List<CartGoods> cartGoods = dao.queryAll();
        for (CartGoods bean : cartGoods) {
            LogUtil.d("--------" + bean);
        }
    }
}
