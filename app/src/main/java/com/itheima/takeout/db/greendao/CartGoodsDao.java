package com.itheima.takeout.db.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.itheima.takeout.db.greendao.CartGoods;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CART_GOODS".
*/
public class CartGoodsDao extends AbstractDao<CartGoods, Long> {

    public static final String TABLENAME = "CART_GOODS";

    /**
     * Properties of entity CartGoods.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property GoodsId = new Property(1, Integer.class, "goodsId", false, "GOODS_ID");
        public final static Property CategoryId = new Property(2, Integer.class, "categoryId", false, "CATEGORY_ID");
        public final static Property ShopId = new Property(3, Integer.class, "shopId", false, "SHOP_ID");
        public final static Property Count = new Property(4, Integer.class, "count", false, "COUNT");
    };


    public CartGoodsDao(DaoConfig config) {
        super(config);
    }
    
    public CartGoodsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CART_GOODS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"GOODS_ID\" INTEGER," + // 1: goodsId
                "\"CATEGORY_ID\" INTEGER," + // 2: categoryId
                "\"SHOP_ID\" INTEGER," + // 3: shopId
                "\"COUNT\" INTEGER);"); // 4: count
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CART_GOODS\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, CartGoods entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer goodsId = entity.getGoodsId();
        if (goodsId != null) {
            stmt.bindLong(2, goodsId);
        }
 
        Integer categoryId = entity.getCategoryId();
        if (categoryId != null) {
            stmt.bindLong(3, categoryId);
        }
 
        Integer shopId = entity.getShopId();
        if (shopId != null) {
            stmt.bindLong(4, shopId);
        }
 
        Integer count = entity.getCount();
        if (count != null) {
            stmt.bindLong(5, count);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public CartGoods readEntity(Cursor cursor, int offset) {
        CartGoods entity = new CartGoods( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // goodsId
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // categoryId
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // shopId
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4) // count
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, CartGoods entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setGoodsId(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setCategoryId(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setShopId(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setCount(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(CartGoods entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(CartGoods entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
