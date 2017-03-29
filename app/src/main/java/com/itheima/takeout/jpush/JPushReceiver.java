package com.itheima.takeout.jpush;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;

import com.google.gson.Gson;
import com.itheima.common.base.Const;
import com.itheima.common.base.OttoBus;
import com.itheima.common.util.LogUtil;
import com.itheima.takeout.model.bean.local.Location;
import com.itheima.takeout.model.bean.local.OrderUpdate;
import com.itheima.takeout.ui.activity.MainActivity;
import com.ta.utdid2.android.utils.StringUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Logger;

import cn.jpush.android.api.JPushInterface;

public class JPushReceiver extends BroadcastReceiver {

    /** 取出消息，并处理 */
    private void processCustomMessage(Context context, Bundle bundle) {
        String title = bundle.getString(JPushInterface.EXTRA_TITLE);
        String json = bundle.getString(JPushInterface.EXTRA_MESSAGE);
        LogUtil.d("--------title: " + title);
        LogUtil.d("--------message: " + json);

        try {
            JSONObject object = new JSONObject(json);
            int msgType = object.getInt("msgType");
            if (msgType == 1) {         // 1：表示更新订单状态

                // 发送Otto消息
                Message msg = new Message();
                msg.what = Const.TYPE_UPDATE_ORDER_STATUS;
                msg.obj = new Gson().fromJson(json, OrderUpdate.class);
                OttoBus.getDefault().post(msg);

            } else if (msgType == 2) {  // 2：更新骑手位置

                Message msg = new Message();
                msg.what = Const.TYPE_UPDATE_RIDER_POSITION;
                msg.obj = new Gson().fromJson(json, Location.class);
                OttoBus.getDefault().post(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.d("-----error: " + e.getMessage());
        }
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