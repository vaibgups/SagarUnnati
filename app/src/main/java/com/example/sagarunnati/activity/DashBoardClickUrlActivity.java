package com.example.sagarunnati.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.sagarunnati.R;
import com.example.sagarunnati.utility.CustomActionBar;

public class DashBoardClickUrlActivity extends AppCompatActivity {

    private CustomActionBar customActionBar;
    private WebView webViewDashBoardUrlLoad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_click_url);
        init();
        loadUrl();
    }

    private void init() {
        customActionBar = new CustomActionBar(DashBoardClickUrlActivity.this);
        webViewDashBoardUrlLoad = findViewById(R.id.webViewDashBoardUrlLoad);
        customActionBar.setToolbarHeaderName("Details Load");
    }

    private void loadUrl() {
        webViewDashBoardUrlLoad.getSettings().setJavaScriptEnabled(true);
        webViewDashBoardUrlLoad.getSettings().setSupportZoom(true);
        webViewDashBoardUrlLoad.getSettings().setBuiltInZoomControls(true);
        webViewDashBoardUrlLoad.getSettings().setDisplayZoomControls(false);
        webViewDashBoardUrlLoad.loadUrl("http://shipmin.dashboard.nic.in/daily_vessel_position.html");
    }
}
