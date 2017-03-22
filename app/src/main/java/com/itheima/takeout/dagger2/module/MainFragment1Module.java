package com.itheima.takeout.dagger2.module;

import com.itheima.takeout.base.BaseView;
import com.itheima.takeout.presenter.HomeFragment1Presenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author WJQ
 */
@Module
public class MainFragment1Module {

    private BaseView baseView;

    public MainFragment1Module(BaseView baseView) {
        this.baseView = baseView;
    }

    @Provides
    public HomeFragment1Presenter providePresenter(BaseView view) {
        return new HomeFragment1Presenter(view);
    }

    @Provides
    public BaseView provideBaseView() {
        return baseView;
    }
}
