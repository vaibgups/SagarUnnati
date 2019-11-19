package com.example.sagarunnati.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;

import com.android.volley.VolleyError;
import com.example.sagarunnati.R;
import com.example.sagarunnati.fragment.AnnOverAndCoastTrafficFragment;
import com.example.sagarunnati.fragment.AvgOutputPerShipBerthdayFragment;
import com.example.sagarunnati.fragment.AvgTurnaroundTimeFragment;
import com.example.sagarunnati.fragment.DailyVesselFragment;
import com.example.sagarunnati.fragment.DirectorateGeneralShipFragment;
import com.example.sagarunnati.fragment.ProjectsUnderSagarmalaFragment;
import com.example.sagarunnati.fragment.SagarmalaBeneficiariesFragment;
import com.example.sagarunnati.fragment.StatementCargoTrafFragment;
import com.example.sagarunnati.fragment.TrafficCommoWiseFragment;
import com.example.sagarunnati.fragment.TrafficFragment;
import com.example.sagarunnati.model.login.LoginResponse;
import com.example.sagarunnati.model.yearMonth.FinancialMonthItem;
import com.example.sagarunnati.utility.CustomActionBar;
import com.example.sagarunnati.utility.Logger;
import com.example.sagarunnati.utility.RequestParameter;
import com.example.sagarunnati.utility.SharedPreferenceData;
import com.example.sagarunnati.utility.SpinnerYearMonth;
import com.example.sagarunnati.utility.VolleyService;
import com.google.gson.Gson;

import java.util.List;

public class DashBoardClickUrlActivity extends AppCompatActivity implements
        SpinnerYearMonth.SelectedYearMonthInterFace, View.OnClickListener
{
    private int loadFragAtPos;
    private CustomActionBar customActionBar;
    private RequestParameter requestParameter;
    private SharedPreferenceData mSharedPreferenceData;
    private LoginResponse loginResponse;
    private boolean isLogin = false;

    private View layoutYearMonthSpinner;
    private Button btnYearMonthFilter;
    private FrameLayout flDashBoardContainer;

    private Fragment fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;


    private WebView webViewDashBoardUrlLoad;
    private VolleyService volleyService;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_click_url);
        Intent intent = getIntent();
        if (intent.hasExtra("FragmentLoad")){
            loadFragAtPos = intent.getIntExtra("FragmentLoad",0);
        }
        init();
        fragmentPos(loadFragAtPos);
    }

    private void fragmentPos(int loadFragAtPos) {
        switch (loadFragAtPos){
            case 1:{
                fragment = new DailyVesselFragment();
                Logger.v("DailyVesselFragment fragment load test request parameter object", requestParameter.toString());
                fragmentLoad(fragment);
                break;
            }
            case 2:{
                fragment = new TrafficFragment();
                fragmentLoad(fragment);
                break;
            }
            case 3:{
                fragment = new TrafficCommoWiseFragment();
                fragmentLoad(fragment);
                break;
            }
            case 4:{
                fragment = new AvgTurnaroundTimeFragment();
                fragmentLoad(fragment);
                break;
            }
            case 5:{
                fragment = new AvgOutputPerShipBerthdayFragment();
                fragmentLoad(fragment);
                break;
            }
            case 6:{
                fragment = new AnnOverAndCoastTrafficFragment();
                fragmentLoad(fragment);
                break;
            }
            case 7:{
                fragment = new ProjectsUnderSagarmalaFragment();
                fragmentLoad(fragment);
                break;
            }
            case 8:{
                fragment = new SagarmalaBeneficiariesFragment();
                fragmentLoad(fragment);
                break;
            }
            case 9:{
                fragment = new StatementCargoTrafFragment();
                fragmentLoad(fragment);
                break;
            }
            case 10:{
                fragment = new DirectorateGeneralShipFragment();
                fragmentLoad(fragment);
                break;
            }
        }
    }

    private void init() {
        customActionBar = new CustomActionBar(DashBoardClickUrlActivity.this);

        requestParameter = new RequestParameter();
        mSharedPreferenceData = SharedPreferenceData.getInstance(DashBoardClickUrlActivity.this);

        loginResponse = new Gson().fromJson(mSharedPreferenceData.
                getString(LoginResponse.class.getSimpleName()), LoginResponse.class);
        layoutYearMonthSpinner = findViewById(R.id.layoutYearMonthSpinner);

        if (loginResponse != null){
            requestParameter.setAccessToken(loginResponse.getToken());
            layoutYearMonthSpinner.setVisibility(View.VISIBLE);
            new SpinnerYearMonth(DashBoardClickUrlActivity.this, requestParameter);
            isLogin = true;
        }

        customActionBar.setToolbarHeaderName("Details Load", isLogin);

        btnYearMonthFilter = findViewById(R.id.btnYearMonthFilter);
        btnYearMonthFilter.setOnClickListener(this);
        flDashBoardContainer = findViewById(R.id.flDashBoardContainer);
        fragmentManager = getSupportFragmentManager();



    }


    private void fragmentLoad(Fragment fragment) {
        Logger.v("fragmentLoad","method call");
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.setCustomAnimations(R.anim.slide_out_up, R.anim.slide_in_up,R.anim.slide_out_up, R.anim.slide_in_up);
        fragmentTransaction.replace(R.id.flDashBoardContainer, fragment, fragment.getClass().getSimpleName())
                .commit();
    }


    @Override
    public void selectedYear(String selectedYear) {
        requestParameter.setFinancialYear(selectedYear);
    }

    @Override
    public void selectedMonth(int selectedMonth, List<FinancialMonthItem> financialMonthItemList) {
        FinancialMonthItem monthItem = financialMonthItemList.get(selectedMonth);
        requestParameter.setFy_month(Integer.parseInt(monthItem.getFyMonthNum()));
        requestParameter.setSelectedMonth(monthItem.getFyMonthName());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnYearMonthFilter: {
                Logger.v("Filter button click test request parameter object", requestParameter.toString());
//                fragmentPos(loadFragAtPos);
                break;
            }
        }
    }
}
