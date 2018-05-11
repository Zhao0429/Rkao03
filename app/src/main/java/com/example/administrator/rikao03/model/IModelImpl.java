package com.example.administrator.rikao03.model;


import android.util.Log;

import com.example.administrator.rikao03.http.GoodsListener;
import com.example.administrator.rikao03.http.OKHttpUtils;
import com.example.administrator.rikao03.http.RetrofitUtiles;
import com.example.administrator.rikao03.presenter.IPresenter;

import java.util.Map;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class IModelImpl implements IModel{
    private static final String TAG = "IModelImpl";
    private final IPresenter iPresenter;

    public IModelImpl(IPresenter iPresenter){
        this.iPresenter=iPresenter;
    }
    @Override
    public void getGoodsDate(Map<String, String> map) {
        RetrofitUtiles retrofitUtiles=RetrofitUtiles.getInstance();
        MyService myService = retrofitUtiles.createRequest(MyService.class);
        Observable<GoodsBean> observable = myService.getGoods(map);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GoodsBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "完成");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "异常"+e.getMessage());
                    }

                    @Override
                    public void onNext(GoodsBean goodsBean) {
                        iPresenter.GetGoodsDate(goodsBean.getData());
                    }
                });

    }
//    @Override
//    public void getGoodsDate(String url, Map<String, String> map, final GoodsListener goodsListener) {
//        OKHttpUtils okHttpUtils=new OKHttpUtils();
//        okHttpUtils.okPost(url,map);
//        okHttpUtils.setOnLoginListener(new OKHttpUtils.LoginListener() {
//            @Override
//            public void loginSuccess(String json) {
//                goodsListener.GoodsSuccess(json);
//            }
//
//            @Override
//            public void loginError(String error) {
//                goodsListener.GoodsError(error);
//            }
//        });
//    }
}
