package com.example.fuxti.view;

import com.example.fuxti.DataBean;

import java.util.ArrayList;

public interface MainView {
    void ShouToast(String str);
    void send(ArrayList<DataBean.ResultsBean> beans);
}
