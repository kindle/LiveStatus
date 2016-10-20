package com.reddah.livestatus.livestatus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends Activity {

    private int countdown = 5;
    private TextView tv_countdown;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_welcome);

        tv_countdown = (TextView)findViewById(R.id.tv_countdown);
        tv_countdown.setText("Welcome " + countdown +"秒后跳转");
        handler.postDelayed(runnable, 1000);

        final Button button = (Button) findViewById(R.id.bt_jump);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                countdown = 0;
            }
        });

    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(countdown>0) {
                countdown--;
                tv_countdown.setText("Welcome " + countdown +"秒后跳转");
                handler.postDelayed(this, 1000);
            }else {
                jump();
            }
        }
    };

    private void jump(){
        Intent intent = new Intent();
        intent.setClass(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
