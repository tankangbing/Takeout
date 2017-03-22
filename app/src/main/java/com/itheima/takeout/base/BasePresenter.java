package com.itheima.takeout.base;

import android.os.Message;

import com.itheima.takeout.model.protocol.BaseProtocol;
import com.itheima.takeout.model.protocol.CommonProtocol;

/**
 * @author WJQ
 */

public class BasePresenter {

    public BaseProtocol.OnHttpCallback mCallback
            = new BaseProtocol.OnHttpCallback() {
        @Override
        public void onHttpSuccess(int reqType, Message obj) {
            // P层 调用 V层
            baseView.onHttpSuccess(reqType, obj);
        }

        @Override
        public void onHttpError(int reqType, String error) {
            baseView.onHttpError(reqType, error);
        }
    };

    // Model层
    public CommonProtocol mProtocol;
    // View层
    public BaseView baseView;

    public BasePresenter(BaseView baseView) {
        this.baseView = baseView;
        mProtocol = new CommonProtocol();
    }

}
