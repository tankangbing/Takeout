package com.itheima.takeout.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.itheima.common.base.BaseActivity;
import com.itheima.takeout.R;
import com.itheima.takeout.ui.fragment.LoginFragment1;
import com.itheima.takeout.ui.fragment.LoginFragment2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 */

public class LoginActivity extends BaseActivity {

    @Override
    public int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        initViewPager();
    }

    private void initViewPager() {
        ViewPager viewPager = findView(R.id.view_pager);
        TabLayout tabLayout = findView(R.id.tab_layout);

        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new LoginFragment1());
        fragments.add(new LoginFragment2());

        final String[] titles = new String[] {
                "短信快捷登录", "普通登录"};

        viewPager.setAdapter(new FragmentPagerAdapter(
                getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void initListener() {
    }

    @Override
    public void initData() {
    }

    @Override
    public void onClick(View v, int id) {
    }
}
