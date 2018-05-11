package com.example.administrator.rikao03.http;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtiles {
    private static RetrofitUtiles retrofitUtiles;
    private final Retrofit retrofit;

    public static RetrofitUtiles getInstance() {

        if (retrofitUtiles==null){
            retrofitUtiles=new RetrofitUtiles();
        }
        return retrofitUtiles;
    }

    public RetrofitUtiles(){

        retrofit = new Retrofit.Builder()
                .baseUrl(Httpfig.url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public<T> T createRequest(Class<T> cls){
        T t = retrofit.create(cls);
        return t;
    }
}
