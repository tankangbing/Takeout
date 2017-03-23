package com.itheima.takeout.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.itheima.common.base.Global;
import com.itheima.takeout.R;
import com.liaoinstan.springview.container.BaseHeader;

/**
 * 百度外卖的列表下拉刷新动画效果
 *
 * @author WJQ
 */
public class BaiduHeader extends BaseHeader {

    private Context context;
    private OnHeaderPullListener onHeaderPullListener;

    private RelativeLayout rlRider;
    private ImageView ivRider;
    private ImageView ivBack;
    private ImageView ivBack02;
    private ImageView ivWheelLeft;
    private ImageView ivWheelRight;
    private ImageView ivSun;

    private final TranslateAnimation animRider;
    private final TranslateAnimation animBackground;
    private final RotateAnimation rotateWheel;
    private final RotateAnimation rotateSun;

    public interface OnHeaderPullListener {
        public void onPull(float percent);
    }

    public BaiduHeader(Context context){
        this(context, null);
    }

    public BaiduHeader(Context context, OnHeaderPullListener onHeaderPullListener) {
        this.context = context;
        this.onHeaderPullListener = onHeaderPullListener;

        animRider = new TranslateAnimation(0, 0, 0, -Global.dp2px(3));
        animRider.setDuration(600);
        animRider.setInterpolator(new LinearInterpolator());
        animRider.setRepeatCount(Integer.MAX_VALUE);

        animBackground = new TranslateAnimation(0, -Global.dp2px(200), 0, 0);
        animBackground.setDuration(1000);
        animBackground.setInterpolator(new LinearInterpolator());
        animBackground.setRepeatCount(Integer.MAX_VALUE);

        rotateWheel = new RotateAnimation(0, 360,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateWheel.setDuration(300);
        rotateWheel.setInterpolator(new LinearInterpolator());
        rotateWheel.setRepeatCount(Integer.MAX_VALUE);

        rotateSun = new RotateAnimation(0, 360,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateSun.setDuration(1000);
        rotateSun.setInterpolator(new LinearInterpolator());
        rotateSun.setRepeatCount(Integer.MAX_VALUE);
    }

    @Override
    public View getView(LayoutInflater inflater, ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.header_home, viewGroup, true);

        rlRider = (RelativeLayout) view.findViewById(R.id.rl_rider);
        ivBack = (ImageView) view.findViewById(R.id.iv_bg);
        ivBack02 = (ImageView) view.findViewById(R.id.iv_bg02);
        ivRider = (ImageView) view.findViewById(R.id.iv_rider);
        ivWheelLeft = (ImageView) view.findViewById(R.id.iv_wheel_left);
        ivWheelRight = (ImageView) view.findViewById(R.id.iv_wheel_right);
        ivSun = (ImageView) view.findViewById(R.id.iv_sun);

        return view;
    }

    @Override
    public void onPreDrag(View rootView) {
    }

    @Override
    public void onDropAnim(View rootView, int dy) {
        int maxHeight = rootView.getMeasuredHeight();
        dy = Math.min(Math.abs(dy), maxHeight);
        float percent = dy * 1f / maxHeight;
        if (onHeaderPullListener != null) {
            onHeaderPullListener.onPull(percent);
        }
    }

    @Override
    public void onLimitDes(View rootView, boolean upORdown) {
    }

    @Override
    public void onStartAnim() {
        ivRider.startAnimation(animRider);
        ivBack.startAnimation(animBackground);
        ivBack02.startAnimation(animBackground);

        ivWheelLeft.startAnimation(rotateWheel);
        ivWheelRight.startAnimation(rotateWheel);
        ivSun.startAnimation(rotateSun);
    }

    @Override
    public void onFinishAnim() {
        ivWheelLeft.clearAnimation();
        ivWheelRight.clearAnimation();
        ivRider.clearAnimation();
        ivBack.clearAnimation();
        ivBack02.clearAnimation();
        // ivSun.clearAnimation();
    }
}