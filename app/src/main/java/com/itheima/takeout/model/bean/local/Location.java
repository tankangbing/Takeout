package com.itheima.takeout.model.bean.local;

/**
 * @author admin
 */

public class Location {
    /**
     * id : 1
     * msgType : 2
     * orderId : 1489223423503
     * latitude : 23.1298039026
     * longitude : 113.4151531774
     */

    private int id;
    private int msgType;
    private long orderId;
    private double latitude;
    private double longitude;

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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
