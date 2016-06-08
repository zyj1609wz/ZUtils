package com.zyj.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zutil.app.ThreadUtil;

public class ThreadUtilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_util);

        //主线程
        findViewById( R.id.bt1 ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImage();
            }
        });

        //子线程
        findViewById( R.id.bt2 ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        loadImage();
                    }
                }).start();
            }
        });

    }

    /**
     * 加载网络图片
     */
    private void loadImage() {
        //判断是否在子线程。 子线程：继续执行  主线程：抛出异常
        ThreadUtil.assertBackgroundThread();

        try {
            //用延时3秒操作来模拟网络操作
            Thread.sleep( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
