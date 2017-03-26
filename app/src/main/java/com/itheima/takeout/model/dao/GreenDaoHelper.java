package com.itheima.takeout.model.dao;

import android.database.sqlite.SQLiteDatabase;

import com.itheima.common.base.Global;
import com.itheima.takeout.db.greendao.CartGoodsDao;
import com.itheima.takeout.db.greendao.DaoMaster;
import com.itheima.takeout.db.greendao.DaoSession;

/**
 * GreenDao操作辅助类 (单例，格式相对固定)
 * 作用： 创建数据库
 *
 * @author admin
 */
public class GreenDaoHelper {

    private static GreenDaoHelper instance;
    private static DaoSession daoSession;

    private GreenDaoHelper() {
    }

    public static GreenDaoHelper getInstance() {
        if (instance == null) {
            synchronized (GreenDaoHelper.class) {
                if (instance == null) {
                    instance = new GreenDaoHelper();

                    // 初始化数据库：
                    // Helper -> SQLiteDatabase -> DaoMaster -> DaoSession -> 得到DAO对象
                    DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(
                            Global.mContext, "db_takout", null);
                    SQLiteDatabase db = helper.getWritableDatabase();
                    DaoMaster master = new DaoMaster(db);
                    daoSession = master.newSession();
                    // 购物车增删改查的操作类
                    // CartGoodsDao cartGoodsDao = daoSession.getCartGoodsDao();
                }
            }
        }
        return instance;
    }

    /** 购物车商品增删改查的操作类 */
    public CartGoodsDao getCartGoodsDao() {
        return daoSession.getCartGoodsDao();
    }
}
