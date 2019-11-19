package com.example.sagarunnati.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.sagarunnati.R;
import com.example.sagarunnati.adapter.ImageAdapter;
import com.example.sagarunnati.appliaction.MyApplication;
import com.example.sagarunnati.model.login.LoginResponse;
import com.example.sagarunnati.utility.SharedPreferenceData;
import com.google.gson.Gson;

public class SplashScreenActivity extends AppCompatActivity {

    private static final String TAG = MyApplication.TAG + SplashScreenActivity.class.getSimpleName();
    int SPLASH_TIME_OUT = 2000;
    private ImageAdapter adapterView;
    private ViewPager viewPager;
    private Handler handler;
    private int page = 0;
    private int delay = 5000; //milliseconds
    private SharedPreferenceData mSharedPreferenceData;
    private LoginResponse loginResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        init();
    }

    private void init() {
        mSharedPreferenceData = SharedPreferenceData.getInstance(SplashScreenActivity.this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        loginResponse = new Gson().fromJson(mSharedPreferenceData.getString
                (LoginResponse.class.getSimpleName()), LoginResponse.class);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (loginResponse != null) {
                    startActivity(new Intent(SplashScreenActivity.this, UserAfterLoginActivity.class));
                } else {
                    startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                }
                finish();
            }
        }, SPLASH_TIME_OUT);


    }
}
