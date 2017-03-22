package com.itheima.common.base;

import android.app.Application;

import com.itheima.common.base.Global;

/**
 * 应用程序上下文对象，常作一些初始化操作
 *
 * @author WJQ
 */
public class MyApp extends Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		Global.init(this);
	}
}
