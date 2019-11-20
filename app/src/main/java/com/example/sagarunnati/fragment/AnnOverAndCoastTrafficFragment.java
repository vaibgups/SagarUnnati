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
import com.example.sagarunnati.mInterface.FilterDataInterface;
import com.example.sagarunnati.utility.Logger;
import com.example.sagarunnati.utility.RequestParameter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnnOverAndCoastTrafficFragment extends Fragment implements FilterDataInterface {


    private static final String TAG = AnnOverAndCoastTrafficFragment.class.getSimpleName();

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

    public void filterData(RequestParameter requestParameter) {

    }

    @Override
    public void filterParameter(RequestParameter requestParameter) {
        Logger.v(TAG, requestParameter.toString());
    }
}
