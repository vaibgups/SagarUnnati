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
import com.example.sagarunnati.adapter.ProjectUnderSagarmalaFrgAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectsUnderSagarmalaFragment extends Fragment {


    private Context context;
    private View view;
    private RecyclerView rvPUSFrg;
    private ProjectUnderSagarmalaFrgAdapter projectUnderSagarmalaFrgAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getContext();
        view = inflater.inflate(R.layout.fragment_projects_under_sagarmala, container, false);
        init();
        return view;
    }

    private void init() {

        rvPUSFrg = view.findViewById(R.id.rvPUSFrg);
        rvPUSFrg.setHasFixedSize(true);
        rvPUSFrg.setLayoutManager(new LinearLayoutManager(context));
        projectUnderSagarmalaFrgAdapter = new ProjectUnderSagarmalaFrgAdapter(context);
        rvPUSFrg.setAdapter(projectUnderSagarmalaFrgAdapter);


    }

}
