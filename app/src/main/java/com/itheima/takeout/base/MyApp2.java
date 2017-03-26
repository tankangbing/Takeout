package com.itheima.takeout.base;

import com.itheima.common.base.MyApp;

import cn.smssdk.SMSSDK;

/**
 * @author WJQ
 */
public class MyApp2 extends MyApp {

    @Override
    public void onCreate() {
        super.onCreate();

        // 短信验证登录
        SMSSDK.initSDK(this, "1c32a690937b0",
                "490f625347ea37b1ff872bc25e05aef7");
    }
}
