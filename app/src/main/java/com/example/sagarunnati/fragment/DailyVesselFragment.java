package com.example.sagarunnati.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sagarunnati.R;
import com.example.sagarunnati.adapter.DailyVesselFrgAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class DailyVesselFragment extends Fragment {


    private View view;
    private Context context;
    private RecyclerView rvDVFrg;
    private DailyVesselFrgAdapter dailyVesselFrgAdapter;


    public DailyVesselFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getContext();
        view = inflater.inflate(R.layout.fragment_daily_vessel, container, false);
        init();
        return view;
    }

    private void init() {
        rvDVFrg = view.findViewById(R.id.rvDVFrg);
        rvDVFrg.setHasFixedSize(true);
        rvDVFrg.setLayoutManager(new LinearLayoutManager(context));
        dailyVesselFrgAdapter = new DailyVesselFrgAdapter(context);
        rvDVFrg.setAdapter(dailyVesselFrgAdapter);

    }


}
