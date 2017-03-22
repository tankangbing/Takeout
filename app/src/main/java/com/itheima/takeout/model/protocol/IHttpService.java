package com.itheima.takeout.model.protocol;

/**
 * @author WJQ
 */

import com.google.gson.JsonObject;
import com.itheima.common.base.Const;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/** Retrofit接口 */
public interface IHttpService {

    String HOST_URL = "http://" + Const.HOST_IP + ":8080/TakeoutService/";

    int TYPE_HOME = 0;
    int TYPE_SHOP_LIST = 1;

    @GET("home")
    Call<JsonObject> getHomeData();

    @POST("shopList")
    @FormUrlEncoded
    Call<JsonObject> getShopList(
            @FieldMap Map<String, Object> map);

}
