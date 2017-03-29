package com.itheima.takeout.model.bean;

import java.util.List;

/**
 * @author admin
 */

public class OrderList {

    /**
     * error :
     * orderList : [{"createTime":1489659994037,"deliveryFee":9,
     * "goods":[{"bargainPrice":false,"detail":"","feedbackRate":0,"id":1,"image":"",
     * "monthSaleCount":0,"name":"红石榴风味派","newPrice":12,"oldPrice":12,"quantity":2,
     * "tag":0},{"bargainPrice":false,"detail":"","feedbackRate":0,"id":2,"image":"",
     * "monthSaleCount":0,"name":"两块香辣鸡翅","newPrice":12,"oldPrice":12,"quantity":1,
     * "tag":0}],"id":1489223423501,"orderStatus":1,"otherInfo":{"address":"广州传智",
     * "addressDetail":"广州市天河区珠吉路自编58号津安创意园","deliveryDes":"商家配送",
     * "deliveryTime":1489660294037,"deliveryType":0,"invoice":false,
     * "invoiceInfo":"广州黑马","payDes":"在线支付","payType":1,"remarks":"无","sex":1,
     * "username":"WangJQ"},"packageFee":0,"shop":{"averageConsume":0,"categoryId":0,
     * "deliveryFee":"","distance":0,"id":1,
     * "image":"http://192.168.56.3:8080/TakeoutService/imgs/goods/icon_md.png",
     * "invoice":false,"latitude":0,"longitude":0,"monthSaleCount":0,"name":"麦当劳(广州东圃店)
     * ","onlineTime":0,"promotionId":0,"recentVisit":"","score":0,"sendPrice":0,
     * "tag":0}},{"createTime":1489659894037,"deliveryFee":9,
     * "goods":[{"bargainPrice":false,"detail":"","feedbackRate":0,"id":1,"image":"",
     * "monthSaleCount":0,"name":"新奥尔良烤翅","newPrice":12,"oldPrice":12,"quantity":1,
     * "tag":0},{"bargainPrice":false,"detail":"","feedbackRate":0,"id":2,"image":"",
     * "monthSaleCount":0,"name":"两块香辣鸡翅","newPrice":12,"oldPrice":12,"quantity":1,
     * "tag":0},{"bargainPrice":false,"detail":"","feedbackRate":0,"id":3,"image":"",
     * "monthSaleCount":0,"name":"红石榴风味派","newPrice":7,"oldPrice":7,"quantity":2,
     * "tag":0}],"id":1489223423502,"orderStatus":2,"otherInfo":{"address":"广州传智",
     * "addressDetail":"广州市天河区珠吉路自编58号津安创意园","deliveryDes":"商家配送",
     * "deliveryTime":1489660294037,"deliveryType":0,"invoice":false,
     * "invoiceInfo":"广州黑马","payDes":"在线支付","payType":1,"remarks":"无","sex":1,
     * "username":"WangJQ"},"packageFee":0,"shop":{"averageConsume":0,"categoryId":0,
     * "deliveryFee":"","distance":0,"id":2,
     * "image":"http://192.168.56.3:8080/TakeoutService/imgs/goods/icon_kfc.png",
     * "invoice":false,"latitude":0,"longitude":0,"monthSaleCount":0,"name":"肯德基宅急送
     * (奥体店)","onlineTime":0,"promotionId":0,"recentVisit":"","score":0,"sendPrice":0,
     * "tag":0}},{"createTime":1489659794037,"deliveryFee":9,
     * "goods":[{"bargainPrice":false,"detail":"","feedbackRate":0,"id":2,"image":"",
     * "monthSaleCount":0,"name":"两块香辣鸡翅","newPrice":12,"oldPrice":12,"quantity":1,
     * "tag":0},{"bargainPrice":false,"detail":"","feedbackRate":0,"id":1,"image":"",
     * "monthSaleCount":0,"name":"新奥尔良烤翅","newPrice":12,"oldPrice":12,"quantity":1,
     * "tag":0},{"bargainPrice":false,"detail":"","feedbackRate":0,"id":3,"image":"",
     * "monthSaleCount":0,"name":"红石榴风味派","newPrice":7,"oldPrice":7,"quantity":2,
     * "tag":0}],"id":1489223423503,"orderStatus":3,"otherInfo":{"address":"广州传智",
     * "addressDetail":"广州市天河区珠吉路自编58号津安创意园","deliveryDes":"商家配送",
     * "deliveryTime":1489660294037,"deliveryType":0,"invoice":false,
     * "invoiceInfo":"广州黑马","payDes":"在线支付","payType":1,"remarks":"无","sex":1,
     * "username":"WangJQ"},"packageFee":0,"shop":{"averageConsume":0,"categoryId":0,
     * "deliveryFee":"","distance":0,"id":2,
     * "image":"http://192.168.56.3:8080/TakeoutService/imgs/goods/icon_kfc.png",
     * "invoice":false,"latitude":0,"longitude":0,"monthSaleCount":0,"name":"肯德基宅急送
     * (奥体店)","onlineTime":0,"promotionId":0,"recentVisit":"","score":0,"sendPrice":0,
     * "tag":0}},{"createTime":1489659794037,"deliveryFee":9,
     * "goods":[{"bargainPrice":false,"detail":"","feedbackRate":0,"id":3,"image":"",
     * "monthSaleCount":0,"name":"红石榴风味派","newPrice":7,"oldPrice":7,"quantity":2,
     * "tag":0},{"bargainPrice":false,"detail":"","feedbackRate":0,"id":2,"image":"",
     * "monthSaleCount":0,"name":"两块香辣鸡翅","newPrice":12,"oldPrice":12,"quantity":1,
     * "tag":0}],"id":1489223423504,"orderStatus":4,"otherInfo":{"address":"广州传智",
     * "addressDetail":"广州市天河区珠吉路自编58号津安创意园","deliveryDes":"商家配送",
     * "deliveryTime":1489660294037,"deliveryType":0,"invoice":false,
     * "invoiceInfo":"广州黑马","payDes":"在线支付","payType":1,"remarks":"无","sex":1,
     * "username":"WangJQ"},"packageFee":0,"shop":{"averageConsume":0,"categoryId":0,
     * "deliveryFee":"","distance":0,"id":2,
     * "image":"http://192.168.56.3:8080/TakeoutService/imgs/goods/icon_kfc.png",
     * "invoice":false,"latitude":0,"longitude":0,"monthSaleCount":0,"name":"肯德基宅急送
     * (奥体店)","onlineTime":0,"promotionId":0,"recentVisit":"","score":0,"sendPrice":0,
     * "tag":0}},{"createTime":1489659694037,"deliveryFee":9,
     * "goods":[{"bargainPrice":false,"detail":"","feedbackRate":0,"id":3,"image":"",
     * "monthSaleCount":0,"name":"红石榴风味派","newPrice":7,"oldPrice":7,"quantity":2,
     * "tag":0},{"bargainPrice":false,"detail":"","feedbackRate":0,"id":2,"image":"",
     * "monthSaleCount":0,"name":"两块香辣鸡翅","newPrice":12,"oldPrice":12,"quantity":2,
     * "tag":0}],"id":1489223423505,"orderStatus":5,"otherInfo":{"address":"广州传智",
     * "addressDetail":"广州市天河区珠吉路自编58号津安创意园","deliveryDes":"商家配送",
     * "deliveryTime":1489660294037,"deliveryType":0,"invoice":false,
     * "invoiceInfo":"广州黑马","payDes":"在线支付","payType":1,"remarks":"无","sex":1,
     * "username":"WangJQ"},"packageFee":0,"shop":{"averageConsume":0,"categoryId":0,
     * "deliveryFee":"","distance":0,"id":2,
     * "image":"http://192.168.56.3:8080/TakeoutService/imgs/goods/icon_kfc.png",
     * "invoice":false,"latitude":0,"longitude":0,"monthSaleCount":0,"name":"肯德基宅急送
     * (奥体店)","onlineTime":0,"promotionId":0,"recentVisit":"","score":0,"sendPrice":0,
     * "tag":0}},{"createTime":1489659494037,"deliveryFee":9,
     * "goods":[{"bargainPrice":false,"detail":"","feedbackRate":0,"id":2,"image":"",
     * "monthSaleCount":0,"name":"两块香辣鸡翅","newPrice":12,"oldPrice":12,"quantity":3,
     * "tag":0},{"bargainPrice":false,"detail":"","feedbackRate":0,"id":1,"image":"",
     * "monthSaleCount":0,"name":"红石榴风味派","newPrice":12,"oldPrice":12,"quantity":2,
     * "tag":0}],"id":1489223423506,"orderStatus":6,"otherInfo":{"address":"广州传智",
     * "addressDetail":"广州市天河区珠吉路自编58号津安创意园","deliveryDes":"商家配送",
     * "deliveryTime":1489660294037,"deliveryType":0,"invoice":false,
     * "invoiceInfo":"广州黑马","payDes":"在线支付","payType":1,"remarks":"无","sex":1,
     * "username":"WangJQ"},"packageFee":0,"shop":{"averageConsume":0,"categoryId":0,
     * "deliveryFee":"","distance":0,"id":3,
     * "image":"http://192.168.56.3:8080/TakeoutService/imgs/goods/icon_hm.png",
     * "invoice":false,"latitude":0,"longitude":0,"monthSaleCount":0,"name":"黑马外卖
     * (广州吉山店)","onlineTime":0,"promotionId":0,"recentVisit":"","score":0,
     * "sendPrice":0,"tag":0}}]
     * status : 0
     */

