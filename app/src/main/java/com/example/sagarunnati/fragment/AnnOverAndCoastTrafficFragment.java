package com.example.sagarunnati.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sagarunnati.R;
import com.example.sagarunnati.adapter.AnnOverAndCoastalTrafficFrgAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnnOverAndCoastTrafficFragment extends Fragment {


    private View view;
    private Context context;
    private RecyclerView rvAOCTFrg;
    private AnnOverAndCoastalTrafficFrgAdapter annOverAndCoastalTrafficFrgAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getContext();
        view = inflater.inflate(R.layout.fragment_ann_over_and_coast_traffic, container, false);
        init();
        return view;
    }
    private void init() {
        rvAOCTFrg = view.findViewById(R.id.rvAOCTFrg);
        rvAOCTFrg.setHasFixedSize(true);
        rvAOCTFrg.setLayoutManager(new LinearLayoutManager(context));
        annOverAndCoastalTrafficFrgAdapter = new AnnOverAndCoastalTrafficFrgAdapter(context);
        rvAOCTFrg.setAdapter(annOverAndCoastalTrafficFrgAdapter);

    }

}
