package com.example.myuiproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

/**
 * 点击显示按钮，第一次显示Dialog，然后按BACK键返回。
 * show() —> onCreate() —> onStart();
 * cancel() —> onDismiss() —> Stop();
 * 再次点击显示按钮，然后点击Dialog外部。
 * show() —> onStart();
 * cancel() —> onDismiss() —> Stop();
 * 再次点击显示按钮，然后执行Dialog.dismiss() 方法。
 * show() —> onStart();
 * onDismiss() —> Stop();
 */
public class BaseDialog extends Dialog {

    public BaseDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void cancel() {
        super.cancel();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