    private String error;
    private int status;
    private List<OrderListBean> orderList;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<OrderListBean> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderListBean> orderList) {
        this.orderList = orderList;
    }

    public static class OrderListBean {
        /**
         * createTime : 1489659994037
         * deliveryFee : 9
         * goods : [{"bargainPrice":false,"detail":"","feedbackRate":0,"id":1,
         * "image":"","monthSaleCount":0,"name":"红石榴风味派","newPrice":12,"oldPrice":12,
         * "quantity":2,"tag":0},{"bargainPrice":false,"detail":"","feedbackRate":0,
         * "id":2,"image":"","monthSaleCount":0,"name":"两块香辣鸡翅","newPrice":12,
         * "oldPrice":12,"quantity":1,"tag":0}]
         * id : 1489223423501
         * orderStatus : 1
         * otherInfo : {"address":"广州传智","addressDetail":"广州市天河区珠吉路自编58号津安创意园",
         * "deliveryDes":"商家配送","deliveryTime":1489660294037,"deliveryType":0,
         * "invoice":false,"invoiceInfo":"广州黑马","payDes":"在线支付","payType":1,
         * "remarks":"无","sex":1,"username":"WangJQ"}
         * packageFee : 0
         * shop : {"averageConsume":0,"categoryId":0,"deliveryFee":"","distance":0,
         * "id":1,"image":"http://192.168.56.3:8080/TakeoutService/imgs/goods/icon_md
         * .png","invoice":false,"latitude":0,"longitude":0,"monthSaleCount":0,
         * "name":"麦当劳(广州东圃店)","onlineTime":0,"promotionId":0,"recentVisit":"",
         * "score":0,"sendPrice":0,"tag":0}
         */

        private long createTime;
        private int deliveryFee;
        private long id;
        private int orderStatus;
        private OtherInfoBean otherInfo;
        private int packageFee;
        private ShopBean shop;
        private List<GoodsBean> goods;

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getDeliveryFee() {
            return deliveryFee;
        }

        public void setDeliveryFee(int deliveryFee) {
            this.deliveryFee = deliveryFee;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public OtherInfoBean getOtherInfo() {
            return otherInfo;
        }

        public void setOtherInfo(OtherInfoBean otherInfo) {
            this.otherInfo = otherInfo;
        }

        public int getPackageFee() {
            return packageFee;
        }

        public void setPackageFee(int packageFee) {
            this.packageFee = packageFee;
        }

        public ShopBean getShop() {
            return shop;
        }

        public void setShop(ShopBean shop) {
            this.shop = shop;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public static class OtherInfoBean {
            /**
             * address : 广州传智
             * addressDetail : 广州市天河区珠吉路自编58号津安创意园
             * deliveryDes : 商家配送
             * deliveryTime : 1489660294037
             * deliveryType : 0
             * invoice : false
             * invoiceInfo : 广州黑马
             * payDes : 在线支付
             * payType : 1
             * remarks : 无
             * sex : 1
             * username : WangJQ
             */

            private String address;
            private String addressDetail;
            private String deliveryDes;
            private long deliveryTime;
            private int deliveryType;
            private boolean invoice;
            private String invoiceInfo;
            private String payDes;
            private int payType;
            private String remarks;
            private int sex;
            private String username;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getAddressDetail() {
                return addressDetail;
            }

            public void setAddressDetail(String addressDetail) {
                this.addressDetail = addressDetail;
            }

            public String getDeliveryDes() {
                return deliveryDes;
            }

            public void setDeliveryDes(String deliveryDes) {
                this.deliveryDes = deliveryDes;
            }

            public long getDeliveryTime() {
                return deliveryTime;
            }

            public void setDeliveryTime(long deliveryTime) {
                this.deliveryTime = deliveryTime;
            }

            public int getDeliveryType() {
                return deliveryType;
            }

            public void setDeliveryType(int deliveryType) {
                this.deliveryType = deliveryType;
            }

            public boolean isInvoice() {
                return invoice;
            }

            public void setInvoice(boolean invoice) {
                this.invoice = invoice;
            }

            public String getInvoiceInfo() {
                return invoiceInfo;
            }

            public void setInvoiceInfo(String invoiceInfo) {
                this.invoiceInfo = invoiceInfo;
            }

            public String getPayDes() {
                return payDes;
            }

            public void setPayDes(String payDes) {
                this.payDes = payDes;
            }

            public int getPayType() {
                return payType;
            }

            public void setPayType(int payType) {
                this.payType = payType;
            }

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }

        public static class ShopBean {
            /**
             * averageConsume : 0
             * categoryId : 0
             * deliveryFee :
             * distance : 0
             * id : 1
             * image : http://192.168.56.3:8080/TakeoutService/imgs/goods/icon_md.png
             * invoice : false
             * latitude : 0
             * longitude : 0
             * monthSaleCount : 0
             * name : 麦当劳(广州东圃店)
             * onlineTime : 0
             * promotionId : 0
             * recentVisit :
             * score : 0
             * sendPrice : 0
             * tag : 0
             */

            private int averageConsume;
            private int categoryId;
            private String deliveryFee;
            private int distance;
            private int id;
            private String image;
            private boolean invoice;
            private int latitude;
            private int longitude;
            private int monthSaleCount;
            private String name;
            private int onlineTime;
            private int promotionId;
            private String recentVisit;
            private int score;
            private int sendPrice;
            private int tag;

            public int getAverageConsume() {
                return averageConsume;
            }

            public void setAverageConsume(int averageConsume) {
                this.averageConsume = averageConsume;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public String getDeliveryFee() {
                return deliveryFee;
            }

            public void setDeliveryFee(String deliveryFee) {
                this.deliveryFee = deliveryFee;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public boolean isInvoice() {
                return invoice;
            }

            public void setInvoice(boolean invoice) {
                this.invoice = invoice;
            }

            public int getLatitude() {
                return latitude;
            }

            public void setLatitude(int latitude) {
                this.latitude = latitude;
            }

            public int getLongitude() {
                return longitude;
            }

            public void setLongitude(int longitude) {
                this.longitude = longitude;
            }

            public int getMonthSaleCount() {
                return monthSaleCount;
            }

            public void setMonthSaleCount(int monthSaleCount) {
                this.monthSaleCount = monthSaleCount;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getOnlineTime() {
                return onlineTime;
            }

            public void setOnlineTime(int onlineTime) {
                this.onlineTime = onlineTime;
            }

            public int getPromotionId() {
                return promotionId;
            }

            public void setPromotionId(int promotionId) {
                this.promotionId = promotionId;
            }

            public String getRecentVisit() {
                return recentVisit;
            }

            public void setRecentVisit(String recentVisit) {
                this.recentVisit = recentVisit;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getSendPrice() {
                return sendPrice;
            }

            public void setSendPrice(int sendPrice) {
                this.sendPrice = sendPrice;
            }

            public int getTag() {
                return tag;
            }

            public void setTag(int tag) {
                this.tag = tag;
            }
        }

        public static class GoodsBean {
            /**
             * bargainPrice : false
             * detail :
             * feedbackRate : 0
             * id : 1
             * image :
             * monthSaleCount : 0
             * name : 红石榴风味派
             * newPrice : 12
             * oldPrice : 12
             * quantity : 2
             * tag : 0
             */

            private boolean bargainPrice;
            private String detail;
            private int feedbackRate;
            private int id;
            private String image;
            private int monthSaleCount;
            private String name;
            private int newPrice;
            private int oldPrice;
            private int quantity;
            private int tag;

            public boolean isBargainPrice() {
                return bargainPrice;
            }

            public void setBargainPrice(boolean bargainPrice) {
                this.bargainPrice = bargainPrice;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public int getFeedbackRate() {
                return feedbackRate;
            }

            public void setFeedbackRate(int feedbackRate) {
                this.feedbackRate = feedbackRate;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getMonthSaleCount() {
                return monthSaleCount;
            }

            public void setMonthSaleCount(int monthSaleCount) {
                this.monthSaleCount = monthSaleCount;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getNewPrice() {
                return newPrice;
            }

            public void setNewPrice(int newPrice) {
                this.newPrice = newPrice;
            }

            public int getOldPrice() {
                return oldPrice;
            }

            public void setOldPrice(int oldPrice) {
                this.oldPrice = oldPrice;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public int getTag() {
                return tag;
            }

            public void setTag(int tag) {
                this.tag = tag;
            }
        }
    }
}
