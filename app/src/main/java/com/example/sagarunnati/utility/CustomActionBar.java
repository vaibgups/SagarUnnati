package com.example.sagarunnati.utility;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sagarunnati.R;
import com.example.sagarunnati.activity.MainActivity;
import com.example.sagarunnati.activity.UserAfterLoginActivity;

public class CustomActionBar implements View.OnClickListener {

    private Context context;
    private View view;
    private Activity activity;

    private ImageView ivDefaultActionBarHome, ivDefaultActionBarBack, ivDefaultActionBarLogin;
    private TextView tvDefaultActionBar, tvDefaultActionBarLogout;
    private SharedPreferenceData mSharedPreferenceData;
    public CustomActionBar(Context context) {
        this.context = context;
        this.activity = (Activity) context;
        mSharedPreferenceData = SharedPreferenceData.getInstance(context);
        myFindViewById();
    }

    private void myFindViewById() {

        tvDefaultActionBar = ((Activity) context).findViewById(R.id.tvDefaultActionBar);
        tvDefaultActionBar.setText("SagarUnnati");

        ivDefaultActionBarBack = ((Activity) context).findViewById(R.id.ivDefaultActionBarBack);
        ivDefaultActionBarBack.setOnClickListener(this);
        ivDefaultActionBarBack.setVisibility(View.INVISIBLE);
        ivDefaultActionBarHome = ((Activity) context).findViewById(R.id.ivDefaultActionBarHome);
        ivDefaultActionBarHome.setOnClickListener(this);
        tvDefaultActionBarLogout = ((Activity) context).findViewById(R.id.tvDefaultActionBarLogout);
        ivDefaultActionBarLogin = ((Activity) context).findViewById(R.id.ivDefaultActionBarLogin);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.ivDefaultActionBarBack: {
                activity.onBackPressed();
                break;
            }
            case R.id.ivDefaultActionBarHome: {
                if (activity instanceof MainActivity) {
                    activity.startActivity(new Intent(context, MainActivity.class));
                }else if (activity instanceof UserAfterLoginActivity){
                    activity.startActivity(new Intent(context, UserAfterLoginActivity.class));
                }
                activity.finish();
                break;
            }
            case R.id.tvDefaultActionBarLogout: {
               mSharedPreferenceData.clear();
               context.startActivity(new Intent(context,MainActivity.class));
               activity.finish();
                break;
            }
            case R.id.ivDefaultActionBarLogin: {
                CustomDialogBoxLogin customDialogBox = new CustomDialogBoxLogin(context);
                customDialogBox.initCustomDialog();
                break;
            }
        }
    }

    public void setToolBarHomeHeaderName(String toolBarHomeHeaderName, boolean isLogin){
        ivDefaultActionBarBack.setVisibility(View.GONE);
        ivDefaultActionBarHome.setVisibility(View.GONE);
        tvDefaultActionBar.setText(toolBarHomeHeaderName);
        if (isLogin){
            ivDefaultActionBarLogin.setVisibility(View.GONE);
            tvDefaultActionBarLogout.setVisibility(View.VISIBLE);
            tvDefaultActionBarLogout.setOnClickListener(this);
        } else {
            ivDefaultActionBarLogin.setVisibility(View.VISIBLE);
            ivDefaultActionBarLogin.setOnClickListener(this);
        }
    }

    public void setToolbarHeaderName(String toolbarHeaderName, boolean isLogin){
        tvDefaultActionBar.setText(toolbarHeaderName);
        ivDefaultActionBarBack.setVisibility(View.VISIBLE);
        ivDefaultActionBarHome.setVisibility(View.VISIBLE);
        if (isLogin){
            ivDefaultActionBarLogin.setVisibility(View.GONE);
            tvDefaultActionBarLogout.setVisibility(View.VISIBLE);
            tvDefaultActionBarLogout.setOnClickListener(this);
        } else {
            ivDefaultActionBarLogin.setVisibility(View.VISIBLE);
            ivDefaultActionBarLogin.setOnClickListener(this);
        }
//        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) tvDefaultActionBar.getLayoutParams();
//        lp.addRule(RelativeLayout.RIGHT_OF,R.id.ivDefaultActionBarBack);
//        tvDefaultActionBar.setLayoutParams(lp);
    }


}
