package com.example.myuiproject;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

class BaseActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        mContext = newBase;
    }
}
