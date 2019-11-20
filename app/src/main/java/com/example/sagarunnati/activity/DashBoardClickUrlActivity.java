package com.example.sagarunnati.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
import com.example.sagarunnati.mInterface.FilterDataInterface;
import com.example.sagarunnati.model.login.LoginResponse;
import com.example.sagarunnati.model.yearMonth.FinancialMonthItem;
import com.example.sagarunnati.utility.CustomActionBar;
import com.example.sagarunnati.utility.Logger;
import com.example.sagarunnati.utility.RequestParameter;
import com.example.sagarunnati.utility.SharedPreferenceData;
import com.example.sagarunnati.utility.SpinnerYearMonth;
import com.example.sagarunnati.utility.VolleyService;
import com.google.gson.Gson;

public class DashBoardClickUrlActivity extends AppCompatActivity implements
        SpinnerYearMonth.SelectedYearMonthInterFace, View.OnClickListener {
    private int loadFragAtPos;
    private CustomActionBar customActionBar;
    private RequestParameter requestParameter;
    private SharedPreferenceData mSharedPreferenceData;
    private LoginResponse loginResponse;
    private boolean isLogin = false, isFragmentFirstLoad = true;

    private View layoutYearMonthSpinner;
    private Button btnYearMonthFilter;
    private FrameLayout flDashBoardContainer;

    private Fragment fragment;

    private DailyVesselFragment dailyVesselFragment;
    private TrafficFragment trafficFragment;
    private TrafficCommoWiseFragment trafficCommoWiseFragment;
    private AvgTurnaroundTimeFragment avgTurnaroundTimeFragment;
    private AvgOutputPerShipBerthdayFragment avgOutputPerShipBerthdayFragment;
    private AnnOverAndCoastTrafficFragment annOverAndCoastTrafficFragment;
    private ProjectsUnderSagarmalaFragment projectsUnderSagarmalaFragment;
    private SagarmalaBeneficiariesFragment sagarmalaBeneficiariesFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private FilterDataInterface filterDataInterface;
    private WebView webViewDashBoardUrlLoad;
    private VolleyService volleyService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_click_url);
        Intent intent = getIntent();
        if (intent.hasExtra("FragmentLoad")) {
            loadFragAtPos = intent.getIntExtra("FragmentLoad", 0);
        }
        init();

    }

    private void fragmentPos(int loadFragAtPos) {
        switch (loadFragAtPos) {
            case 1: {
                if (isFragmentFirstLoad) {
                    dailyVesselFragment = new DailyVesselFragment();
                    fragmentLoad(dailyVesselFragment);
                } else
                    dailyVesselFragment.filterData(requestParameter);
                break;
            }
            case 2: {
                if (isFragmentFirstLoad) {
                    trafficFragment = new TrafficFragment();
                    fragmentLoad(trafficFragment);
                } else
                    trafficFragment.filterData(requestParameter);
                break;
            }
            case 3: {
                if (isFragmentFirstLoad) {
                    trafficCommoWiseFragment = new TrafficCommoWiseFragment();
                    fragmentLoad(trafficCommoWiseFragment);
                } else
                    trafficCommoWiseFragment.filterData(requestParameter);
                break;
            }
            case 4: {
                if (isFragmentFirstLoad) {
                    avgTurnaroundTimeFragment = new AvgTurnaroundTimeFragment();
                    fragmentLoad(avgTurnaroundTimeFragment);
                } else
                    avgTurnaroundTimeFragment.filterData(requestParameter);
                break;
            }
            case 5: {
                if (isFragmentFirstLoad) {
                    avgOutputPerShipBerthdayFragment = new AvgOutputPerShipBerthdayFragment();
                    fragmentLoad(avgOutputPerShipBerthdayFragment);
                } else
                    avgOutputPerShipBerthdayFragment.filterData(requestParameter);

                break;
            }
            case 6: {
                if (isFragmentFirstLoad) {
                    annOverAndCoastTrafficFragment = new AnnOverAndCoastTrafficFragment();
                    fragmentLoad(annOverAndCoastTrafficFragment);
                } else
                    annOverAndCoastTrafficFragment.filterData(requestParameter);
                break;
            }
            case 7: {
                if (isFragmentFirstLoad) {
                    projectsUnderSagarmalaFragment = new ProjectsUnderSagarmalaFragment();
                    fragmentLoad(projectsUnderSagarmalaFragment);
                } else
                    projectsUnderSagarmalaFragment.filterData(requestParameter);
                break;
            }
            case 8: {
                if (isFragmentFirstLoad) {
                    sagarmalaBeneficiariesFragment = new SagarmalaBeneficiariesFragment();
                    fragmentLoad(sagarmalaBeneficiariesFragment);
                } else
                    sagarmalaBeneficiariesFragment.filterData(requestParameter);
                break;
            }
            case 9: {
                fragment = new StatementCargoTrafFragment();
                fragmentLoad(fragment);
                break;
            }
            case 10: {
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

        if (loginResponse != null) {
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
        Logger.v("fragmentLoad", "method call");
        isFragmentFirstLoad = false;
        Bundle bundle = new Bundle();
        bundle.putSerializable(RequestParameter.class.getSimpleName(), requestParameter);
        fragment.setArguments(bundle);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.setCustomAnimations(R.anim.slide_out_up, R.anim.slide_in_up, R.anim.slide_out_up, R.anim.slide_in_up);
        fragmentTransaction.replace(R.id.flDashBoardContainer, fragment, fragment.getClass().getSimpleName())
                .commit();
    }


    @Override
    public void selectedYear(String selectedYear) {
        requestParameter.setSelect_fy(selectedYear);
    }

    @Override
    public void selectedMonth(FinancialMonthItem financialMonthItem) {
        requestParameter.setSelect_month(Integer.parseInt(financialMonthItem.getFyMonthNum()));
        requestParameter.setSelectedMonthName(financialMonthItem.getFyMonthName());
        if (isFragmentFirstLoad)
            fragmentPos(loadFragAtPos);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnYearMonthFilter: {
                Logger.v("Filter button click test request parameter object", requestParameter.toString());
                fragmentPos(loadFragAtPos);
                break;
            }
        }
    }

}
