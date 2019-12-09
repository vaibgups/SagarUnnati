package com.example.sagarunnati.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.sagarunnati.R;
import com.example.sagarunnati.appliaction.MyApplication;
import com.example.sagarunnati.fragment.AboutUsFragment;
import com.example.sagarunnati.fragment.ContactUsFragment;
import com.example.sagarunnati.fragment.DashBoardFragment;
import com.example.sagarunnati.fragment.GalleryFragment;
import com.example.sagarunnati.fragment.HomeFragment;
import com.example.sagarunnati.mInterface.HomeScreenButtonInterface;
import com.example.sagarunnati.utility.ConnectivityReceiver;
import com.example.sagarunnati.utility.CustomActionBar;
import com.example.sagarunnati.utility.Logger;

public class MainActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener,
        HomeScreenButtonInterface {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RelativeLayout fragmentContainer;

    private CustomActionBar customActionBar;

    private Fragment fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;


    private boolean isNetworkConnected = false, isLogin = false;
    private TextView tvDefaultActionBarLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkConnection();
        init();
    }


    private boolean checkConnection() {
        isNetworkConnected = ConnectivityReceiver.isConnected();
        Logger.d(TAG, "" + isNetworkConnected);
        return isNetworkConnected;

    }

    private void init() {
        customActionBar = new CustomActionBar(MainActivity.this);
        customActionBar.setToolBarHomeHeaderName(getResources().
                getString(R.string.tv_default_action_bar_name), isLogin);

        fragmentContainer = findViewById(R.id.fragmentContainer);

        fragmentManager = getSupportFragmentManager();
        fragment = new HomeFragment();
        fragmentLoad(fragment);

    }


    @Override
    protected void onResume() {
        super.onResume();
        MyApplication.getMyApplicationInstance().setConnectivityListener(this);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        isNetworkConnected = isConnected;
        Log.d(TAG, "onNetworkConnectionChanged() returned: " + isNetworkConnected);
    }


    @Override
    public void onBackPressed() {
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        Log.d(TAG, " onBackPressed() called " + backStackEntryCount);
        if (backStackEntryCount == 1) {
            finish();
        } else {
//            super.onBackPressed();
            fragmentManager.popBackStack();
            customActionBar.setToolBarHomeHeaderName("Sagar Unnati",isLogin);
        }
    }


    @Override
    public void homeScreenButtonClick(int adapterPos) {
        switch (adapterPos) {
            case 0: {
                if (checkConnection()) {
                    fragment = new AboutUsFragment();
                    customActionBar.setToolbarHeaderName("About us", isLogin);
                    fragmentLoad(fragment);
                } else {
                    Toast.makeText(MainActivity.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case 1: {
                if (checkConnection()) {
                    fragment = new GalleryFragment();
                    customActionBar.setToolbarHeaderName("Gallery", isLogin);
                    fragmentLoad(fragment);
                } else {
                    Toast.makeText(MainActivity.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            /*case 2: {
                CustomDialogBox customDialogBox = new CustomDialogBox(MainActivity.this);
                customDialogBox.initCustomDialog();
                break;
            }*/
            case 2: {
                if (checkConnection()) {
                    fragment = new ContactUsFragment();
                    customActionBar.setToolbarHeaderName("Contact Us", isLogin);
                    fragmentLoad(fragment);
                } else {
                    Toast.makeText(MainActivity.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case 3: {
                if (checkConnection()) {
                    fragment = new DashBoardFragment();
                    customActionBar.setToolbarHeaderName("Dash Board", isLogin);
                    fragmentLoad(fragment);
                } else {
                    Toast.makeText(MainActivity.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                }
                break;

            }

          /*  case 4: {
                if (checkConnection()) {
                    CustomDialogBoxLogin customDialogBox = new CustomDialogBoxLogin(MainActivity.this);
                    customDialogBox.initCustomDialog();
                } else {
                    Toast.makeText(MainActivity.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                }
                break;
            }*/
        }
    }

    private void fragmentLoad(Fragment fragment) {
        Log.d(TAG, "fragmentLoad() called with: fragment = [" + fragment.getClass().getSimpleName() + "]");
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        fragmentTransaction.setCustomAnimations(R.anim.slide_out_up, R.anim.slide_in_up);
        fragmentTransaction.setCustomAnimations(R.anim.slide_out_up, R.anim.slide_in_up, R.anim.slide_out_up, R.anim.slide_in_up);
        fragmentTransaction.replace(R.id.fragmentContainer, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(null)
                .commit();
    }


}
