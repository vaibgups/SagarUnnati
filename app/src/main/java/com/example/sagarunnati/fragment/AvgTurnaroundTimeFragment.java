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
import com.example.sagarunnati.adapter.AvgTurnaroundTimeFrgAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AvgTurnaroundTimeFragment extends Fragment {


    private View view;
    private Context context;
    private RecyclerView rvATTFrg;
    private AvgTurnaroundTimeFrgAdapter avgTurnaroundTimeFrgAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getContext();
        view = inflater.inflate(R.layout.fragment_avg_turnaround_time, container, false);
        init();
        return view;
    }

    private void init() {
        rvATTFrg = view.findViewById(R.id.rvATTFrg);
        rvATTFrg.setHasFixedSize(true);
        rvATTFrg.setLayoutManager(new LinearLayoutManager(context));
        avgTurnaroundTimeFrgAdapter = new AvgTurnaroundTimeFrgAdapter(context);
        rvATTFrg.setAdapter(avgTurnaroundTimeFrgAdapter);

    }

}
