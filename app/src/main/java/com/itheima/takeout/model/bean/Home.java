package com.itheima.takeout.model.bean;

import java.util.List;

/**
 * @author WJQ
 */

public class Home {

    /**
     * error :
     * hotSaleList : [{"detail":"","id":0,"title":"好评率超高听标榜单餐厅","url":""},{"detail":"",
     * "id":1,"title":"新店拨草，新的舌头需要一些新口味","url":""},{"detail":"","id":2,
     * "title":"深扒外卖超高人气美食榜单","url":""}]
     * promotionList : [{"detail":"","id":1,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/home/home_img_01.png",
     * "title":"把温暖的饭菜送到您手里","url":""},{"detail":"","id":2,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/home/home_img_02.png",
     * "title":"萌宠过大年","url":""},{"detail":"","id":3,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/home/home_img_03.png",
     * "title":"香浓巧克力","url":""},{"detail":"","id":4,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/home/home_img_04.png",
     * "title":"2017年货节","url":""},{"detail":"","id":5,
     * "image":"http://10.0.3.2:8080/TakeoutService/imgs/home/home_img_05.png",
     * "title":"星巴克2017新年新品","url":""}]
     * promotionTypes : [{"icon":"http://10.0.3.2:8080/TakeoutService/imgs/category
     * /1.png","id":1,"name":"美食73"},
     * {"icon":"http://10.0.3.2:8080/TakeoutService/imgs/category/2.png","id":2,
     * "name":"甜品饮料"},{"icon":"http://10.0.3.2:8080/TakeoutService/imgs/category/3.png
     * ","id":3,"name":"商店超市"},{"icon":"http://10.0.3.2:8080/TakeoutService/imgs
     * /category/4.png","id":4,"name":"早餐"},
     * {"icon":"http://10.0.3.2:8080/TakeoutService/imgs/category/5.png","id":5,
     * "name":"果蔬"},{"icon":"http://10.0.3.2:8080/TakeoutService/imgs/category/6.png",
     * "id":6,"name":"新店"},{"icon":"http://10.0.3.2:8080/TakeoutService/imgs/category
     * /7.png","id":7,"name":"下午茶"},
     * {"icon":"http://10.0.3.2:8080/TakeoutService/imgs/category/8.png","id":8,
     * "name":"广州小吃"},{"icon":"http://10.0.3.2:8080/TakeoutService/imgs/category/10.png
     * ","id":9,"name":"麻辣烫"},{"icon":"http://10.0.3.2:8080/TakeoutService/imgs
     * /category/11.png","id":10,"name":"小吃2"},
     * {"icon":"http://10.0.3.2:8080/TakeoutService/imgs/category/12.png","id":11,
     * "name":"小吃3"},{"icon":"http://10.0.3.2:8080/TakeoutService/imgs/category/13.png
     * ","id":12,"name":"小吃4"},{"icon":"http://10.0.3.2:8080/TakeoutService/imgs
     * /category/14.png","id":13,"name":"广州美食1"},
     * {"icon":"http://10.0.3.2:8080/TakeoutService/imgs/category/15.png","id":14,
     * "name":"广州美食2"},{"icon":"http://10.0.3.2:8080/TakeoutService/imgs/category/1.png
     * ","id":15,"name":"吃货"},{"icon":"http://10.0.3.2:8080/TakeoutService/imgs
     * /category/2.png","id":16,"name":"广州吃货"}]
     * status : 0
     */

    private String error;
    private int status;
    private List<HotSaleListBean> hotSaleList;
    private List<PromotionListBean> promotionList;
    private List<PromotionTypesBean> promotionTypes;

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

    public List<HotSaleListBean> getHotSaleList() {
        return hotSaleList;
    }

    public void setHotSaleList(List<HotSaleListBean> hotSaleList) {
        this.hotSaleList = hotSaleList;
    }

    public List<PromotionListBean> getPromotionList() {
        return promotionList;
    }

    public void setPromotionList(List<PromotionListBean> promotionList) {
        this.promotionList = promotionList;
    }

    public List<PromotionTypesBean> getPromotionTypes() {
        return promotionTypes;
    }

    public void setPromotionTypes(List<PromotionTypesBean> promotionTypes) {
        this.promotionTypes = promotionTypes;
    }

    public static class HotSaleListBean {
        /**
         * detail :
         * id : 0
         * title : 好评率超高听标榜单餐厅
         * url :
         */
        private String detail;
        private int id;
        private String title;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class PromotionListBean {
        /**
         * detail :
         * id : 1
         * image : http://10.0.3.2:8080/TakeoutService/imgs/home/home_img_01.png
         * title : 把温暖的饭菜送到您手里
         * url :
         */

        private String detail;
        private int id;
        private String image;
        private String title;
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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class PromotionTypesBean {
        /**
         * icon : http://10.0.3.2:8080/TakeoutService/imgs/category/1.png
         * id : 1
         * name : 美食73
         */

        private String icon;
        private int id;
        private String name;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
