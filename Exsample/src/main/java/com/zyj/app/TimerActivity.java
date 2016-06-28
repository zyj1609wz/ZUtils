package com.zyj.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zutil.app.MyCountDownTimer;

public class TimerActivity extends AppCompatActivity {

    private Button button1 ;
    private Button button2 ;
    private MyCountDownTimer myCountDownTimer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        button1 = (Button) findViewById( R.id.bt1 );

        button2 = (Button) findViewById( R.id.bt2 );

        myCountDownTimer = new MyCountDownTimer( 8000 ,  1000 ) ;
        myCountDownTimer.setOnLister(new MyCountDownTimer.OnLister() {
            @Override
            public void onFinish() {
                Toast.makeText(TimerActivity.this, "完成了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTick(long millisUntilFinished) {
                button1.setText( "" + ( millisUntilFinished / 1000)  );
            }
        });

        //暂停
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
            }
        });

        //开始
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                myCountDownTimer.start() ;
        }});
    }
}
