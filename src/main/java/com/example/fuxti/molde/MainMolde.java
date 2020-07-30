package com.example.fuxti.molde;

import com.example.fuxti.ApiService;
import com.example.fuxti.CallBack;
import com.example.fuxti.DataBean;
import com.example.fuxti.presenter.MainPresenter;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainMolde {
    public void getData(final CallBack callBack) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = build.create(ApiService.class);
        Observable<DataBean> bean = apiService.bean();
        bean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DataBean dataBean) {
                     callBack.OnSend((ArrayList<DataBean.ResultsBean>) dataBean.getResults());
                    }

                    @Override
                    public void onError(Throwable e) {
                   callBack.Onfile(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
