package com.itheima.takeout.model.bean;

import java.util.List;

/**
 * 附近的商家列表数据
 * @author WJQ
 */
public class ShopList {


    /**
     * error :
     * pageCount : 10
     * pageNo : 1
     * recommendList : [{"detail":"","id":1,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/recommend/recommend01.png",
     * "title":"附近美食精选","type":0,"url":""}]
     * shopList : [{"activityList":[{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_1.png","id":0,
     * "title":"满23减3元，满40减4元，满50减5元","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_2.png","id":1,
     * "title":"新用户立减18元（限钱包支付，其它支付立减12元）","type":0,"url":""}],"averageConsume":0,
     * "categoryId":1,"deliveryFee":0,"distance":420,"id":1,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/goods_1.jpg",
     * "invoice":false,"latitude":23.12343,"longitude":113.12343,"monthSaleCount":100,
     * "name":"1黑马外卖(广州吉山店)","onlineTime":0,"promotionId":0,"recentVisit":"",
     * "score":4.5,"sendPrice":15,"tag":0},{"activityList":[{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_1.png","id":0,
     * "title":"满23减3元，满40减4元，满50减5元","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_2.png","id":1,
     * "title":"新用户立减18元（限钱包支付，其它支付立减12元）","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_3.png","id":2,
     * "title":"下单实际支付金额满138元即得商家券","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_4.png","id":3,
     * "title":"第二份半价","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_5.png","id":4,
     * "title":"下单满199免配送费","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_1.png","id":5,
     * "title":"食堂实景","type":0,"url":""}],"averageConsume":0,"categoryId":1,
     * "deliveryFee":9,"distance":550,"id":2,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/goods_2.jpg",
     * "invoice":false,"latitude":23.12343,"longitude":113.12343,"monthSaleCount":21,
     * "name":"2黑马外卖(广州吉山店)","onlineTime":0,"promotionId":0,"recentVisit":"","score":5,
     * "sendPrice":0,"tag":1},{"activityList":[{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_1.png","id":0,
     * "title":"满23减3元，满40减4元，满50减5元","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_2.png","id":1,
     * "title":"新用户立减18元（限钱包支付，其它支付立减12元）","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_3.png","id":2,
     * "title":"下单实际支付金额满138元即得商家券","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_4.png","id":3,
     * "title":"第二份半价","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_5.png","id":4,
     * "title":"下单满199免配送费","type":0,"url":""}],"averageConsume":0,"categoryId":1,
     * "deliveryFee":0,"distance":800,"id":3,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/goods_3.jpg",
     * "invoice":false,"latitude":23.12343,"longitude":113.12343,"monthSaleCount":65,
     * "name":"3黑马外卖(广州吉山店)","onlineTime":0,"promotionId":0,"recentVisit":"","score":2,
     * "sendPrice":12,"tag":1},{"activityList":[{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_1.png","id":0,
     * "title":"满23减3元，满40减4元，满50减5元","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_2.png","id":1,
     * "title":"新用户立减18元（限钱包支付，其它支付立减12元）","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_3.png","id":2,
     * "title":"下单实际支付金额满138元即得商家券","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_4.png","id":3,
     * "title":"第二份半价","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_5.png","id":4,
     * "title":"下单满199免配送费","type":0,"url":""}],"averageConsume":0,"categoryId":1,
     * "deliveryFee":8,"distance":1700,"id":4,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/goods_4.jpg",
     * "invoice":false,"latitude":23.12343,"longitude":113.12343,"monthSaleCount":21,
     * "name":"4黑马外卖(广州吉山店)","onlineTime":0,"promotionId":0,"recentVisit":"","score":3,
     * "sendPrice":0,"tag":0},{"activityList":[{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_1.png","id":0,
     * "title":"满23减3元，满40减4元，满50减5元","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_2.png","id":1,
     * "title":"第二份半价","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_3.png","id":2,
     * "title":"下单满199免配送费","type":0,"url":""}],"averageConsume":0,"categoryId":1,
     * "deliveryFee":0,"distance":2300,"id":5,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/goods_5.jpg",
     * "invoice":false,"latitude":23.12343,"longitude":113.12343,"monthSaleCount":22,
     * "name":"5黑马外卖(广州吉山店)","onlineTime":0,"promotionId":0,"recentVisit":"",
     * "score":4.5,"sendPrice":0,"tag":0},{"activityList":[{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_1.png","id":0,
     * "title":"满23减3元，满40减4元，满50减5元","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_2.png","id":1,
     * "title":"新用户立减18元（限钱包支付，其它支付立减12元）","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_3.png","id":2,
     * "title":"下单实际支付金额满138元即得商家券","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_4.png","id":3,
     * "title":"第二份半价","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_5.png","id":4,
     * "title":"下单满199免配送费","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_1.png","id":5,
     * "title":"食堂实景","type":0,"url":""}],"averageConsume":0,"categoryId":1,
     * "deliveryFee":2,"distance":2300,"id":6,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/goods_6.jpg",
     * "invoice":false,"latitude":23.12343,"longitude":113.12343,"monthSaleCount":61,
     * "name":"6黑马外卖(广州吉山店)","onlineTime":0,"promotionId":0,"recentVisit":"",
     * "score":4.099999904632568,"sendPrice":10,"tag":0},{"activityList":[{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_1.png","id":0,
     * "title":"满23减3元，满40减4元，满50减5元","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_2.png","id":1,
     * "title":"下单实际支付金额满138元即得商家券","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_3.png","id":2,
     * "title":"第二份半价","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_4.png","id":3,
     * "title":"下单满199免配送费","type":0,"url":""}],"averageConsume":0,"categoryId":1,
     * "deliveryFee":0,"distance":2300,"id":7,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/goods_7.jpg",
     * "invoice":false,"latitude":23.12343,"longitude":113.12343,"monthSaleCount":61,
     * "name":"7黑马外卖(广州吉山店)","onlineTime":0,"promotionId":0,"recentVisit":"",
     * "score":4.199999809265137,"sendPrice":25,"tag":0},{"activityList":[],
     * "averageConsume":0,"categoryId":1,"deliveryFee":0,"distance":2300,"id":8,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/goods_8.jpg",
     * "invoice":false,"latitude":23.12343,"longitude":113.12343,"monthSaleCount":61,
     * "name":"8黑马外卖(广州吉山店)","onlineTime":0,"promotionId":0,"recentVisit":"",
     * "score":4.300000190734863,"sendPrice":15,"tag":0},{"activityList":[{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_1.png","id":0,
     * "title":"满23减3元，满40减4元，满50减5元","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_2.png","id":1,
     * "title":"新用户立减18元（限钱包支付，其它支付立减12元）","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_3.png","id":2,
     * "title":"下单实际支付金额满138元即得商家券","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_4.png","id":3,
     * "title":"第二份半价","type":0,"url":""}],"averageConsume":0,"categoryId":1,
     * "deliveryFee":0,"distance":2300,"id":9,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/goods_9.jpg",
     * "invoice":false,"latitude":23.12343,"longitude":113.12343,"monthSaleCount":62,
     * "name":"9黑马外卖(广州吉山店)","onlineTime":0,"promotionId":0,"recentVisit":"",
     * "score":4.400000095367432,"sendPrice":15,"tag":0},{"activityList":[{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_1.png","id":0,
     * "title":"满23减3元，满40减4元，满50减5元","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_2.png","id":1,
     * "title":"新用户立减18元（限钱包支付，其它支付立减12元）","type":0,"url":""},{"detail":"",
     * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_3.png","id":2,
     * "title":"下单实际支付金额满138元即得商家券","type":0,"url":""}],"averageConsume":0,
     * "categoryId":1,"deliveryFee":0,"distance":2300,"id":10,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/goods_10.jpg",
     * "invoice":false,"latitude":23.12343,"longitude":113.12343,"monthSaleCount":63,
     * "name":"10黑马外卖(广州吉山店)","onlineTime":0,"promotionId":0,"recentVisit":"",
     * "score":4.5,"sendPrice":15,"tag":0}]
     * status : 0
     * total : 65
     * totalPage : 7
     */

