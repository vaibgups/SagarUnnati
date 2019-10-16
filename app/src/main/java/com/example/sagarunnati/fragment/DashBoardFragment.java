package com.example.sagarunnati.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sagarunnati.R;
import com.example.sagarunnati.adapter.DashBoardAdapter;
import com.example.sagarunnati.appliaction.MyApplication;
import com.example.sagarunnati.utility.EqualSpacingItemDecoration;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment {
    private final String TAG = MyApplication.TAG + this.getClass().getSimpleName();
    private View view;
    private Context context;

    private RecyclerView recyclerView;

    private DashBoardAdapter dashBoardAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private EqualSpacingItemDecoration equalSpacingItemDecoration;
    
    public DashBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dash_board, container, false);
        context = getContext();
        init();
        return view;
    }

    private void init() {
        recyclerView = view.findViewById(R.id.rvDashBoardDetails);
        setRecyclerViewParam(recyclerView);
        dashBoardAdapter = new DashBoardAdapter(context);
        equalSpacingItemDecoration = new EqualSpacingItemDecoration(20);
        recyclerView.addItemDecoration(equalSpacingItemDecoration);
        recyclerView.setAdapter(dashBoardAdapter);


    }

    private void setRecyclerViewParam(RecyclerView recyclerView) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 100);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(layoutManager);
    }

}
