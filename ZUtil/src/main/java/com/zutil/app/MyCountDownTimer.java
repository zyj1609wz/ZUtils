package com.zutil.app;

import android.os.CountDownTimer;

/**
 * Created by ${zyj} on 2016/6/24.
 */
public class MyCountDownTimer extends CountDownTimer {

        private OnLister onLister ;

        /**
         * 造方法MyCount()中的两个参数中，前者是倒计的时间数，后者是倒计时onTick事件响应的间隔时间，都是以毫秒为单位。
         * 例如要倒计时30秒，每秒中间间隔时间是1秒，两个参数可以这样MyCount(30000,1000)
         * @param millisInFuture
         * @param countDownInterval
         */
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval) ;
        }

        /**
         * nTick(Long m)中的代码是你倒计时开始时要做的事情，参数m是直到完成的时间
         * @param millisUntilFinished
         */
        @Override
        public void onTick(long millisUntilFinished) {
            if( onLister != null ){
                onLister.onTick( millisUntilFinished );
            }
        }

        @Override
        public void onFinish() {
            //计时器结束的时候要做的事情
            if( onLister != null ){
                onLister.onFinish();
            }
        }


        /**
         * 设置回调
         * @param onLister
         */
    public void setOnLister ( OnLister onLister ){
        this.onLister = onLister ;
    }

    /**
     * 其他：
     * 当你想取消的时候使用mc.cancel()方法就行了。
     */

    public interface OnLister{
        void onFinish() ;
        void onTick(long millisUntilFinished) ;
    }

}
