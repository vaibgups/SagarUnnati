package com.example.sagarunnati.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.sagarunnati.R;
import com.example.sagarunnati.utility.CustomActionBar;
import com.example.sagarunnati.utility.RequestParameter;
import com.example.sagarunnati.utility.SpinnerYearMonth;

public class DashBoardClickUrlActivity extends AppCompatActivity implements SpinnerYearMonth.SelectedYearMonthInterFace {

    private CustomActionBar customActionBar;
    private WebView webViewDashBoardUrlLoad;
    private RequestParameter requestParameter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_click_url);
        init();
        loadUrl();
    }

    private void init() {

        new SpinnerYearMonth(DashBoardClickUrlActivity.this, requestParameter);
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

    @Override
    public void selectedYear(String selectedYear) {

    }

    @Override
    public void selectedMonth(int selectedMonth, String selectedMonthString) {

    }
}
