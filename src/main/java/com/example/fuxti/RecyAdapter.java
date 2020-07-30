package com.example.fuxti;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class RecyAdapter extends RecyclerView.Adapter {
    private ArrayList<DataBean.ResultsBean> list;
    private Context context;

    public RecyAdapter(ArrayList<DataBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recy, null);
        return new ViewHandles(inflate);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
               ViewHandles viewHandles= (ViewHandles) holder;
               viewHandles.name.setText(list.get(position).getDesc());
        RequestOptions options = RequestOptions.circleCropTransform();
        Glide.with(context).load(list.get(position).getUrl()).apply(options).into(viewHandles.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHandles extends RecyclerView.ViewHolder{
       private ImageView img;
       private TextView name;
        public ViewHandles(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            name=itemView.findViewById(R.id.name);
        }
    }
}
