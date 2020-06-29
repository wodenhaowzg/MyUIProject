package com.example.myuiproject.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;

public class MyRecycleAdapter<T> extends RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder> {

    private List<T> mDatas;
    private int mLayoutId;
    private MyRecycleAdapterLife<T> mMyRecycleAdapterLife;

    public MyRecycleAdapter(int layoutId, MyRecycleAdapterLife<T> recycleAdapterLife) {
        this.mLayoutId = layoutId;
        this.mMyRecycleAdapterLife = recycleAdapterLife;
    }

    public void setDatas(List<T> datas) {
        if (datas == null || datas.size() <= 0) {
            return;
        }

        this.mDatas = datas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        View inflate = View.inflate(context, mLayoutId, viewGroup);
        return mMyRecycleAdapterLife.onCreateViewHolder(inflate);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int posintion) {
        T t = mDatas.get(posintion);
        mMyRecycleAdapterLife.onBindViewHolder(myViewHolder, t);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private HashMap<String, View> mViews;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void addView(String viewName, View view) {
            mViews.put(viewName, view);
        }

        public View getView(String viewName) {
            return mViews.get(viewName);
        }
    }

    public interface MyRecycleAdapterLife<T> {

        MyViewHolder onCreateViewHolder(View itemView);

        void onBindViewHolder(MyViewHolder myViewHolder, T t);
    }
}
