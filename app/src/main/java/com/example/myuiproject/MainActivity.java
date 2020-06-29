package com.example.myuiproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.myuiproject.bean.NewsBean;
import com.example.myuiproject.databinding.ActivityMainBinding;
import com.example.myuiproject.view.MyRecycleAdapter;
import com.example.myuiproject.view.MyRecycleView;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding mActivityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    private static void initVerticalLayout(Context context){
        MyRecycleView recycleView = new MyRecycleView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(linearLayoutManager);

        MyRecycleAdapter<NewsBean> recycleAdapter = new MyRecycleAdapter<>(R.layout.adapter_simple_vertical_item, new MyRecycleAdapter.MyRecycleAdapterLife<NewsBean>() {
            @Override
            public MyRecycleAdapter.MyViewHolder onCreateViewHolder(View itemView) {
                return null;
            }

            @Override
            public void onBindViewHolder(MyRecycleAdapter.MyViewHolder myViewHolder, NewsBean newsBean) {

            }
        });
        recycleView.setAdapter();
    }

}