    private String error;
    private int pageCount;
    private int pageNo;
    private int status;
    private int total;
    private int totalPage;
    private List<RecommendListBean> recommendList;
    private List<ShopListBean> shopList;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<RecommendListBean> getRecommendList() {
        return recommendList;
    }

    public void setRecommendList(List<RecommendListBean> recommendList) {
        this.recommendList = recommendList;
    }

    public List<ShopListBean> getShopList() {
        return shopList;
    }

    public void setShopList(List<ShopListBean> shopList) {
        this.shopList = shopList;
    }

    public static class RecommendListBean {
        /**
         * detail :
         * id : 1
         * image : http://10.0.3.2:8080/TakeoutService/imgs/recommend/recommend01.png
         * title : 附近美食精选
         * type : 0
         * url :
         */

        private String detail;
        private int id;
        private String image;
        private String title;
        private int type;
        private String url;

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class ShopListBean {
        /**
         * activityList : [{"detail":"",
         * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_1.png",
         * "id":0,"title":"满23减3元，满40减4元，满50减5元","type":0,"url":""},{"detail":"",
         * "icon":"http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_2.png",
         * "id":1,"title":"新用户立减18元（限钱包支付，其它支付立减12元）","type":0,"url":""}]
         * averageConsume : 0
         * categoryId : 1
         * deliveryFee : 0
         * distance : 420
         * id : 1
         * image : http://10.0.3.2:8080/TakeoutService/imgs/goods/goods_1.jpg
         * invoice : false
         * latitude : 23.12343
         * longitude : 113.12343
         * monthSaleCount : 100
         * name : 1黑马外卖(广州吉山店)
         * onlineTime : 0
         * promotionId : 0
         * recentVisit :
         * score : 4.5
         * sendPrice : 15
         * tag : 0
         */

        private int averageConsume;
        private int categoryId;
        private int deliveryFee;
        private int distance;
        private int id;
        private String image;
        private boolean invoice;
        private double latitude;
        private double longitude;
        private int monthSaleCount;
        private String name;
        private int onlineTime;
        private int promotionId;
        private String recentVisit;
        private double score;
        private int sendPrice;
        private int tag;
        private List<ActivityListBean> activityList;

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

        public int getDeliveryFee() {
            return deliveryFee;
        }

        public void setDeliveryFee(int deliveryFee) {
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

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
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

        public List<ActivityListBean> getActivityList() {
            return activityList;
        }

        public void setActivityList(List<ActivityListBean> activityList) {
            this.activityList = activityList;
        }

        public static class ActivityListBean {
            /**
             * detail :
             * icon : http://10.0.3.2:8080/TakeoutService/imgs/goods/activity_1.png
             * id : 0
             * title : 满23减3元，满40减4元，满50减5元
             * type : 0
             * url :
             */

            private String detail;
            private String icon;
            private int id;
            private String title;
            private int type;
            private String url;

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
