package com.itheima.takeout.model.protocol;

/**
 * @author WJQ
 */
import com.google.gson.JsonObject;
import com.itheima.common.base.Const;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/** Retrofit接口 */
public interface IHttpService {

    String HOST_URL = "http://" + Const.HOST_IP + ":8080/TakeoutService/";

//    0: 账号密码登录
//    1：手机号码登录
//    2: 第三方应用登录
    int TYPE_LOGIN_NORMAL = 0;
    int TYPE_LOGIN_PHONE = 1;
    int TYPE_LOGIN_THIRD_PART = 2;

    int TYPE_HOME = 0;
    int TYPE_SHOP_LIST = 1;
    int TYPE_SHOP_CATEGORY = 2;
    int TYPE_ORDER_BY = 3;
    int TYPE_SHOP_DETAIL = 4;
    int TYPE_LOGIN = 4;
    int TYPE_LOGIN_2 = 5;
    int TYPE_CREATE_ORDER = 6;
    int TYPE_LOGOUT = 7;
    int TYPE_ORDER_LIST = 8;

    @GET("home")
    Call<JsonObject> getHomeData();

    @POST("createOrder")
    @FormUrlEncoded
    Call<JsonObject> createOrder(
            @Field("payInfo") String payInfo);

    @POST("orderList")
    @FormUrlEncoded
    Call<JsonObject> getOrderList(
            @Field("username") String username,
            @Field("token") String token);

    @GET("login")
    Call<JsonObject> login(
            @Query("type") int type,
            @Query("phone") String phone);

    @GET("login")
    Call<JsonObject> login(
            @Query("type") int type,
            @Query("username") String username,
            @Query("password") String password);

    @GET("shopCategory")
    Call<JsonObject> getShopCategory();

    @GET("orderBy")
    Call<JsonObject> getOrderBy();

    @GET("shopDetail")
    Call<JsonObject> getShopDetail(@Query("shopId") int shopId);

    @POST("shopList")
    @FormUrlEncoded
    Call<JsonObject> getShopList(
            @FieldMap Map<String, Object> map);
}
