package com.itheima.takeout.model.bean.local;

/**
 * 0: 男性
 * 1: 女士
 * @author admin
 */
public enum Sex {

    // MALE.ordinal()    0
    // FEMALE.ordinal()  1

    MALE("先生") , FEMALE("女士");

    private String sex;

    public String getSex() {

        return sex;
    }

    private Sex(String sex) {
        this.sex = sex;
    }
}
