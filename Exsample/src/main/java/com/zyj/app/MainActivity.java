package com.zyj.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById( R.id.threadUtil ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( MainActivity.this , ThreadUtilActivity.class ));
            }
        });

        findViewById( R.id.time ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( MainActivity.this , TimerActivity.class ));
            }
        });

        findViewById( R.id.tab ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( MainActivity.this , TabActivity.class ));
            }
        });

        findViewById( R.id.notification ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( MainActivity.this , NotificationActivity.class ));
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        boolean tag = intent.getBooleanExtra( "tag" , false ) ;
        if ( tag ){
            Toast.makeText(MainActivity.this, "点击通知进来的", Toast.LENGTH_SHORT).show();
        }

    }
}
