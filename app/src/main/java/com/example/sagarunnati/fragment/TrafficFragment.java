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
import com.example.sagarunnati.adapter.TrafficFrgAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrafficFragment extends Fragment {


    private View view;
    private Context context;
    private RecyclerView rvTrafficFrg;
    private TrafficFrgAdapter trafficFrgAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getContext();
        view = inflater.inflate(R.layout.fragment_traffic, container, false);
        init();
        return view;
    }


    private void init() {
        rvTrafficFrg = view.findViewById(R.id.rvTrafficFrg);
        rvTrafficFrg.setHasFixedSize(true);
        rvTrafficFrg.setLayoutManager(new LinearLayoutManager(context));
        trafficFrgAdapter = new TrafficFrgAdapter(context);
        rvTrafficFrg.setAdapter(trafficFrgAdapter);

    }

}
