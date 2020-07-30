package com.example.fuxti.presenter;

import com.example.fuxti.CallBack;
import com.example.fuxti.DataBean;
import com.example.fuxti.molde.MainMolde;
import com.example.fuxti.view.MainView;

import java.util.ArrayList;


public class MainPresenter implements CallBack {
    private MainView mainView;
    private MainMolde mainMolde;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        this.mainMolde=new MainMolde();
    }

    @Override

    public void Onfile(String str) {
          mainView.ShouToast(str);
    }

    @Override
    public void OnSend(ArrayList<DataBean.ResultsBean> lists) {
       mainView.send(lists);
    }

    public void setData() {
        mainMolde.getData(this);
    }
}
