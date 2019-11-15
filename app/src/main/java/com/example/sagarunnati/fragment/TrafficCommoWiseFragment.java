package com.example.sagarunnati.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sagarunnati.R;
import com.example.sagarunnati.adapter.TrafficCWFrgAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrafficCommoWiseFragment extends Fragment {


    private Context context;
    private View view;
    private RecyclerView rvTCWFrg;
    private TrafficCWFrgAdapter trafficCWFrgAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getContext();
        view = inflater.inflate(R.layout.fragment_traffic_commo_wise, container, false);
        init();
        return view;
    }

    private void init() {
        rvTCWFrg = view.findViewById(R.id.rvTCWFrg);
        rvTCWFrg.setHasFixedSize(true);
        rvTCWFrg.setLayoutManager(new LinearLayoutManager(context));
        trafficCWFrgAdapter = new TrafficCWFrgAdapter(context);
        rvTCWFrg.setAdapter(trafficCWFrgAdapter);

    }

}
