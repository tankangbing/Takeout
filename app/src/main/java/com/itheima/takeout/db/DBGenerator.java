package com.itheima.takeout.db;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * @author admin
 */

public class DBGenerator {

    public static void main(String[] args) {
        // 生成GreenDao的模板代码

        // 参数1： 数据库版本
        // 参数2： 模板代码要生成在此包下
        Schema schema = new Schema(1, "com.itheima.takeout.db.greendao");

        // 定义数据库表：表1: 购物车商品
        // 自增id， 商品id， 商品类别id， 商家id， 购买数量
        Entity cartGoods = schema.addEntity("CartGoods");
        cartGoods.addIdProperty().autoincrement();      // 自增的主键
        cartGoods.addIntProperty("goodsId");
        cartGoods.addIntProperty("categoryId");
        cartGoods.addIntProperty("shopId");
        cartGoods.addIntProperty("count");
        //cartGoods.addStringProperty("goodsName");

        // 定义数据库表：表2： 收件人地址
        // Entity Address = schema.addEntity("Address");

        // 生成模板代码
        try {
            new DaoGenerator().generateAll(schema,
                    "H:\\_H04\\08.Takeout\\_code\\Takeout\\app\\src\\main\\java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}












