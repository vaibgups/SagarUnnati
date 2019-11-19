package com.example.sagarunnati.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sagarunnati.R;
import com.example.sagarunnati.fragment.AboutUsFragment;
import com.example.sagarunnati.fragment.ContactUsFragment;
import com.example.sagarunnati.fragment.DashBoardFragment;
import com.example.sagarunnati.fragment.GalleryFragment;
import com.example.sagarunnati.fragment.HomeFragment;
import com.example.sagarunnati.mInterface.HomeScreenButtonInterface;
import com.example.sagarunnati.utility.CustomActionBar;
import com.example.sagarunnati.utility.Logger;
import com.example.sagarunnati.utility.SharedPreferenceData;

public class UserAfterLoginActivity extends AppCompatActivity implements HomeScreenButtonInterface,
        View.OnClickListener {


    private static final String TAG = UserAfterLoginActivity.class.getSimpleName();

    private LinearLayout llBtmPerformance, llBtmGallery, llBtmContactUs, llBtmAboutUs;
    private FrameLayout fragmentContainer;
    private SharedPreferenceData mSharedPreferenceData;

    private CustomActionBar customActionBar;

    private Fragment fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private boolean isLogin = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_after_login);
        init();
    }

    private void init() {
        mSharedPreferenceData = SharedPreferenceData.getInstance(UserAfterLoginActivity.this);
        customActionBar = new CustomActionBar(UserAfterLoginActivity.this);
        llBtmPerformance = findViewById(R.id.llBtmPerformance);
        llBtmPerformance.setOnClickListener(this);
        llBtmGallery = findViewById(R.id.llBtmGallery);
        llBtmGallery.setOnClickListener(this);
        llBtmContactUs = findViewById(R.id.llBtmContactUs);
        llBtmContactUs.setOnClickListener(this);
        llBtmAboutUs = findViewById(R.id.llBtmAboutUs);
        llBtmAboutUs.setOnClickListener(this);
        customActionBar.setToolBarHomeHeaderName(getResources().
                getString(R.string.tv_default_action_bar_name), isLogin);


        fragmentContainer = findViewById(R.id.fragmentContainer);
        fragmentManager = getSupportFragmentManager();
        fragment = new DashBoardFragment();
        fragmentLoad(fragment);

    }

    private void fragmentLoad(Fragment fragment) {
        Logger.v("fragmentLoad",fragment.getClass().getSimpleName());
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        fragmentTransaction.setCustomAnimations(R.anim.slide_out_up, R.anim.slide_in_up);
        fragmentTransaction.setCustomAnimations(R.anim.slide_out_up, R.anim.slide_in_up, R.anim.slide_out_up, R.anim.slide_in_up);
        fragmentTransaction.replace(R.id.fragmentContainer, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        Logger.v(TAG, " onBackPressed() called " + backStackEntryCount);
        if (backStackEntryCount == 1) {
            finish();
        } else {
            fragmentManager.popBackStack();
            customActionBar.setToolBarHomeHeaderName("Sagar Unnati", isLogin);
        }
    }

    @Override
    public void homeScreenButtonClick(int adapterPos) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.llBtmPerformance:{
                fragment = new DashBoardFragment();
                customActionBar.setToolBarHomeHeaderName("Sagar Unnati", isLogin);
                break;
            }
            case R.id.llBtmGallery:{
                fragment = new GalleryFragment();
                customActionBar.setToolbarHeaderName("Gallery", isLogin);
                break;
            }
            case R.id.llBtmContactUs:{
                fragment = new ContactUsFragment();
                customActionBar.setToolbarHeaderName("Contact Us", isLogin);
                break;
            }
            case R.id.llBtmAboutUs:{
                fragment = new AboutUsFragment();
                customActionBar.setToolbarHeaderName("About us", isLogin);
                break;
            }

        }
        fragmentLoad(fragment);
    }
}
