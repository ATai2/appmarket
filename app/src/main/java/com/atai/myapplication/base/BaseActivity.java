package com.atai.myapplication.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.atai.myapplication.utils.NetUtils;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * 文 件 名: BaseActivity
 * 创 建 人: Administrator
 * 创建日期: 2016/9/5 13:28
 * 文件描述：
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */
public abstract class BaseActivity extends FragmentActivity {

        protected String TAG = getTAG();
        protected abstract int getLayoutId();
        protected abstract String getTAG();
        protected Context mContext;


        @Override
        public String toString() {
            return getClass().getSimpleName() + " @" + Integer.toHexString(hashCode());
        }

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

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            /**
             * http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/1122/3712.html
             * 在BaseActivity.java里：我们通过判断当前sdk_int大于4.4(kitkat),则通过代码的形式设置status bar为透明
             * (这里其实可以通过values-v19 的sytle.xml里设置windowTranslucentStatus属性为true来进行设置，但是在某些手机会不起效，所以采用代码的形式进行设置)。
             * 还需要注意的是我们这里的AppCompatAcitivity是android.support.v7.app.AppCompatActivity支持包中的AppCompatAcitivity,也是为了在低版本的android系统中兼容toolbar。
             */
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                if (isTranslucentStatusBar()) {
                    Window window = getWindow();
                    // Translucent status bar
                    window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                }
            }
            setContentView(getLayoutId());
            ButterKnife.bind(this);
            mContext = this;
            getNecessaryData();
            initResAndListener();
            Logger.d(TAG);

        }

        //空方法 规定子类 初始化监听器 和定义显示资源 的步骤
        protected void initResAndListener() {

        }

        protected void getNecessaryData() {
           //用户验证相关方法
        }

        //是否statusBar 状态栏为透明 的方法 默认为真
        protected boolean isTranslucentStatusBar() {
            return true;
        }

        protected String getAuthorizations(boolean isLogin) {
//            String temp = " ";
//            if (isLogin) {
//                return SPUtils.get(mContext, Constant.TOKENTYPE, temp)
//                        + temp
//                        + SPUtils.get(mContext, Constant.TOKENACCESS, temp);
//            }
//            return Base64.mClientInto;
            return "";
        }


        @Override
        protected void onStart() {
            super.onStart();
            Logger.d(TAG);
        }

        @Override
        protected void onResume() {
            super.onResume();
            Logger.d(TAG);
        }

        @Override
        protected void onStop() {
            super.onStop();
            Logger.d(TAG);
        }


        @Override
        protected void onDestroy() {
            super.onDestroy();
            Logger.d(TAG);
            if (this.mCompositeSubscription != null) {

                this.mCompositeSubscription.unsubscribe();
            }
            //不知道有没有用
//        if (isFinishing()) {
//            fixInputMethodManagerLeak(this);
//        }
        }

//    @Override
//    protected void finalize() throws Throwable {
//        super.finalize();
//        Logger.d("finalize"+TAG);
//    }

        @Override
        protected void onRestart() {
            super.onRestart();
            Logger.d(TAG);
        }

        @Override
        protected void onPause() {
            super.onPause();
            Logger.d(TAG);
        }

        protected void checkException(Throwable e,View mRootView) {
            NetUtils.checkHttpException(mContext, e, mRootView);
        }
    }