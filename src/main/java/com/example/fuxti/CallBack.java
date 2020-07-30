package com.example.fuxti;

import java.util.ArrayList;

public interface CallBack {
    void Onfile(String str);
    void OnSend(ArrayList<DataBean.ResultsBean> lists);
}
