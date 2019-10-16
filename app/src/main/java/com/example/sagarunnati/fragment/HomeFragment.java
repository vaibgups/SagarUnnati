package com.example.sagarunnati.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sagarunnati.R;

import com.example.sagarunnati.adapter.HomeButtonAdapter;
import com.example.sagarunnati.adapter.ImageAdapter;
import com.example.sagarunnati.appliaction.MyApplication;
import com.example.sagarunnati.utility.EqualSpacingItemDecoration;
import com.rd.PageIndicatorView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private final String TAG = MyApplication.TAG + HomeFragment.class.getSimpleName();

    private RecyclerView rcvHomeScreenButton;
    private RecyclerView.LayoutManager layoutManager;
    private HomeButtonAdapter homeButtonAdapter;
    private EqualSpacingItemDecoration equalSpacingItemDecoration;

    private View view;
    private Context context;

    private ImageAdapter adapterView;
    private ViewPager viewPager;
    private Handler handler;
    private int page = 0;
    private int delay = 5000; //milliseconds

    Runnable runnable = new Runnable() {
        public void run() {
            if (adapterView.getCount() == page) {
                page = 0;
            } else {
                page++;
            }
            viewPager.setCurrentItem(page, true);
            handler.postDelayed(this, delay);
        }
    };
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        context = getActivity();
        init();
        return view;
    }

    private void init() {

        rcvHomeScreenButton = view.findViewById(R.id.rcvHomeScreenButton);
        setRecyclerViewParam(rcvHomeScreenButton);
        homeButtonAdapter = new HomeButtonAdapter(context);
        equalSpacingItemDecoration = new EqualSpacingItemDecoration(20);
        rcvHomeScreenButton.addItemDecoration(equalSpacingItemDecoration);
        rcvHomeScreenButton.setAdapter(homeButtonAdapter);


        handler = new Handler();
        viewPager = view.findViewById(R.id.viewpager_banner);
        adapterView = new ImageAdapter(context);
        viewPager.setAdapter(adapterView);

        PageIndicatorView pageIndicatorView = (PageIndicatorView) view.findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setUnselectedColor(Color.BLACK);
        pageIndicatorView.setViewPager(viewPager);

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

            }
        });
    }

    private void setRecyclerViewParam(RecyclerView recyclerView) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 100);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(layoutManager);
    }





    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable, delay);
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(runnable);
    }






}
