package com.example.myuiproject;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myuiproject.databinding.ActivityMainBinding;
import com.example.myuiproject.customview.dialog.SimpleDialogFragment;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding mActivityMainBinding;
    private SimpleDialogFragment mSimpleDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mActivityMainBinding.mainDialogSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSimpleDialogFragment == null) {
                    mSimpleDialogFragment = SimpleDialogFragment.newInstance(SimpleDialogFragment.SimpleDialogType.WAIT, "我是标题", "我是内容");
                }
                mSimpleDialogFragment.show(getSupportFragmentManager(), "SimpleDialogFragment");
                Disposable subscribe = Observable.create(
                        new ObservableOnSubscribe<Integer>() {
                            @Override
                            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                                Thread.sleep(3000);
                                emitter.onNext(3);
                                Thread.sleep(2000);
                                emitter.onNext(2);
                            }
                        })
                        .subscribeOn(Schedulers.single())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Integer>() {
                            @Override
                            public void accept(Integer integer) throws Exception {
                                Log.d("wzgcc", "accept2  : " + integer);
                                if (integer == 3) {
                                    mSimpleDialogFragment.setProgressFinishContent("任务结束");
                                } else {
                                    mSimpleDialogFragment.dismiss();
                                    mSimpleDialogFragment = null;
                                }
                            }
                        });
            }
        });

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {

            }
        });
    }

    private static void initVerticalLayout(Context context) {
//        MyRecycleView recycleView = new MyRecycleView(context);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recycleView.setLayoutManager(linearLayoutManager);
//
//        MyRecycleAdapter<NewsBean> recycleAdapter = new MyRecycleAdapter<>(R.layout.adapter_simple_vertical_item, new MyRecycleAdapter.MyRecycleAdapterLife<NewsBean>() {
//            @Override
//            public MyRecycleAdapter.MyViewHolder onCreateViewHolder(View itemView) {
//                return null;
//            }
//
//            @Override
//            public void onBindViewHolder(MyRecycleAdapter.MyViewHolder myViewHolder, NewsBean newsBean) {
//
//            }
//        });
//        recycleView.setAdapter();
    }

}