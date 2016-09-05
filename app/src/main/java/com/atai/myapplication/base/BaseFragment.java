package com.atai.myapplication.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atai.myapplication.utils.NetUtils;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * 文 件 名: BaseFragment
 * 创 建 人: Administrator
 * 创建日期: 2016/9/5 13:40
 * 文件描述：
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */
public abstract class BaseFragment extends Fragment {
    protected String TAG = getTAG();
    protected abstract String getTAG();

    protected View mRootView;

    protected Unbinder unbinder;

    //联网的授权字段 几乎所有的Fragment子类都有联网功能 故父类提供变量
    protected String mAuthorization;

    private CompositeSubscription mCompositeSubscription;

    public CompositeSubscription getCompositeSubscription() {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }

        return this.mCompositeSubscription;
    }

    public void addSubscription(Subscription s) {
        if (s == null) {
            return;
        }

        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }

        this.mCompositeSubscription.add(s);
    }


    protected abstract int getLayoutId();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " @" + Integer.toHexString(hashCode());
    }

    public void throwRuntimeException(Context context) {
//        throw new RuntimeException(context.toString()
//                + " must implement OnFragmentInteractionListener");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Logger.d(TAG);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d(TAG);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Logger.d(TAG);
        if (null == mRootView) {
            mRootView = inflater.inflate(getLayoutId(), null);
        }
        unbinder= ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Logger.d(TAG);
    }



    @Override
    public void onStart() {
        super.onStart();
        Logger.d(TAG);
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.d(TAG);
    }

    @Override
    public void onPause() {
        super.onPause();
        Logger.d(TAG);
    }

    @Override
    public void onStop() {
        super.onStop();
        Logger.d(TAG);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.d(TAG);
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.d(TAG);

        if (this.mCompositeSubscription != null) {

            this.mCompositeSubscription.unsubscribe();
        }

       // HuaBanApplication.getRefwatcher(getActivity()).watch(this);
    }

//    @Override
//    protected void finalize() throws Throwable {
//        super.finalize();
//        Logger.d("finalize"+TAG);
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        Logger.d(TAG);
    }

    /**
     * 异常类型判断 检查网络访问的异常 类型
     * 根据类型 弹出SnackBar提示
     *
     * @param e
     */
    protected void checkException(Throwable e) {
        NetUtils.checkHttpException(getContext(), e, mRootView);
    }

}