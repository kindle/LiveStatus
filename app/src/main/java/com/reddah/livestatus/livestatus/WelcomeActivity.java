package com.reddah.livestatus.livestatus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class WelcomeActivity extends Activity {

    private int countdown = 2;
    private TextView txtView;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_welcome);

        txtView = (TextView)findViewById(R.id.textView);
        txtView.setText("Welcome " + countdown +"秒后跳转");
        handler.postDelayed(runnable, 1000);
    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(countdown>0) {
                countdown--;
                txtView.setText("Welcome " + countdown +"秒后跳转");
                handler.postDelayed(this, 1000);
            }else {
                Intent intent = new Intent();
                intent.setClass(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };
}
