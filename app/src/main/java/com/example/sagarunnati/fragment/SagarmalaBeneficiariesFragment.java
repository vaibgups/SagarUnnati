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

/**
 * A simple {@link Fragment} subclass.
 */
public class SagarmalaBeneficiariesFragment extends Fragment {


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

}
