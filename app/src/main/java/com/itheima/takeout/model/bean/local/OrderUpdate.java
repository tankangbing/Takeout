package com.itheima.takeout.model.bean.local;

/**
 * @author admin
 */

public class OrderUpdate {
    /**
     * id : 1
     * msgType : 1
     * orderId : 1489223423501
     * orderStatus : 2
     * detail : 商家确认订单了
     */

    private int id;
    private int msgType;
    private long orderId;
    private int orderStatus;
    private String detail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
