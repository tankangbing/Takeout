package com.itheima.takeout.model.dao;

import com.itheima.takeout.db.greendao.CartGoods;
import com.itheima.takeout.db.greendao.CartGoodsDao;

import java.util.List;

import de.greenrobot.dao.query.WhereCondition;

/**
     1. 新增一件商品
     2. 删除一件商品
     3. 清空购物车（删除某个商家所有的商品）
     4. 清空数据表（所有商家的所有商品）
     5. 商品数量加一
     6. 商品数量减一
     7. 查找购物车所有商品
 */
public class MyCartGoodsDao {

    /** 可以对购物车商品作增删改查 */
    private CartGoodsDao cartGoodsDao =
            GreenDaoHelper.getInstance().getCartGoodsDao();

    /** 新增一件商品*/
    public void save(CartGoods goods) {
        cartGoodsDao.insert(goods);
    }

    /** 删除一件商品 */
    public void delete(long goodsId) {
        // 查询属于该商家的所有商品: 商家id的值等于
        WhereCondition cond = CartGoodsDao.Properties.GoodsId.eq(goodsId);
        // 查询出来的结果
        List<CartGoods> goodsList = cartGoodsDao.queryBuilder().where(cond).build().list();
        if (goodsList != null && goodsList.size() > 0) {
            CartGoods goods = goodsList.get(0);
            cartGoodsDao.delete(goods);
        }
    }

    /** 删除一件商品 */
    public void delete2(CartGoods goods) {
        cartGoodsDao.delete(goods);
    }

    /** 清空数据表（所有商家的所有商品） */
    public void clear() {  // 删除表中所有的记录
        cartGoodsDao.deleteAll();
    }

    /** 清空购物车（删除某个商家所有的商品） */
    public void clear(int shopId) {
        // 查询属于该商家的所有商品: 商家id的值等于
        WhereCondition cond = CartGoodsDao.Properties.ShopId.eq(shopId);
        // 查询出来的结果
        List<CartGoods> goodsList = cartGoodsDao.queryBuilder().where(cond).build().list();
        if (goodsList != null) {
            // 开启事务删除多条记录
            cartGoodsDao.deleteInTx(goodsList);
        }
    }

    /** 商品数量加一 */
    public void increment(int goodsId) {
        // 查询属于该商家的所有商品: 商家id的值等于
        WhereCondition cond = CartGoodsDao.Properties.GoodsId.eq(goodsId);
        // 查询出来的结果
        List<CartGoods> goodsList = cartGoodsDao.queryBuilder().where(cond).build().list();
        if (goodsList != null && goodsList.size() > 0) {
            CartGoods goods = goodsList.get(0);
            goods.setCount(goods.getCount() + 1);   // 购买数量加1
            // 更新该条记录
            cartGoodsDao.update(goods);
        }
    }

    /** 商品数量减一 */
    public void decrement(int goodsId) {
        // 查询属于该商家的所有商品: 商家id的值等于
        WhereCondition cond = CartGoodsDao.Properties.GoodsId.eq(goodsId);
        // 查询出来的结果
        List<CartGoods> goodsList = cartGoodsDao.queryBuilder().where(cond).build().list();
        if (goodsList != null && goodsList.size() > 0) {
            CartGoods goods = goodsList.get(0);
            goods.setCount(goods.getCount() - 1);   // 购买数量减1
            // 更新该条记录
            cartGoodsDao.update(goods);
        }
    }

    /** 查找购物车所有商品 */
    public List<CartGoods> queryAll() {
        return cartGoodsDao.queryBuilder().build().list();
    }

}
