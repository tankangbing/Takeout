package com.itheima.takeout.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.itheima.common.base.BaseActivity;
import com.itheima.common.base.Const;
import com.itheima.common.util.LogUtil;
import com.itheima.takeout.R;
import com.itheima.takeout.db.greendao.Address;
import com.itheima.takeout.db.greendao.AddressDao;
import com.itheima.takeout.model.dao.GreenDaoHelper;
import com.itheima.takeout.ui.adapter.AddressAdapter;

import java.util.List;

import static com.itheima.takeout.R.id.ll_add_address;

/**
 * 选择地址界面（地址列表界面）
 *
 * @author admin
 */
public class AddressListActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private LinearLayout llAddAddress;
    private AddressAdapter mAddressAdapter;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_select_recepient_address;
    }

    @Override
    public void initView() {
        super.setPageTitle("请选择地址");
        llAddAddress = (LinearLayout) findViewById(R.id.ll_add_address);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAddressAdapter = new AddressAdapter(this, null);
        recyclerView.setAdapter(mAddressAdapter);
    }

    @Override
    public void initListener() {
        findViewById(R.id.ll_add_address).setOnClickListener(this);
    }

    @Override
    public void initData() {
        showAddressList();
    }

    /** 获取所有的地址，刷新列表显示 */
    private void showAddressList() {
        AddressDao addressDao = GreenDaoHelper.getInstance().getAddressDao();
        // 获取用户所有的接收地址
        List<Address> allAddress = addressDao.queryBuilder().build().list();
        /*if (allAddress != null) {
            for (Address address : allAddress) {
                LogUtil.d("--------------地址：" + address.toString());
            }
        }*/
        // 刷新列表地址显示
        mAddressAdapter.setDatas(allAddress);
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
            showAddressList();
        }
    }
}
