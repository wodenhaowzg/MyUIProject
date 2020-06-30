package com.example.myuiproject.customview.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myuiproject.R;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

/**
 * 生命周期：
 * 创建到显示 onAttach -> onCreate -> onCreateDialog -> onCreateView -> onActivityCreated -> onStart -> onResume
 * 显示到后台 onPause -> onSaveInstanceState -> onStop
 * 显示到隐藏 onDismiss -> onPause -> onStop
 * <p>
 * 执行完 onCreateDialog 之后 getDialog() 返回的才不会是 null
 * <p>
 * 使用方式：
 * SimpleDialogFragment simpleDialogFragment = SimpleDialogFragment.newInstance("我是标题", "我是内容");
 * simpleDialogFragment.show(getSupportFragmentManager(), "SimpleDialogFragment");
 *
 *
 *
 */
public class SimpleDialogFragment extends DialogFragment {

    private static final String TAG = "SimpleDialogFragment";
    private int mStyleId;
    private int mAnimResId;
    private SimpleDialogBean mArgsBean;

    private ProgressDialog mProgressDialog;

    public static SimpleDialogFragment newInstance(SimpleDialogType simpleDialogType, String title, String content) {
        SimpleDialogBean bean = new SimpleDialogBean();
        bean.mTitle = title;
        bean.mContent = content;
        bean.mSimpleDialogType = simpleDialogType;
        SimpleDialogFragment fragment = new SimpleDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("argsBean", bean);
        fragment.setArguments(bundle);
        return fragment;
    }

    public static SimpleDialogFragment newInstance(SimpleDialogBean bean) {
        SimpleDialogFragment fragment = new SimpleDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("argsBean", bean);
        fragment.setArguments(bundle);
        return fragment;
    }

    public void setAnim(int animResId) {
        this.mAnimResId = animResId;
    }

    public void setProgressFinishContent(String content) {
        if (mArgsBean != null) {
            mArgsBean.mContent = content;
        }

        if (mProgressDialog != null) {
            ColorDrawable colorDrawable = new ColorDrawable();
            mProgressDialog.setIndeterminateDrawable(colorDrawable);
            mProgressDialog.setMessage(content);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        lifeLog("onAttach");
        super.onAttach(context);
    }

    /**
     * parentId：因不可抗力，诸如横竖屏切换、分屏、折叠屏切换等可能造成 DialogFragment 重启，
     * 为保证重启后功能正常运行，因此需要保存自己爹（BaseDialog）的id，方便重新绑定到BaseDialog
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            mArgsBean = (SimpleDialogBean) arguments.getSerializable("argsBean");
        }

        mAnimResId = R.style.iOSDialogAnimStyle;
        lifeLog("onCreate");
        super.onCreate(savedInstanceState);
    }

    /**
     * 将 dialog 布局以及父布局的引用保存起来
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        lifeLog("onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        lifeLog("onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        lifeLog("onCreateDialog");
        Context context = requireContext();
        if (mArgsBean == null) {
            return super.onCreateDialog(savedInstanceState);
        }

        if (mArgsBean.mSimpleDialogType == SimpleDialogType.TIP) {
            return new AlertDialog.Builder(context, mStyleId)
                    .setTitle(mArgsBean.mTitle)
                    .setMessage(mArgsBean.mContent)
                    .create();
        } else if (mArgsBean.mSimpleDialogType == SimpleDialogType.WAIT) {
            mProgressDialog = new ProgressDialog(context);
            mProgressDialog.setTitle(mArgsBean.mTitle);
            mProgressDialog.setMessage(mArgsBean.mContent);
            return mProgressDialog;
        } else {
            // todo
            return super.onCreateDialog(savedInstanceState);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        lifeLog("onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        if (mAnimResId != 0) {
            Dialog dialog = getDialog();
            if (dialog != null) {
                Window window = dialog.getWindow();
                if (window != null) {
                    window.setWindowAnimations(mAnimResId);
                }
            }
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        lifeLog("onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        lifeLog("onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        lifeLog("onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        lifeLog("onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        lifeLog("onStop");
        super.onStop();
    }

    @Override
    public void dismiss() {
        lifeLog("dismiss");
        super.dismiss();
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        lifeLog("onDismiss");
        mProgressDialog = null;
        super.onDismiss(dialog);
    }

    @Override
    public void setStyle(int style, int theme) {
        mStyleId = theme;
        super.setStyle(style, theme);
    }

    private void setHideProgress() {
        try {
            Method method = TextView.class.getMethod("setVisibility", Integer.TYPE);
            Field numField = mProgressDialog.getClass().getDeclaredField("mProgress");
            numField.setAccessible(true);
            ProgressBar progressBar = (ProgressBar) numField.get(mProgressDialog);
            method.invoke(progressBar, View.GONE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void lifeLog(String msg) {
        Log.d(TAG, msg + "... context : " + getContext() + " | activity : " + getActivity() + " | dialog : " + getDialog());
    }

    static class SimpleDialogBean implements Serializable {

        public SimpleDialogType mSimpleDialogType;
        public String mTitle, mContent;
    }

    public static enum SimpleDialogType {

        TIP, WAIT, INPUT,
    }
}
