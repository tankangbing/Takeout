package com.itheima.takeout.model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WJQ
 */

public class ShopCategory {

    /**
     * categoryList : [{"id":1,"name":"黑马外卖","parentCategory":-1,"shopCount":27,
     * "tag":0},{"id":2,"name":"地方菜","parentCategory":-1,"shopCount":18,"tag":0},
     * {"id":3,"name":"小吃快餐","parentCategory":-1,"shopCount":14,"tag":0},{"id":4,
     * "name":"西式快餐","parentCategory":-1,"shopCount":6,"tag":0},{"id":5,"name":"异国风味",
     * "parentCategory":-1,"shopCount":0,"tag":0},{"id":6,"name":"中式正餐",
     * "parentCategory":-1,"shopCount":0,"tag":0},{"id":7,"name":"烧烤海鲜",
     * "parentCategory":-1,"shopCount":0,"tag":0},{"id":8,"name":"甜点饼品",
     * "parentCategory":-1,"shopCount":0,"tag":0},{"id":9,"name":"水果生鲜",
     * "parentCategory":-1,"shopCount":0,"tag":0},{"id":10,"name":"下午茶",
     * "parentCategory":-1,"shopCount":0,"tag":0},{"id":11,"name":"鲜花蛋糕",
     * "parentCategory":-1,"shopCount":0,"tag":0},{"id":12,"name":"超市购",
     * "parentCategory":-1,"shopCount":0,"tag":0},{"id":13,"name":"夜宵",
     * "parentCategory":-1,"shopCount":0,"tag":0},{"id":14,"name":"送药上门",
     * "parentCategory":-1,"shopCount":0,"tag":0},{"id":15,"name":"清真",
     * "parentCategory":-1,"shopCount":0,"tag":0},{"id":16,"name":"粤菜",
     * "parentCategory":2,"shopCount":13,"tag":0},{"id":17,"name":"川菜",
     * "parentCategory":2,"shopCount":5,"tag":0},{"id":18,"name":"湘菜",
     * "parentCategory":2,"shopCount":0,"tag":0},{"id":19,"name":"东北菜",
     * "parentCategory":2,"shopCount":0,"tag":0},{"id":20,"name":"北京菜",
     * "parentCategory":2,"shopCount":0,"tag":0},{"id":21,"name":"浙江菜",
     * "parentCategory":2,"shopCount":0,"tag":0},{"id":22,"name":"地方小吃",
     * "parentCategory":2,"shopCount":0,"tag":0},{"id":23,"name":"其他地方菜",
     * "parentCategory":2,"shopCount":0,"tag":0},{"id":24,"name":"家常小炒",
     * "parentCategory":3,"shopCount":8,"tag":0},{"id":25,"name":"鱼丸粗面",
     * "parentCategory":3,"shopCount":4,"tag":0},{"id":26,"name":"纸包鸡",
     * "parentCategory":3,"shopCount":2,"tag":0},{"id":27,"name":"麻辣烫",
     * "parentCategory":3,"shopCount":0,"tag":0},{"id":28,"name":"盖饭",
     * "parentCategory":3,"shopCount":0,"tag":0},{"id":29,"name":"面馆",
     * "parentCategory":3,"shopCount":0,"tag":0},{"id":30,"name":"米粉米线",
     * "parentCategory":3,"shopCount":0,"tag":0},{"id":31,"name":"冒菜",
     * "parentCategory":3,"shopCount":0,"tag":0},{"id":32,"name":"饺子馄饨",
     * "parentCategory":3,"shopCount":0,"tag":0},{"id":33,"name":"包子粥饼",
     * "parentCategory":3,"shopCount":0,"tag":0},{"id":34,"name":"生煎锅贴",
     * "parentCategory":3,"shopCount":0,"tag":0},{"id":35,"name":"凉皮",
     * "parentCategory":3,"shopCount":0,"tag":0},{"id":36,"name":"羊汤羊杂",
     * "parentCategory":3,"shopCount":0,"tag":0},{"id":37,"name":"鸭脖卤味",
     * "parentCategory":3,"shopCount":0,"tag":0},{"id":38,"name":"炸鸡炸串",
     * "parentCategory":3,"shopCount":0,"tag":0},{"id":39,"name":"茶餐厅",
     * "parentCategory":3,"shopCount":0,"tag":0},{"id":40,"name":"其它快餐",
     * "parentCategory":3,"shopCount":0,"tag":0}]
     * error :
     * status : 0
     */

    private String error;
    private int status;
    private List<CategoryListBean> categoryList;

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

    public List<CategoryListBean> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryListBean> categoryList) {
        this.categoryList = categoryList;
    }

    public static class CategoryListBean {
        /**
         * id : 1
         * name : 黑马外卖
         * parentCategory : -1
         * shopCount : 27
         * tag : 0
         */

        private int id;
        private String name;
        private int parentCategory;
        private int shopCount;
        private int tag;

        // 保存的是该父类别下，所有的子类别
        public ArrayList<CategoryListBean> childCategory
                = new ArrayList<ShopCategory.CategoryListBean>();

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

        public int getParentCategory() {
            return parentCategory;
        }

        public void setParentCategory(int parentCategory) {
            this.parentCategory = parentCategory;
        }

        public int getShopCount() {
            return shopCount;
        }

        public void setShopCount(int shopCount) {
            this.shopCount = shopCount;
        }

        public int getTag() {
            return tag;
        }

        public void setTag(int tag) {
            this.tag = tag;
        }
    }
}
