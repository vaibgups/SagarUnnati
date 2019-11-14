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
public class AnnOverAndCoastTrafficFragment extends Fragment {


    public AnnOverAndCoastTrafficFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ann_over_and_coast_traffic, container, false);
    }

}
