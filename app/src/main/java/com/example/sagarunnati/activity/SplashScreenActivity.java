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

public class SplashScreenActivity extends AppCompatActivity {

    private static final String TAG = MyApplication.TAG + SplashScreenActivity.class.getSimpleName();
    private ImageAdapter adapterView;
    private ViewPager viewPager;
    private Handler handler;
    private int page = 0;
    private int delay = 5000; //milliseconds

    int SPLASH_TIME_OUT = 2000;


   /* Runnable runnable = new Runnable() {
        public void run() {
            if (adapterView.getCount() == page) {
                page = 0;
            } else {
                page++;
            }
            viewPager.setCurrentItem(page, true);
            handler.postDelayed(this, delay);
        }
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this,MainActivity.class));
                finish();
            }
        }, SPLASH_TIME_OUT);
//        init();

    }


/*
    private void init() {
        handler = new Handler();
        viewPager = findViewById(R.id.viewpager_banner);
        adapterView = new ImageAdapter(SplashScreenActivity.this,true);
        viewPager.setAdapter(adapterView);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                page = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == 2) {

//                    startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
//                    finish();
                }

            }
        });

    }
*/

    @Override
    protected void onResume() {
        super.onResume();
//        handler.postDelayed(runnable, delay);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        handler.removeCallbacks(runnable);
    }
}
