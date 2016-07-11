package com.zyj.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.lang.reflect.Method;

public class NotificationActivity extends AppCompatActivity {

    private String clickAction = "clickAction";
    private int notificationID = 10012;

    private NotificationManager notificationManager;
    private Notification notification;
    private NotificationCompat.Builder builder ;
    private RemoteViews remoteViews ;
    private MyBroadcastReceiver myBroadcastReceiver ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        //注册广播接收器
        myBroadcastReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(clickAction);
        registerReceiver(myBroadcastReceiver, intentFilter);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        builder = new NotificationCompat.Builder( this ) ;
        remoteViews = new RemoteViews(getPackageName(), R.layout.layout_notification);

        notification = builder.setContent( remoteViews )
                .setWhen(System.currentTimeMillis())
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setOngoing(true)
                .setContentTitle("")
                .setContentInfo("")
                .setTicker("")
                .setSmallIcon( R.mipmap.ic_launcher )
                .build();

        notification.flags = Notification.FLAG_ONGOING_EVENT; // 设置常驻 Flag

        //设置点击事件
        initClick( R.id.noti_lin1 , 1 );
        initClick( R.id.noti_lin2 , 2 );
        initClick( R.id.noti_lin3 , 3 );
        initClick( R.id.noti_lin4 , 4 );
        initClick( R.id.noti_lin5 , 5 );

        notificationManager.notify( 100 , notification );

    }

    /**
     * 点击事件初始化
     */
    public void initClick(int viewId, int requestCode) {
        Intent buttonIntent = new Intent(clickAction);
        buttonIntent.putExtra("viewId", viewId);
        PendingIntent pendIntent = PendingIntent.getBroadcast(this, requestCode, buttonIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(viewId, pendIntent);
    }


    private class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (clickAction.equals(action)) {
                int id = intent.getIntExtra("viewId", 0);
                switch (id) {
                    case R.id.noti_lin1:
                        Toast.makeText( NotificationActivity.this, "点击1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.noti_lin2:
                        collapseStatusBar();
                        Toast.makeText( NotificationActivity.this, "点击2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.noti_lin3:
                        Toast.makeText( NotificationActivity.this, "点击3", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.noti_lin4:
                        collapseStatusBar();
                        Toast.makeText( NotificationActivity.this, "点击4", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.noti_lin5:
                        collapseStatusBar();
                        Toast.makeText( NotificationActivity.this, "点击5", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }
    }

    //手动关闭状态栏
    private void collapseStatusBar() {
        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
        try {
            Object service = getSystemService("statusbar");
            Class<?> statusbarManager = Class
                    .forName("android.app.StatusBarManager");
            Method collapse = null;
            if (service != null) {
                if (currentApiVersion <= 16) {
                    collapse = statusbarManager.getMethod("collapse");
                } else {
                    collapse = statusbarManager.getMethod("collapsePanels");
                }
                collapse.setAccessible(true);
                collapse.invoke(service);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
