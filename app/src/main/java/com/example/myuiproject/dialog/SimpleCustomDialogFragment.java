package com.example.myuiproject.dialog;

import androidx.fragment.app.DialogFragment;

public class SimpleCustomDialogFragment extends DialogFragment {

//    private static final String TAG = "SimpleDialogFragment";
//    private int mStyleId;
//    private int mAnimResId;
//    private SimpleDialogFragment.SimpleDialogBean mArgsBean;
//    private SimpleDialogFragment.SimpleDialogType mSimpleDialogType;
//
//
//    public static SimpleCustomDialogFragment newInstance(SimpleDialogFragment.SimpleDialogType simpleDialogType, String title, String content) {
//        SimpleDialogFragment.SimpleDialogBean bean = new SimpleDialogFragment.SimpleDialogBean();
//        bean.mTitle = title;
//        bean.mContent = content;
//        bean.mSimpleDialogType = simpleDialogType;
//        SimpleDialogFragment fragment = new SimpleDialogFragment();
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("argsBean", bean);
//        fragment.setArguments(bundle);
//        return fragment;
//    }
//
//    public static SimpleDialogFragment newInstance(SimpleDialogFragment.SimpleDialogBean bean) {
//        SimpleDialogFragment fragment = new SimpleDialogFragment();
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("argsBean", bean);
//        fragment.setArguments(bundle);
//        return fragment;
//    }
//
//    public void setAnim(int animResId) {
//        this.mAnimResId = animResId;
//    }
//
//    @Override
//    public void onAttach(@NonNull Context context) {
//        lifeLog("onAttach");
//        super.onAttach(context);
//    }
//
//    /**
//     * parentId：因不可抗力，诸如横竖屏切换、分屏、折叠屏切换等可能造成 DialogFragment 重启，
//     * 为保证重启后功能正常运行，因此需要保存自己爹（BaseDialog）的id，方便重新绑定到BaseDialog
//     */
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        Bundle arguments = getArguments();
//        if (arguments != null) {
//            mArgsBean = (SimpleDialogFragment.SimpleDialogBean) arguments.getSerializable("argsBean");
//        }
//
//        mAnimResId = R.style.iOSDialogAnimStyle;
//        lifeLog("onCreate");
//        super.onCreate(savedInstanceState);
//    }
//
//    /**
//     * 将 dialog 布局以及父布局的引用保存起来
//     */
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        lifeLog("onSaveInstanceState");
//        super.onSaveInstanceState(outState);
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        lifeLog("onCreateView");
//        return super.onCreateView(inflater, container, savedInstanceState);
//    }
//
//    @NonNull
//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        lifeLog("onCreateDialog");
//        Context context = requireContext();
//        String title = "";
//        String content = "";
//        if (mArgsBean != null) {
//            title = mArgsBean.mTitle;
//            content = mArgsBean.mContent;
//        }
//
//
//        if (mSimpleDialogType == SimpleDialogFragment.SimpleDialogType.TIP) {
//            return new AlertDialog.Builder(context, mStyleId)
//                    .setTitle(title)
//                    .setMessage(content)
//                    .create();
//        } else if (mSimpleDialogType == SimpleDialogFragment.SimpleDialogType.WAIT) {
//            ProgressDialog progressDialog = new ProgressDialog(context);
//            progressDialog.setTitle(title);
//            return progressDialog;
//        } else {
//            // todo
//            return super.onCreateDialog(savedInstanceState);
//        }
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        lifeLog("onActivityCreated");
//        super.onActivityCreated(savedInstanceState);
//        if (mAnimResId != 0) {
//            Dialog dialog = getDialog();
//            if (dialog != null) {
//                Window window = dialog.getWindow();
//                if (window != null) {
//                    window.setWindowAnimations(mAnimResId);
//                }
//            }
//        }
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        lifeLog("onViewCreated");
//        super.onViewCreated(view, savedInstanceState);
//    }
//
//    @Override
//    public void onStart() {
//        lifeLog("onStart");
//        super.onStart();
//    }
//
//    @Override
//    public void onResume() {
//        lifeLog("onResume");
//        super.onResume();
//    }
//
//    @Override
//    public void onPause() {
//        lifeLog("onPause");
//        super.onPause();
//    }
//
//    @Override
//    public void onStop() {
//        lifeLog("onStop");
//        super.onStop();
//    }
//
//    @Override
//    public void dismiss() {
//        lifeLog("dismiss");
//        super.dismiss();
//    }
//
//    @Override
//    public void onDismiss(@NonNull DialogInterface dialog) {
//        lifeLog("onDismiss");
//        super.onDismiss(dialog);
//    }
//
//    @Override
//    public void setStyle(int style, int theme) {
//        mStyleId = theme;
//        super.setStyle(style, theme);
//    }
//
//    private void lifeLog(String msg) {
//        Log.d(TAG, msg + "... context : " + getContext() + " | activity : " + getActivity() + " | dialog : " + getDialog());
//    }
//
//    static class SimpleDialogBean implements Serializable {
//
//        public SimpleDialogFragment.SimpleDialogType mSimpleDialogType;
//        public String mTitle, mContent;
//    }
//
//    public static enum SimpleDialogType {
//
//        TIP, WAIT, INPUT,
//    }
}
