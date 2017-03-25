package com.itheima.takeout.model.bean;

import java.util.List;

/**
 * @author admin
 */

public class ShopDetail {


    /**
     * category : [{"detail":"","goods":[{"bargainPrice":false,"categoryId":1,
     * "detail":"香辣多法，口感鲜美","feedbackRate":88,"id":10001,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_1.png",
     * "monthSaleCount":20,"name":"两块香辣鸡翅","newPrice":12,"oldPrice":12,"shopId":1,
     * "tag":0},{"bargainPrice":true,"categoryId":1,
     * "detail":"选用无骨鸡腿柳条、搭配传统甜面酱和新鲜爽脆黄瓜，酱香浓郁的老北京味","feedbackRate":90,"id":10002,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_2.png",
     * "monthSaleCount":87,"name":"老北京鸡肉卷","newPrice":13,"oldPrice":15,"shopId":1,
     * "tag":0},{"bargainPrice":false,"categoryId":1,
     * "detail":"新奥尔良烤翅4块+香辣鸡翅2块+黄金鸡块5块+鸡米花(小)1份+红豆派2个","feedbackRate":86,"id":10003,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_3.png",
     * "monthSaleCount":28,"name":"五味小吃桶","newPrice":55,"oldPrice":55,"shopId":1,
     * "tag":0},{"bargainPrice":true,"categoryId":1,
     * "detail":"吮指原味鸡5块+香辣鸡翅6块+土豆泥1份+玉米棒1个+1.25L可乐1瓶","feedbackRate":92,"id":10005,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_5.png",
     * "monthSaleCount":14,"name":"外带全家桶","newPrice":80,"oldPrice":89,"shopId":1,
     * "tag":0},{"bargainPrice":true,"categoryId":1,
     * "detail":"2个香辣鸡腿堡+1个新奥尔良烤鸡腿堡+3块吮指原味鸡+2块香辣鸡翅+4块新奥尔良烤翅+2份醇香土豆泥+2个红豆派+1瓶1.25升百事可乐",
     * "feedbackRate":88,"id":10006,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_6.png",
     * "monthSaleCount":11,"name":"超级外带全家桶","newPrice":105,"oldPrice":118,"shopId":1,
     * "tag":0}],"id":1,"image":"","name":"热销","tag":0},{"detail":"",
     * "goods":[{"bargainPrice":false,"categoryId":2,
     * "detail":"精选阿拉比卡咖啡豆，新鲜现磨。规格：同堂食大杯","feedbackRate":82,"id":10007,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_7.png",
     * "monthSaleCount":4,"name":"美式（大）","newPrice":17,"oldPrice":17,"shopId":1,
     * "tag":0},{"bargainPrice":false,"categoryId":2,
     * "detail":"精选阿拉比卡咖啡豆，新鲜现磨。规格：同堂食大杯","feedbackRate":87,"id":10008,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_8.png",
     * "monthSaleCount":7,"name":"拿铁（大）","newPrice":19,"oldPrice":19,"shopId":1,
     * "tag":0},{"bargainPrice":false,"categoryId":2,
     * "detail":"精选阿拉比卡咖啡豆，新鲜现磨。规格：同堂食大杯","feedbackRate":89,"id":10009,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_9.png",
     * "monthSaleCount":4,"name":"冰美式咖啡（大）","newPrice":17,"oldPrice":17,"shopId":1,
     * "tag":0},{"bargainPrice":false,"categoryId":2,
     * "detail":"精选阿拉比卡咖啡豆，新鲜现磨。规格：同堂食大杯","feedbackRate":90,"id":10010,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_10.png",
     * "monthSaleCount":5,"name":"冰拿铁（大)","newPrice":19,"oldPrice":19,"shopId":1,
     * "tag":0}],"id":2,"image":"","name":"现磨咖啡","tag":0},{"detail":"",
     * "goods":[{"bargainPrice":false,"categoryId":3,
     * "detail":"2个香辣鸡腿堡+1个新奥尔良烤鸡腿堡+3块吮指原味鸡+2块香辣鸡翅+4块新奥尔良烤翅+2份醇香土豆泥+2个红豆派+1瓶1.25升百事可乐",
     * "feedbackRate":90,"id":10011,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_11.png",
     * "monthSaleCount":11,"name":"超级外带全家桶","newPrice":118,"oldPrice":118,"shopId":1,
     * "tag":0},{"bargainPrice":false,"categoryId":3,
     * "detail":"吮指原味鸡5块+香辣鸡翅6块+土豆泥1份+玉米棒1个+1.25L可乐1瓶","feedbackRate":80,"id":10012,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_12.png",
     * "monthSaleCount":11,"name":"外带全家桶","newPrice":89,"oldPrice":89,"shopId":1,
     * "tag":0},{"bargainPrice":false,"categoryId":3,
     * "detail":"香辣鸡腿堡1个+日式咖喱鸡饭大桶1份+香辣鸡翅2块+新奥尔良烤翅2块+波纹霸王薯条1份+芙蓉荟蔬汤1份+九珍果汁饮料1
     * 杯（日式咖喱鸡饭含猪肉成份）","feedbackRate":80,"id":10013,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_13.png",
     * "monthSaleCount":11,"name":"饭堡双人餐","newPrice":74,"oldPrice":74,"shopId":1,
     * "tag":0}],"id":3,"image":"","name":"超值多人套餐","tag":0},{"detail":"",
     * "goods":[{"bargainPrice":false,"categoryId":4,"detail":"口感嫩滑，浓郁香甜",
     * "feedbackRate":90,"id":10014,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_14.png",
     * "monthSaleCount":31,"name":"葡式蛋挞(经典)1只装","newPrice":7.5,"oldPrice":7.5,
     * "shopId":1,"tag":0},{"bargainPrice":false,"categoryId":4,"detail":"口感嫩滑，浓郁香甜",
     * "feedbackRate":90,"id":10015,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_15.png",
     * "monthSaleCount":12,"name":"葡式蛋挞经典6只装（省14）","newPrice":35,"oldPrice":35,
     * "shopId":1,"tag":0},{"bargainPrice":false,"categoryId":4,
     * "detail":"选用蔬菜配以蛋花精制而成","feedbackRate":90,"id":10016,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_16.png",
     * "monthSaleCount":31,"name":"芙蓉荟蔬汤","newPrice":8,"oldPrice":8,"shopId":1,
     * "tag":0},{"bargainPrice":false,"categoryId":4,"detail":"九种水果风味混合而成，酸甜可口",
     * "feedbackRate":95,"id":10017,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_17.png",
     * "monthSaleCount":17,"name":"九珍果汁饮料","newPrice":11,"oldPrice":11,"shopId":1,
     * "tag":0}],"id":4,"image":"","name":"早餐菜单","tag":0},{"detail":"",
     * "goods":[{"bargainPrice":false,"categoryId":5,
     * "detail":"香辣鸡腿堡1个+波纹霸王薯条1份+九珍果汁饮料1杯","feedbackRate":90,"id":10018,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_18.png",
     * "monthSaleCount":7,"name":"香辣鸡腿堡薯条套餐","newPrice":34,"oldPrice":34,"shopId":1,
     * "tag":0},{"bargainPrice":false,"categoryId":5,
     * "detail":"劲脆鸡腿堡1个+波纹霸王薯条1份+九珍果汁饮料1杯","feedbackRate":90,"id":10019,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_19.png",
     * "monthSaleCount":6,"name":"劲脆鸡腿堡薯条套餐1","newPrice":34,"oldPrice":34,"shopId":1,
     * "tag":0},{"bargainPrice":false,"categoryId":5,
     * "detail":"新奥尔良烤鸡腿堡1个+波纹霸王薯条1份+九珍果汁饮料1杯","feedbackRate":90,"id":10020,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_20.png",
     * "monthSaleCount":7,"name":"奥尔良烤堡薯条套餐","newPrice":35,"oldPrice":35,"shopId":1,
     * "tag":0},{"bargainPrice":false,"categoryId":5,
     * "detail":"伴鸡伴虾堡1个+波纹霸王薯条1份+九珍果汁饮料1杯","feedbackRate":92,"id":10021,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_21.png",
     * "monthSaleCount":10,"name":"伴鸡伴虾堡薯条套餐","newPrice":36,"oldPrice":36,"shopId":1,
     * "tag":0}],"id":5,"image":"","name":"超值套餐","tag":0},{"detail":"",
     * "goods":[{"bargainPrice":false,"categoryId":6,"detail":"整块无骨鸡腿肉, 浓郁汉堡酱，香脆鲜辣多汁。",
     * "feedbackRate":90,"id":10022,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_22.png",
     * "monthSaleCount":39,"name":"香辣鸡腿堡","newPrice":17,"oldPrice":17,"shopId":1,
     * "tag":0},{"bargainPrice":false,"categoryId":6,"detail":"整块无骨鸡腿肉,浓郁汉堡酱，香脆鲜嫩多汁",
     * "feedbackRate":90,"id":10023,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_23.png",
     * "monthSaleCount":12,"name":"劲脆鸡腿堡","newPrice":17,"oldPrice":17,"shopId":1,
     * "tag":0},{"bargainPrice":false,"categoryId":6,"detail":"选用超大无骨鸡腿肉烤制，鲜嫩多汁，甜中带辣。",
     * "feedbackRate":90,"id":10024,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_24.png",
     * "monthSaleCount":18,"name":"新奥尔良烤鸡腿堡","newPrice":18,"oldPrice":18,"shopId":1,
     * "tag":0},{"bargainPrice":false,"categoryId":6,"detail":"鲜嫩Q弹的全虾排,外脆里嫩的鸡腿肉,
     * 双重鲜美","feedbackRate":90,"id":10025,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_25.png",
     * "monthSaleCount":22,"name":"伴鸡伴虾堡","newPrice":19,"oldPrice":19,"shopId":1,
     * "tag":0}],"id":6,"image":"","name":"美味汉堡","tag":0},{"detail":"",
     * "goods":[{"bargainPrice":false,"categoryId":7,
     * "detail":"优选北美进口马铃薯条，独特的波纹造型，更加粗壮。外表金黄，外脆里糯。口口美味，薯香四溢。","feedbackRate":90,
     * "id":10026,"image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_26.png",
     * "monthSaleCount":45,"name":"波纹霸王薯条","newPrice":11,"oldPrice":11,"shopId":1,
     * "tag":0},{"bargainPrice":false,"categoryId":7,
     * "detail":"将鸡腿肉和鸡软骨精心腌制后串成一串，包上锡纸烤到喷香四溢。鸡肉更加鲜嫩多汁，软骨更加脆嫩耐嚼。","feedbackRate":90,
     * "id":10027,"image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_27.png",
     * "monthSaleCount":45,"name":"骨肉相连加(2串)","newPrice":13.5,"oldPrice":13.5,
     * "shopId":1,"tag":0},{"bargainPrice":false,"categoryId":7,"detail":"香辣多汁，口感鲜美",
     * "feedbackRate":90,"id":10028,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_28.png",
     * "monthSaleCount":45,"name":"十块香辣鸡翅","newPrice":43,"oldPrice":43,"shopId":1,
     * "tag":0},{"bargainPrice":false,"categoryId":7,
     * "detail":"将鸡腿肉加工成小巧造型，用经典的香辣腌料，然后手工裹上优质面粉，烹炸至金黄喷香。酥脆，鲜嫩，香辣。","feedbackRate":90,
     * "id":10029,"image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_29.png",
     * "monthSaleCount":45,"name":"劲爆鸡米花（小）","newPrice":11,"oldPrice":11,"shopId":1,
     * "tag":0},{"bargainPrice":false,"categoryId":7,"detail":"精选鸡肉烹炸，搭配调味酱，口感香鲜酥脆。",
     * "feedbackRate":90,"id":10030,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_30.png",
     * "monthSaleCount":29,"name":"黄金鸡块十块装","newPrice":18,"oldPrice":18,"shopId":1,
     * "tag":0}],"id":7,"image":"","name":"缤纷小食","tag":0},{"detail":"",
     * "goods":[{"bargainPrice":false,"categoryId":8,"detail":"1瓶1.25L百事可乐",
     * "feedbackRate":90,"id":10031,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_31.png",
     * "monthSaleCount":29,"name":"1.25升装可乐","newPrice":12,"oldPrice":12,"shopId":1,
     * "tag":0},{"bargainPrice":false,"categoryId":8,"detail":"经典红茶加入三片新鲜柠檬，
     * 醇厚、清新交织在一起，让人回味无穷。","feedbackRate":90,"id":10032,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_32.png",
     * "monthSaleCount":29,"name":"热柠檬红茶","newPrice":10.5,"oldPrice":10.5,"shopId":1,
     * "tag":0},{"bargainPrice":false,"categoryId":8,"detail":"口感顺滑、香醇浓厚",
     * "feedbackRate":90,"id":10033,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_33.png",
     * "monthSaleCount":19,"name":"香醇奶茶(热)","newPrice":9.5,"oldPrice":9.5,"shopId":1,
     * "tag":0}],"id":8,"image":"","name":"缤纷饮料","tag":0}]
     * error :
     * id : 1
     * name :
     * status : 0
     * tag : 0
     */

