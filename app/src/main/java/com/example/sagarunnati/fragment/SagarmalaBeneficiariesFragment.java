package com.example.sagarunnati.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sagarunnati.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SagarmalaBeneficiariesFragment extends Fragment {


    public SagarmalaBeneficiariesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sagarmala_beneficiaries, container, false);
    }

}
