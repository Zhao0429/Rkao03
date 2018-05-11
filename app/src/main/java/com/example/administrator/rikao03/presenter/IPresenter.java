package com.example.administrator.rikao03.presenter;

import com.example.administrator.rikao03.model.GoodsBean;
import com.example.administrator.rikao03.model.IModel;
import com.example.administrator.rikao03.view.IMainView;

import java.util.List;

public interface IPresenter {
    void GetDate(IModel iModel, IMainView iMainView);

    void GetGoodsDate(List<GoodsBean.DataBean> data);
}
