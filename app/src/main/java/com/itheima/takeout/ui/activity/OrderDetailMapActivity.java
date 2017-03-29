package com.itheima.takeout.ui.activity;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.PolylineOptions;
import com.itheima.common.base.BaseActivity;
import com.itheima.common.base.Const;
import com.itheima.common.base.OttoBus;
import com.itheima.takeout.R;
import com.itheima.takeout.model.bean.local.Location;
import com.itheima.takeout.model.protocol.IHttpService;
import com.squareup.otto.Subscribe;

/**
 * 展示骑手的配送路线
 *
 * @author admin
 */
public class OrderDetailMapActivity extends BaseActivity {

    private MapView mapView;
    private AMap mAMap;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_order_status_map;
    }

    @Override
    public void initView() {
        mapView = (MapView) findViewById(R.id.map_view);
        initMap();
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


    //==========MapView显示(begin)=================
    MapView mMapView = null;
    Bundle savedInstanceState;

    private void initMap() {
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.map_view);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMapView.onCreate(savedInstanceState);

        mAMap = mMapView.getMap();
        // 设置地图显示的中心位置
        mAMap.moveCamera(CameraUpdateFactory.newLatLng(
                new LatLng(23.1291679057,113.4278395801)));
        mAMap.moveCamera(CameraUpdateFactory.zoomTo(15));

        // 展示买家和卖家
        showBuyerAndSeller();
    }


//    卖家：
//            23.1297999026,113.4151931774
//    买家：
//            23.1291679057,113.4278395801

    private void showBuyerAndSeller() {
        MarkerOptions option = new MarkerOptions();
        option.position(new LatLng(23.1291679057,113.4278395801));
        option.title("买家").snippet("xxxxx");
        option.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                .decodeResource(getResources(), R.drawable.order_buyer_icon)));
        // 显示标注
        mAMap.addMarker(option);


        option = new MarkerOptions();
        option.position(new LatLng(23.1297999026,113.4151931774));
        option.title("卖家").snippet("xxxxx");
        option.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                .decodeResource(getResources(), R.drawable.order_seller_icon)));
        // 显示标注
        mAMap.addMarker(option);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        super.onCreate(savedInstanceState);
        // 注册otto
        OttoBus.getDefault().register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)
        // ，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }
    //==========MapView显示(end)=================


    private LatLng mSellerPos = new LatLng(23.1297999026,113.4151931774);

    // 路线的起点
    private LatLng mStartPos = mSellerPos;

    /** 绘制骑手配送路线 */
    private void drawRiderRoute(LatLng endPos) {
        // 绘制折线(Polyline)
        PolylineOptions options = new PolylineOptions();
        options.add(mStartPos, endPos);
        options.width(4);
        options.color(Color.RED);
        mAMap.addPolyline(options);         // 绘制一条直线
        mStartPos = endPos;
    }

    //============otto事件监听(begin)====================
    @Override
    public void onDestroy() {
        super.onDestroy();
        // 注销otto
        OttoBus.getDefault().unregister(this);
    }

    // 监听otto事件的方法
    @Subscribe
    public void onEvent(Message ottoMsg) {
        if (ottoMsg.what == Const.TYPE_UPDATE_RIDER_POSITION) {
            Location location = (Location) ottoMsg.obj;
            showToast("location: " + location);

            // 绘制一小段直接
            drawRiderRoute(new LatLng(location.getLatitude(), location.getLongitude()));
        }
    }
    //============otto事件监听(end)====================
}
