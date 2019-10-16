package com.example.sagarunnati.utility;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.sagarunnati.R;
import com.example.sagarunnati.activity.MainActivity;
import com.example.sagarunnati.activity.SplashScreenActivity;

public class CustomActionBar implements View.OnClickListener {

    private Context context;
    private View view;
    private Activity activity;

    private ImageView ivDefaultActionBarHome, ivDefaultActionBarBack;
    private TextView tvDefaultActionBar;

    public CustomActionBar(Context context) {
        this.context = context;
        this.activity = (Activity) context;
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
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.ivDefaultActionBarBack: {
                activity.onBackPressed();
                break;
            }
            case R.id.ivDefaultActionBarHome: {
                activity.startActivity(new Intent(context, MainActivity.class));
                activity.finish();
                break;
            }
        }
    }

    public void setToolbarHeaderName(String toolbarHeaderName){
        tvDefaultActionBar.setText(toolbarHeaderName);
        ivDefaultActionBarBack.setVisibility(View.VISIBLE);
        ivDefaultActionBarHome.setVisibility(View.VISIBLE);
//        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) tvDefaultActionBar.getLayoutParams();
//        lp.addRule(RelativeLayout.RIGHT_OF,R.id.ivDefaultActionBarBack);
//        tvDefaultActionBar.setLayoutParams(lp);
    }

    public void setToolBarHomeHeaderName(String toolBarHomeHeaderName){
        ivDefaultActionBarBack.setVisibility(View.GONE);
        ivDefaultActionBarHome.setVisibility(View.GONE);
        tvDefaultActionBar.setText(toolBarHomeHeaderName);
//        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) tvDefaultActionBar.getLayoutParams();
//        lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//        tvDefaultActionBar.setLayoutParams(lp);

    }
}
