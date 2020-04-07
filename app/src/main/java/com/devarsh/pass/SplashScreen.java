package com.devarsh.pass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread th = new Thread(){
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                    startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        th.start();
    }
}
