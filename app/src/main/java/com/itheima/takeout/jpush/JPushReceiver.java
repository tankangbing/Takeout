package com.itheima.takeout.jpush;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.itheima.common.util.LogUtil;
import com.itheima.takeout.ui.activity.MainActivity;
import com.ta.utdid2.android.utils.StringUtils;

import org.json.JSONObject;

import java.util.logging.Logger;

import cn.jpush.android.api.JPushInterface;

public class JPushReceiver extends BroadcastReceiver {

    /** 取出消息，并处理 */
    private void processCustomMessage(Context context, Bundle bundle) {
        String title = bundle.getString(JPushInterface.EXTRA_TITLE);
        String message = bundle.getString(JPushInterface.EXTRA_MESSAGE);
        LogUtil.d("--------title: " + title);
        LogUtil.d("--------message: " + message);
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        // 接收到服务器发送过来的自定义消息
        if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            LogUtil.d("接受到推送下来的自定义消息");
            processCustomMessage(context, bundle);
            return;
        }

//        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
//            LogUtil.d("JPush用户注册成功");
//
//        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
//            LogUtil.d("接受到推送下来的通知");
//
//        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
//            LogUtil.d("用户点击打开了通知");
//
//        } else {
//            LogUtil.d("Unhandled intent - " + intent.getAction());
//        }
    }
}