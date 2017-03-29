package com.itheima.takeout.model.bean.local;


import retrofit2.http.Field;

/**
 * 订单状态
 *
 * @author admin
 */
public enum OrderStatus {

//    订单状态：
//            0： 已提交 -- 未支付
//            1： 已支付 -- 商家尚未接单（10分钟内商家未接单，将自动取消）
//            2： 商家确认接单 -- 商品尚未送出
//            3： 已出发 -- 商品已送出，送餐员在路上
//            4： 已送达 -- 客户收到商品, 尚未评价
//            5： 已完成 -- 订单完成，已评价
//            6： 已取消

    CREATE(0, "已提交"),
    PAY(1, "已支付"),
    CONFIRM(2, "商家确认接单"),
    DELIVERING(3, "已送出"),
    DELIVERED(4, "已送达"),
    FINISH(5, "已完成"),
    CANCEL(6, "已取消");

    public int status;
    public String info;

    private OrderStatus(int status, String info) {
        this.status = status;
        this.info = info;
    }

    /** 获取订单描述 */
    public static String getInfo(int status) {
        if (status == 0) {
            return CREATE.info;
        }
        if (status == 1) {
            return PAY.info;
        }
        if (status == 2) {
            return CONFIRM.info;
        }
        if (status == 3) {
            return DELIVERING.info;
        }
        if (status == 4) {
            return DELIVERED.info;
        }
        if (status == 5) {
            return FINISH.info;
        }
        return CANCEL.info;
    }
}
