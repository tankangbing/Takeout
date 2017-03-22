package com.itheima.takeout.ui.holder;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.itheima.common.base.Global;
import com.itheima.common.ui.BaseAdapterRV;
import com.itheima.common.ui.BaseHolderRV;
import com.itheima.common.util.Utils;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.Home;
import com.itheima.takeout.ui.adapter.HomeCategoryAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * 列表头部显示：轮播图，促销类型，热榜数据ViewFlipper
 *
 * @author WJQ
 */
public class HomeHeaderHolder extends BaseHolderRV {

    private SliderLayout sliderLayout;
    private RecyclerView recyclerView02;
    private ViewFlipper viewFlipper;
    private HomeCategoryAdapter gridAdapter;

    public HomeHeaderHolder(Context context, ViewGroup parent,
                            BaseAdapterRV adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_home_header);
    }

    @Override
    public void onFindViews(View itemView) {
        sliderLayout = (SliderLayout) itemView.findViewById(R.id.slider_layout);
        recyclerView02 = (RecyclerView) itemView.findViewById(R.id.recycler_view_02);
        viewFlipper = (ViewFlipper) itemView.findViewById(R.id.view_flipper);

        // 轮播图

        // 促销类型
        recyclerView02.setLayoutManager(new GridLayoutManager(
                context, 2, GridLayoutManager.HORIZONTAL, false));
        gridAdapter = new HomeCategoryAdapter(context, null);
        recyclerView02.setAdapter(gridAdapter);

        // 热榜数据ViewFlipper
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(context,
                R.anim.push_up_in));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(context,
                R.anim.push_up_out));
        viewFlipper.startFlipping();  // 开始执行动画
    }

    @Override
    protected void onRefreshView(Object bean, int position) {
        Home home = (Home) bean;

//        private List<HotSaleListBean> hotSaleList;
//        private List<PromotionListBean> promotionList;
//        private List<PromotionTypesBean> promotionTypes;

        // 轮播图
        initLooperImage(home.getPromotionList());

        // 显示促销类型
        gridAdapter.setDatas(home.getPromotionTypes());

        // 显示热榜数据ViewFlipper
        showViewFlipper(home.getHotSaleList());
    }

    /**
     * 显示热榜数据
     * @param hotSaleList
     */
    private void showViewFlipper(List<Home.HotSaleListBean> hotSaleList) {
        viewFlipper.removeAllViews();

        for (Home.HotSaleListBean bean : hotSaleList) {
            TextView textView = new TextView(context);
            textView.setText(bean.getTitle());
            textView.setTextColor(Color.GRAY);
            textView.setGravity(Gravity.CENTER_VERTICAL);
            textView.setTextSize(12);

            // TextView的高度为20dp
            ViewGroup.LayoutParams param = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, Global.dp2px(20));
            viewFlipper.addView(textView, param);
        }
    }

    /** 显示轮播图*/
    private void initLooperImage(List<Home.PromotionListBean> promotionList) {
        // 选删除之前的选项
        sliderLayout.removeAllSliders();
        for (final Home.PromotionListBean bean : promotionList) {
            TextSliderView textSliderView = new TextSliderView(context);
            // 修正ip地址
            String imageUrl = Utils.replaceIp(bean.getImage());
            textSliderView.description(bean.getTitle()).image(imageUrl);
            // 设置子界面的点击事件
            textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    Global.showToast("" + bean.getTitle());
                }
            });
            // 添加一个子界面
            sliderLayout.addSlider(textSliderView);
        }
    }

}
