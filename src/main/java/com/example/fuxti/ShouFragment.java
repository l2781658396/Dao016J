package com.example.fuxti;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fuxti.presenter.MainPresenter;
import com.example.fuxti.view.MainView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShouFragment extends Fragment implements MainView {


    private RecyclerView mRecy;
    private ArrayList<DataBean.ResultsBean> list;
    private RecyAdapter adapter;
    private MainPresenter presenter;
    public ShouFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shou, container, false);
         initdata(inflate);
        presenter = new MainPresenter(this);
        presenter.setData();
        return inflate;
    }

    private void initdata(View inflate) {
        mRecy = inflate.findViewById(R.id.Recy);
        mRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecy.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
        list = new ArrayList<>();
        adapter = new RecyAdapter(list, getActivity());
        mRecy.setAdapter(adapter);
    }

    @Override
    public void ShouToast(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void send(ArrayList<DataBean.ResultsBean> beans) {
         list.addAll(beans);
         adapter.notifyDataSetChanged();
    }


}
