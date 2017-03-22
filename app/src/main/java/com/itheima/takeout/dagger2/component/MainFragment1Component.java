package com.itheima.takeout.dagger2.component;

import com.itheima.takeout.dagger2.module.MainFragment1Module;
import com.itheima.takeout.ui.fragment.MainFragment1;

import dagger.Component;

/**
 * @author WJQ
 */
@Component(modules = MainFragment1Module.class)
public interface MainFragment1Component {

    public void inject(MainFragment1 fragment);
}
