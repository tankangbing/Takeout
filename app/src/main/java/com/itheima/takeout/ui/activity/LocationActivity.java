package com.itheima.takeout.ui.activity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.overlay.PoiOverlay;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.itheima.common.base.BaseActivity;
import com.itheima.common.util.LogUtil;
import com.itheima.takeout.R;
import com.itheima.takeout.ui.adapter.POIAdapter;

import java.util.ArrayList;

/**
 * @author admin
 */

public class LocationActivity extends BaseActivity {

    private AMap mAMap;
    private MapView mapView;

    private RecyclerView recyclerView;
    private POIAdapter mAdapter;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_location;
    }

    @Override
    public void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new POIAdapter(this, null);
        recyclerView.setAdapter(mAdapter);

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

    //==========定位功能(begin)=================
    public AMapLocationClient mLocationClient;

    private void initLocation() {
        // 第1步：初始化LocationClient
        mLocationClient = new AMapLocationClient(getApplicationContext());
        // 第2步：设置定位回调监听
        mLocationClient.setLocationListener(new AMapLocationListener() {

            @Override   // 返回定位结果
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation == null)
                    return;

                // 第4步： 获取定位结果
                if (aMapLocation.getErrorCode() == 0) { // 定位成功
                    String info = aMapLocation.getLatitude() + "   "
                            + aMapLocation.getLongitude();
                    // showToast(info);
                    LogUtil.d("----------定位： " + info);

                    // 显示系统小蓝点
                    if (mOnLocationChangedListener != null) {
                        mOnLocationChangedListener.onLocationChanged(aMapLocation);
                    }

                    // 第5步：通过标注显示当前位置
                    showMyLocation(aMapLocation);

                    // 第6步：搜索周边的位置
                    poiSearch(aMapLocation);

                    // 定位成功后，停止定位
                    stopLocation();

                } else {    // 定位失败
                    Log.e("AmapError","location Error, ErrCode:"
                            + aMapLocation.getErrorCode() + ", errInfo:"
                            + aMapLocation.getErrorInfo());
                }
            }
        });
        startLocation();
    }

    private PoiSearch.Query query;
    private PoiSearch poiSearch;

    /** 第6步：搜索周边的位置*/
    private void poiSearch(final AMapLocation aMapLocation) {
        //keyWord表示搜索字符串，
        //第二个参数表示POI搜索类型，可以传空
        //cityCode表示POI搜索区域，可以是城市编码也可以是城市名称，
        // 也可以传空字符串，空字符串代表全国在全国范围内进行搜索
        String keyWord = "";
        String cityCode = aMapLocation.getCityCode();
        query = new PoiSearch.Query(keyWord, "", cityCode);
        query.setPageSize(10);              // 每页多少条
        query.setPageNum(1);                // 设置查询页码

        // 创建搜索对象
        poiSearch = new PoiSearch(this, query);

        // 周边搜索：指定中心点的搜索范围（半径: 1000米）
        LatLonPoint currentPos = new LatLonPoint(
                aMapLocation.getLatitude(), aMapLocation.getLongitude());
        poiSearch.setBound(new PoiSearch.SearchBound(currentPos, 1000));

        // 设置监听器
        poiSearch.setOnPoiSearchListener(new PoiSearch.OnPoiSearchListener() {
            @Override
            public void onPoiSearched(PoiResult poiResult, int i) {
                // 接收搜索结果
                if (poiResult == null)
                    return;

                // 搜索结果（分页数据）
                ArrayList<PoiItem> listData = poiResult.getPois();

                // 列表第一项显示当前位置， 所以多加一个PoiItem
                PoiItem item = new PoiItem("",
                        new LatLonPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()),
                        "[当前位置]" + aMapLocation.getPoiName(),   // title
                        aMapLocation.getAddress());                 // Snippet 详情地址
                listData.add(0, item);      // 作为集合的第一个元素

                // 使用Overlay，在地图上显示搜索结果
                PoiOverlay overlay = new PoiOverlay(mAMap, listData);
                overlay.addToMap();         // 添加到地图
                overlay.zoomToSpan();       // 缩放地图到合适的范围，以查看所有数据

                // 在列表中显示地址
                mAdapter.setDatas(listData);
            }

            @Override
            public void onPoiItemSearched(PoiItem poiItem, int i) {
            }
        });
        // 发起异步搜索
        poiSearch.searchPOIAsyn();
    }

    /** 通过标注显示当前位置*/
    private void showMyLocation(AMapLocation location) {
        MarkerOptions option = new MarkerOptions();
        option.position(new LatLng(
                location.getLatitude(), location.getLongitude()));
        option.title("当前位置").snippet("xxxxx");
        // markerOption.draggable(true);  //设置Marker可拖动
        option.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                .decodeResource(getResources(), R.drawable.icon_my_position)));
        // 显示标注
        mAMap.addMarker(option);
    }

    /** 配置参数，开始定位*/
    private void startLocation() {
        // 第3步：配置参数，开始定位
        AMapLocationClientOption option = new AMapLocationClientOption();
        // 高精度模式
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        // 设置定位间隔,单位毫秒,默认为2000ms，最低1000ms。
        option.setInterval(2000);
        // 默认返回地址信息
        option.setNeedAddress(true);

        // 给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(option);
        // 启动定位
        mLocationClient.startLocation();
    }

    // 停止定位
    private void stopLocation() {
        if (mLocationClient != null) {
            mLocationClient.stopLocation();
            mLocationClient.onDestroy();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
        stopLocation();
    }

    //==========定位功能(end)=================



    //==========MapView显示(begin)=================
    MapView mMapView = null;
    Bundle savedInstanceState;

    LocationSource.OnLocationChangedListener mOnLocationChangedListener;

    private void initMap() {
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.map_view);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMapView.onCreate(savedInstanceState);

        mAMap = mMapView.getMap();
        // 设置地图显示的中心位置
//        mAMap.moveCamera(CameraUpdateFactory.newLatLng(
//                new LatLng(23.1291679057,113.4278395801)));
        mAMap.moveCamera(CameraUpdateFactory.zoomTo(15));

        // initLocation();  // 开始定位
        // 设置定位监听
        mAMap.setLocationSource(new LocationSource() {
            @Override   // 界面激活
            public void activate(OnLocationChangedListener listener) {
                mOnLocationChangedListener = listener;
                initLocation();
            }

            @Override
            public void deactivate() {
                stopLocation();     // 停止定位
            }
        });
        // 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        mAMap.setMyLocationEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        super.onCreate(savedInstanceState);
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
}
