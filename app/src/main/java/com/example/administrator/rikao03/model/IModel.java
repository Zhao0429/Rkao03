package com.example.administrator.rikao03.model;

import com.example.administrator.rikao03.http.GoodsListener;

import java.util.Map;

public interface IModel {

    //void getGoodsDate(String url, Map<String,String> map, GoodsListener goodsListener);

    void getGoodsDate(Map<String,String> map);
}