    private String error;
    private int id;
    private String name;
    private int status;
    private int tag;
    private List<CategoryBean> category;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public List<CategoryBean> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryBean> category) {
        this.category = category;
    }

    public static class CategoryBean {
        /**
         * detail :
         * goods : [{"bargainPrice":false,"categoryId":1,"detail":"香辣多法，口感鲜美",
         * "feedbackRate":88,"id":10001,
         * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_1.png",
         * "monthSaleCount":20,"name":"两块香辣鸡翅","newPrice":12,"oldPrice":12,"shopId":1,
         * "tag":0},{"bargainPrice":true,"categoryId":1,
         * "detail":"选用无骨鸡腿柳条、搭配传统甜面酱和新鲜爽脆黄瓜，酱香浓郁的老北京味","feedbackRate":90,"id":10002,
         * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_2.png",
         * "monthSaleCount":87,"name":"老北京鸡肉卷","newPrice":13,"oldPrice":15,"shopId":1,
         * "tag":0},{"bargainPrice":false,"categoryId":1,
         * "detail":"新奥尔良烤翅4块+香辣鸡翅2块+黄金鸡块5块+鸡米花(小)1份+红豆派2个","feedbackRate":86,
         * "id":10003,"image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_3.png
         * ","monthSaleCount":28,"name":"五味小吃桶","newPrice":55,"oldPrice":55,"shopId":1,
         * "tag":0},{"bargainPrice":true,"categoryId":1,
         * "detail":"吮指原味鸡5块+香辣鸡翅6块+土豆泥1份+玉米棒1个+1.25L可乐1瓶","feedbackRate":92,
         * "id":10005,"image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_5.png
         * ","monthSaleCount":14,"name":"外带全家桶","newPrice":80,"oldPrice":89,"shopId":1,
         * "tag":0},{"bargainPrice":true,"categoryId":1,
         * "detail":"2个香辣鸡腿堡+1个新奥尔良烤鸡腿堡+3块吮指原味鸡+2块香辣鸡翅+4块新奥尔良烤翅+2份醇香土豆泥+2个红豆派+1瓶1.25
         * 升百事可乐","feedbackRate":88,"id":10006,
         * "image":"http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_6.png",
         * "monthSaleCount":11,"name":"超级外带全家桶","newPrice":105,"oldPrice":118,
         * "shopId":1,"tag":0}]
         * id : 1
         * image :
         * name : 热销
         * tag : 0
         */

        private String detail;
        private int id;
        private String image;
        private String name;
        private int tag;
        private List<GoodsBean> goods;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTag() {
            return tag;
        }

        public void setTag(int tag) {
            this.tag = tag;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        /** 一件商品 */
        public static class GoodsBean {
            /**
             * bargainPrice : false
             * categoryId : 1
             * detail : 香辣多法，口感鲜美
             * feedbackRate : 88
             * id : 10001
             * image : http://10.0.3.2:8080/TakeoutService/imgs/goods/kfc_1.png
             * monthSaleCount : 20
             * name : 两块香辣鸡翅
             * newPrice : 12
             * oldPrice : 12
             * shopId : 1
             * tag : 0
             */

            /** 添加到购物车的数量 */
            public int mBuyCount;

            private boolean bargainPrice;
            private int categoryId;
            private String detail;
            private int feedbackRate;
            private int id;
            private String image;
            private int monthSaleCount;
            private String name;
            private float newPrice;
            private float oldPrice;
            private int shopId;
            private int tag;

            public String getCategoryName() {
                return categoryName;
            }

            /** 该商品所属的类别名称*/
            private String categoryName;

            public boolean isBargainPrice() {
                return bargainPrice;
            }

            public void setBargainPrice(boolean bargainPrice) {
                this.bargainPrice = bargainPrice;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
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

            public float getNewPrice() {
                return newPrice;
            }

            public void setNewPrice(float newPrice) {
                this.newPrice = newPrice;
            }

            public float getOldPrice() {
                return oldPrice;
            }

            public void setOldPrice(float oldPrice) {
                this.oldPrice = oldPrice;
            }

            public int getShopId() {
                return shopId;
            }

            public void setShopId(int shopId) {
                this.shopId = shopId;
            }

            public int getTag() {
                return tag;
            }

            public void setTag(int tag) {
                this.tag = tag;
            }

            /** 指定该商品所属的类别名称*/
            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }
        }
    }
}
