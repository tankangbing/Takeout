package com.itheima.takeout.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.itheima.common.base.Const;
import com.itheima.common.ui.BaseAdapterLV;
import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.common.util.SharedPreUtil;
import com.itheima.takeout.db.greendao.Address;
import com.itheima.takeout.ui.holder.AddressHolder;

import java.util.List;

/**
 * @author admin
 */

public class AddressAdapter extends BaseAdapterRV<Address> {

    /** 当前用户选择的地址的id */
    public long mSelectedAddressId;

    public AddressAdapter(Context context, List<Address> listData) {
        super(context, listData);
        mSelectedAddressId = SharedPreUtil.getLong(context, Const.SP_DEFAULT_ADDRESS, 0L);
    }

    @Override
    public BaseHolderRV createViewHolder(
            Context context, ViewGroup parent, int viewType) {
        return new AddressHolder(context, parent, this, viewType);
    }
}
