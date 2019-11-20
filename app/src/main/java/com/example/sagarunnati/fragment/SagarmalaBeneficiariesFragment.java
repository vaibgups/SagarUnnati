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
import com.example.sagarunnati.adapter.SagarmalaBeneFiciariesFrgAdapter;
import com.example.sagarunnati.mInterface.FilterDataInterface;
import com.example.sagarunnati.utility.Logger;
import com.example.sagarunnati.utility.RequestParameter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SagarmalaBeneficiariesFragment extends Fragment implements FilterDataInterface {

    private static final String TAG = SagarmalaBeneficiariesFragment.class.getSimpleName();

    private Context context;
    private View view;
    private RecyclerView rvSBFrg;
    private SagarmalaBeneFiciariesFrgAdapter sagarmalaBeneFiciariesFrgAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getContext();
        view = inflater.inflate(R.layout.fragment_sagarmala_beneficiaries, container, false);
        init();
        return view;
    }

    private void init() {
        rvSBFrg = view.findViewById(R.id.rvSBFrg);
        rvSBFrg.setHasFixedSize(true);
        rvSBFrg.setLayoutManager(new LinearLayoutManager(context));
        sagarmalaBeneFiciariesFrgAdapter = new SagarmalaBeneFiciariesFrgAdapter(context);
        rvSBFrg.setAdapter(sagarmalaBeneFiciariesFrgAdapter);
    }

    public void filterData(RequestParameter requestParameter) {

    }

    @Override
    public void filterParameter(RequestParameter requestParameter) {
        Logger.v(TAG, requestParameter.toString());
    }
}
