package com.example.fuxti;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class WoFragment extends Fragment {


    private WebView mWeb;
    boolean isDataLoaded;
    public WoFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_wo, container, false);
        initdata(inflate);
        return inflate;
    }

    private void initdata(View inflate) {
        mWeb = inflate.findViewById(R.id.web);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(!isDataLoaded&&isVisibleToUser){
            mWeb.loadUrl("https://www.baidu.com/");
            mWeb.setWebViewClient(new WebViewClient());
            isDataLoaded=true;
        }
    }
}
