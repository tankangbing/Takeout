package com.itheima.takeout.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.itheima.common.base.BaseActivity;
import com.itheima.common.base.Const;
import com.itheima.takeout.R;

import static com.itheima.takeout.R.id.ll_add_address;

/**
 * 选择地址界面（地址列表界面）
 *
 * @author admin
 */
public class AddressListActivity extends BaseActivity {

    @Override
    public int getLayoutRes() {
        return R.layout.activity_select_recepient_address;
    }

    @Override
    public void initView() {
        super.setPageTitle("请选择地址");
    }

    @Override
    public void initListener() {
        findViewById(R.id.ll_add_address).setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v, int id) {
        if (id == R.id.ll_add_address) {    // 进入地址管理界面
            enterAddressManageActivity();
            return;
        }
    }

    /** 进入地址管理界面 */
    private void enterAddressManageActivity() {
        Intent view = new Intent(this, AddressManageActivity.class);
        startActivityForResult(view, Const.REQUEST_CODE_ADDRESS_LIST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 新增（修改/删除）了地址，需要刷新地址列表的显示
        if (Const.REQUEST_CODE_ADDRESS_LIST == requestCode
                && resultCode == Activity.RESULT_OK) {

        }
    }
}
