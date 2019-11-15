package com.example.sagarunnati.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.FrameLayout;

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
import com.example.sagarunnati.utility.CustomActionBar;
import com.example.sagarunnati.utility.Logger;
import com.example.sagarunnati.utility.RequestParameter;
import com.example.sagarunnati.utility.SpinnerYearMonth;

public class DashBoardClickUrlActivity extends AppCompatActivity implements SpinnerYearMonth.SelectedYearMonthInterFace {

    private CustomActionBar customActionBar;
    private WebView webViewDashBoardUrlLoad;
    private RequestParameter requestParameter;
    private FrameLayout flDashBoardContainer;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private int loadFragAtPos;

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
//        loadUrl();
    }

    private void fragmentPos(int loadFragAtPos) {
        switch (loadFragAtPos){
            case 1:{
                fragment = new DailyVesselFragment();
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
                fragment = new ProjectsUnderSagarmalaFragment();
                fragmentLoad(fragment);
                break;
            }
            case 6:{
                fragment = new SagarmalaBeneficiariesFragment();
                fragmentLoad(fragment);
                break;
            }
            case 7:{
                fragment = new StatementCargoTrafFragment();
                fragmentLoad(fragment);
                break;
            }
            case 8:{
                fragment = new DirectorateGeneralShipFragment();
                fragmentLoad(fragment);
                break;
            }
            case 9:{
                fragment = new AvgOutputPerShipBerthdayFragment();
                fragmentLoad(fragment);
                break;
            }
            case 10:{
                fragment = new AnnOverAndCoastTrafficFragment();
                fragmentLoad(fragment);
                break;
            }
        }
    }

    private void init() {

        flDashBoardContainer = findViewById(R.id.flDashBoardContainer);
        fragmentManager = getSupportFragmentManager();
        new SpinnerYearMonth(DashBoardClickUrlActivity.this, requestParameter);
        customActionBar = new CustomActionBar(DashBoardClickUrlActivity.this);
        customActionBar.setToolbarHeaderName("Details Load");
    }


    @Override
    public void selectedYear(String selectedYear) {

    }

    @Override
    public void selectedMonth(int selectedMonth, String selectedMonthString) {

    }

    private void fragmentLoad(Fragment fragment) {
        Logger.v("fragmentLoad","method call");
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.setCustomAnimations(R.anim.slide_out_up, R.anim.slide_in_up,R.anim.slide_out_up, R.anim.slide_in_up);
        fragmentTransaction.replace(R.id.flDashBoardContainer, fragment, fragment.getClass().getSimpleName())
                .commit();
    }
}
