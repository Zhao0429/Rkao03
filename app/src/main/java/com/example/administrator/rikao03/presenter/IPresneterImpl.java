package com.example.administrator.rikao03.presenter;

import com.example.administrator.rikao03.http.GoodsListener;
import com.example.administrator.rikao03.http.Httpfig;
import com.example.administrator.rikao03.model.GoodsBean;
import com.example.administrator.rikao03.model.IModel;
import com.example.administrator.rikao03.view.IMainView;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IPresneterImpl implements IPresenter{
    private IMainView iMainView;

    @Override
    public void GetDate(IModel iModel, final IMainView iMainView){
        this.iMainView=iMainView;
        Map<String,String> map=new HashMap<>();
        map.put("pscid",iMainView.pscid()+"");
//        iModel.getGoodsDate(Httpfig.url, map, new GoodsListener() {
//            @Override
//            public void GoodsSuccess(String json) {
//                Gson gson=new Gson();
//                GoodsBean goodsBean = gson.fromJson(json, GoodsBean.class);
//                List<GoodsBean.DataBean> list= goodsBean.getData();
//                iMainView.ShowGoods(list);
//            }
//
//            @Override
//            public void GoodsError(String error) {
//
//            }
//        });
        iModel.getGoodsDate(map);
    }

    @Override
    public void GetGoodsDate(List<GoodsBean.DataBean> data) {
        iMainView.ShowGoods(data);
    }
}
