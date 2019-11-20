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
import com.example.sagarunnati.adapter.AvgOutputPerShipBerthdayFrgAdapter;
import com.example.sagarunnati.mInterface.FilterDataInterface;
import com.example.sagarunnati.utility.Logger;
import com.example.sagarunnati.utility.RequestParameter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AvgOutputPerShipBerthdayFragment extends Fragment implements FilterDataInterface {

    private static final String TAG = AvgOutputPerShipBerthdayFragment.class.getSimpleName();
    private View view;
    private Context context;
    private RecyclerView rvAOPSBFrg;
    private AvgOutputPerShipBerthdayFrgAdapter outputPerShipBerthdayFrgAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getContext();
        view = inflater.inflate(R.layout.fragment_avg_output_per_ship_berthday, container, false);
        init();
        return view;
    }

    private void init() {
        rvAOPSBFrg = view.findViewById(R.id.rvAOPSBFrg);
        rvAOPSBFrg.setHasFixedSize(true);
        rvAOPSBFrg.setLayoutManager(new LinearLayoutManager(context));
        outputPerShipBerthdayFrgAdapter = new AvgOutputPerShipBerthdayFrgAdapter(context);
        rvAOPSBFrg.setAdapter(outputPerShipBerthdayFrgAdapter);
    }

    public void filterData(RequestParameter requestParameter) {
        Logger.v(TAG, requestParameter.toString());
    }

    @Override
    public void filterParameter(RequestParameter requestParameter) {
        Logger.v(TAG, requestParameter.toString());
    }
}
