package com.example.sagarunnati.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.example.sagarunnati.R;
import com.example.sagarunnati.adapter.ProjectUnderSagarmalaFrgAdapter;
import com.example.sagarunnati.model.project_under_sagarmala.ProjectUnderSagarmalaResponse;
import com.example.sagarunnati.utility.Logger;
import com.example.sagarunnati.utility.RequestParameter;
import com.example.sagarunnati.utility.VolleyService;

import static com.example.sagarunnati.utility.Api.BASE_URL;
import static com.example.sagarunnati.utility.Api.PROJECT_UNDER_SAGARMALA;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectsUnderSagarmalaFragment extends Fragment implements VolleyService.InterfaceVolleyResult {

    private static final String TAG = ProjectsUnderSagarmalaFragment.class.getSimpleName();

    private RequestParameter requestParameter;
    private Context context;
    private View view;
    private RecyclerView rvPUSFrg;
    private ProjectUnderSagarmalaFrgAdapter projectUnderSagarmalaFrgAdapter;
    private VolleyService volleyService;
    private ProjectUnderSagarmalaResponse projectUnderSagarmalaResponse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getContext();
        view = inflater.inflate(R.layout.fragment_projects_under_sagarmala, container, false);
        init();
        Bundle bundle = getArguments();
        if (bundle.containsKey(RequestParameter.class.getSimpleName())) {
            requestParameter = (RequestParameter) bundle.getSerializable(RequestParameter.class.getSimpleName());
            getProjectUnderSagarmalaDetails();
        }
        return view;
    }

    private void getProjectUnderSagarmalaDetails() {
        volleyService = new VolleyService(ProjectsUnderSagarmalaFragment.this, context);
        volleyService.postStringRequestWithOrOutParam(PROJECT_UNDER_SAGARMALA, BASE_URL + PROJECT_UNDER_SAGARMALA, null);

    }

    private void init() {
        rvPUSFrg = view.findViewById(R.id.rvPUSFrg);
        rvPUSFrg.setHasFixedSize(true);
        rvPUSFrg.setLayoutManager(new LinearLayoutManager(context));
    }


    @Override
    public void notifySuccess(String requestType, String response) {
        Logger.v(requestType, response);
        if (requestType.equals(PROJECT_UNDER_SAGARMALA)) {
            projectUnderSagarmalaResponse = volleyService.getGson().fromJson(response, ProjectUnderSagarmalaResponse.class);
            if (projectUnderSagarmalaResponse.isStatus()) {
                projectUnderSagarmalaFrgAdapter = new ProjectUnderSagarmalaFrgAdapter(context, projectUnderSagarmalaResponse);
                rvPUSFrg.setAdapter(projectUnderSagarmalaFrgAdapter);
            } else {
                Toast.makeText(context, projectUnderSagarmalaResponse.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void notifyError(String requestType, VolleyError error) {
        Logger.v(requestType, error.getMessage());
    }

}
