package com.example.administrator.rikao03.model;


import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface MyService {

    @GET("product/getProducts")
    Observable<GoodsBean> getGoods(@QueryMap Map<String,String> map);
}
