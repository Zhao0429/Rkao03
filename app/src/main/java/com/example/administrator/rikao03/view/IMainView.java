package com.example.administrator.rikao03.view;

import com.example.administrator.rikao03.model.GoodsBean;

import java.util.List;

public interface IMainView {
    void ShowGoods(List<GoodsBean.DataBean> list);
    int pscid();
}
