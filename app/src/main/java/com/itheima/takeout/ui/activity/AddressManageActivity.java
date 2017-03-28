package com.itheima.takeout.ui.activity;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.itheima.common.base.BaseActivity;
import com.itheima.common.base.Const;
import com.itheima.takeout.R;
import com.itheima.takeout.db.greendao.Address;
import com.itheima.takeout.model.bean.local.Sex;
import com.itheima.takeout.presenter.AddressManageActivityPresenter;

/**
 * 地址管理界面：新增，编辑，删除地址
 *
 * @author admin
 */
public class AddressManageActivity extends BaseActivity {

    private EditText etName;
    private RadioButton rbMale;
    private RadioButton rbFemale;
    private EditText etPhone;
    private LinearLayout llLocation;
    private TextView tvAddress;
    private ImageView ivArrowRight;
    private EditText etAddressDetail;
    private Button btnSaveAddress;
    private Button btnDeleteAddress;

    /** 要编辑的地址 */
    private Address mAddress;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_address_manage;
    }

    @Override
    public void initView() {
        etName = (EditText) findViewById(R.id.et_name);
        rbMale = (RadioButton) findViewById(R.id.rb_male);
        rbFemale = (RadioButton) findViewById(R.id.rb_female);
        etPhone = (EditText) findViewById(R.id.et_phone);
        llLocation = (LinearLayout) findViewById(R.id.ll_location);
        ivArrowRight = (ImageView) findViewById(R.id.iv_arrow_right);
        tvAddress = (TextView) findViewById(R.id.tv_address);
        etAddressDetail = (EditText) findViewById(R.id.et_address_detail);
        btnSaveAddress = (Button) findViewById(R.id.btn_save_address);
        btnDeleteAddress = (Button) findViewById(R.id.btn_delete_address);

        // 接收上一个界面传过来的要编辑的地址
        mAddress = (Address) getIntent().getSerializableExtra(Const.KEY_BEAN);
        if (mAddress == null) { // 新增地址
            super.setPageTitle("新增地址");
            btnDeleteAddress.setVisibility(View.GONE);
        } else {    // 编辑地址
            super.setPageTitle("编辑地址");
            btnDeleteAddress.setVisibility(View.VISIBLE);
            fillData(mAddress);     // 回显之前的地址信息
        }
    }

    /** 回显之前的地址信息*/
    private void fillData(Address address) {
        etName.setText(address.getName());
        if (address.getSex() == 0) {
            rbMale.setChecked(true);
        } else {
            rbFemale.setChecked(true);
        }
        etPhone.setText(address.getPhone());
        tvAddress.setText(address.getAddressName());
        etAddressDetail.setText(address.getAddressDetail());
    }

    @Override
    public void initListener() {
    }

    private AddressManageActivityPresenter mPresenter;

    @Override
    public void initData() {
        mPresenter = new AddressManageActivityPresenter(this);
    }

    @Override
    public void onClick(View v, int id) {
        if (btnSaveAddress == v) {      // 点击了保存按钮
            saveOrEdit();
            return;
        }

        if (btnDeleteAddress == v) {      // 删除地址
            mPresenter.getAddressDao().delete(mAddress);
            setResult(Activity.RESULT_OK);      // 退出当前界面
            finish();
            return;
        }
    }

    /** 保存或编辑地址 */
    private void saveOrEdit() {
        if (mAddress == null) {     // 新增地址
            if (validateInput()) {      // 验证通过,保存地址到数据库中
                String name = etName.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                String addressName = "吉山"; // tvAddress.getText().toString().trim();
                String addressDetail = etAddressDetail.getText().toString().trim();

                // 性别
                // 保存地址到数据库中
                // Sex.MALE.ordinal();
                // Sex.FEMALE.ordinal();
                int sex = rbMale.isChecked() ? 0 : 1;

                // String name, Integer sex, String phone, String addressName,
                // String addressDetail, Double latitude, Double longitude
                Address address = new Address(name, sex, phone,
                        addressName, addressDetail, 23d, 113d);
                mPresenter.getAddressDao().insert(address);

                // 退出当前界面
                setResult(Activity.RESULT_OK);
                finish();
            }
        } else {    // 编辑地址
            if (validateInput()) {      // 验证通过,保存地址到数据库中
                String name = etName.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                String addressName = "吉山"; // tvAddress.getText().toString().trim();
                String addressDetail = etAddressDetail.getText().toString().trim();

                // 性别
                // 保存地址到数据库中
                // Sex.MALE.ordinal();
                // Sex.FEMALE.ordinal();
                int sex = rbMale.isChecked() ? 0 : 1;

                // String name, Integer sex, String phone, String addressName,
                // String addressDetail, Double latitude, Double longitude
                Address address = new Address(mAddress.getId(), name, sex, phone,
                        addressName, addressDetail, 23d, 113d);
                mPresenter.getAddressDao().update(address);

                // 退出当前界面
                setResult(Activity.RESULT_OK);
                finish();
            }
        }
    }

    /** 验证用户输入的合法性, 数据验证通过，返回true */
    private boolean validateInput() {
        String name = etName.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String addressName = tvAddress.getText().toString().trim();
        String addressDetail = etAddressDetail.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            showDialog("请输入用户名");
            return false;
        }

        if (TextUtils.isEmpty(phone)) {
            showDialog("请输入电话号码");
            return false;
        }

//        if (TextUtils.isEmpty(addressName)) {
//            showDialog("请选择地址");
//            return false;
//        }

        if (TextUtils.isEmpty(addressDetail)) {
            showDialog("请设置详细地址");
            return false;
        }

        // 验证通过
        return true;
    }
}
