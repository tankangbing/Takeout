package com.itheima.takeout.model.bean;

import java.util.List;

/**
 * @author WJQ
 */

public class OrderBy {

    /**
     * error :
     * orderByList : [{"id":1,"name":"综合排序","tag":0},{"id":2,"name":"销量最高","tag":1},
     * {"id":3,"name":"距离最近","tag":2},{"id":4,"name":"评分最高","tag":3},{"id":5,
     * "name":"起送价最低","tag":4},{"id":6,"name":"人均最高","tag":5},{"id":7,"name":"人均最低",
     * "tag":6}]
     * status : 0
     */

    private String error;
    private int status;
    private List<OrderByListBean> orderByList;

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

    public List<OrderByListBean> getOrderByList() {
        return orderByList;
    }

    public void setOrderByList(List<OrderByListBean> orderByList) {
        this.orderByList = orderByList;
    }

    public static class OrderByListBean {
        /**
         * id : 1
         * name : 综合排序
         * tag : 0
         */

        private int id;
        private String name;
        private int tag;

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

        public int getTag() {
            return tag;
        }

        public void setTag(int tag) {
            this.tag = tag;
        }
    }
}
