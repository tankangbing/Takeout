package com.itheima.takeout.ui.holder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.common.base.Const;
import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.common.util.SharedPreUtil;
import com.itheima.takeout.R;
import com.itheima.takeout.db.greendao.Address;
import com.itheima.takeout.model.bean.local.Sex;
import com.itheima.takeout.ui.activity.AddressListActivity;
import com.itheima.takeout.ui.adapter.AddressAdapter;
import com.itheima.takeout.ui.adapter.HomeCategoryAdapter;

/**
 * @author admin
 */
public class AddressHolder extends BaseHolderRV<Address> {

    private TextView tvAddress;
    private TextView tvUserInfo;
    private ImageView ivEdit;
    private ImageView ivCurrentAddress;

    public AddressHolder(Context context, ViewGroup parent,
                         BaseAdapterRV<Address> adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_recipients_address);
    }

    @Override
    public void onFindViews(View itemView) {
        tvAddress = (TextView) itemView.findViewById(R.id.tv_address);
        tvUserInfo = (TextView) itemView.findViewById(R.id.tv_user_info);
        ivEdit = (ImageView) itemView.findViewById(R.id.iv_edit);
        ivCurrentAddress = (ImageView) itemView.findViewById(R.id.iv_current_address);
    }

    @Override
    protected void onRefreshView(Address bean, int position) {
        // 地址名称
        tvAddress.setText(bean.getAddressName());
        // 收件人名称和电话
        String userInfo = bean.getName()
                + " " + Sex.of(bean.getSex()).getSex()
                + "   " + bean.getPhone();
        tvUserInfo.setText(userInfo);

        // 显示是否是默认地址
        long addressId = ((AddressAdapter) adapter).mSelectedAddressId;
        if (addressId == bean.getId()) {
            ivCurrentAddress.setVisibility(View.VISIBLE);
        } else {
            ivCurrentAddress.setVisibility(View.GONE);
        }
    }

    // 点击列表项, 选择地址，并返回到上一个界面（确认订单界面）
    @Override
    protected void onItemClick(View itemView, int position, Address bean) {
        Intent intent = new Intent();
        // 把地址javabean返回到上一个界面
        intent.putExtra(Const.KEY_BEAN, bean);
        ((AddressListActivity) context).setResult(Activity.RESULT_OK, intent);
        ((AddressListActivity) context).finish();

        // 记录用户选择的是哪个地址(保存地址的id)
        SharedPreUtil.saveLong(context, Const.SP_DEFAULT_ADDRESS, bean.getId());
    }
}
