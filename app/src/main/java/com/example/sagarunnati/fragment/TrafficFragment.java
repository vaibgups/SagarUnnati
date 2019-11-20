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
import com.example.sagarunnati.adapter.TrafficFrgAdapter;
import com.example.sagarunnati.model.traffic.TrafficResponse;
import com.example.sagarunnati.utility.Logger;
import com.example.sagarunnati.utility.RequestParameter;
import com.example.sagarunnati.utility.VolleyService;

import static com.example.sagarunnati.utility.Api.BASE_URL;
import static com.example.sagarunnati.utility.Api.TRAFFIC;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrafficFragment extends Fragment implements VolleyService.InterfaceVolleyResult {

    private static final String TAG = TrafficFragment.class.getSimpleName();

    private RequestParameter requestParameter;
    private View view;
    private Context context;
    private RecyclerView rvTrafficFrg;
    private TrafficFrgAdapter trafficFrgAdapter;
    private VolleyService volleyService;
    private TrafficResponse trafficResponse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getContext();
        view = inflater.inflate(R.layout.fragment_traffic, container, false);
        init();
        Bundle bundle = getArguments();
        if (bundle.containsKey(RequestParameter.class.getSimpleName())) {
            requestParameter = (RequestParameter) bundle.getSerializable(RequestParameter.class.getSimpleName());
            getDailyVesselDetails();
        }
        return view;
    }


    private void init() {
        rvTrafficFrg = view.findViewById(R.id.rvTrafficFrg);
        rvTrafficFrg.setHasFixedSize(true);
        rvTrafficFrg.setLayoutManager(new LinearLayoutManager(context));
    }

    public void filterData(RequestParameter requestParameter) {
        Logger.v("FilterData called ", requestParameter.toString());
        this.requestParameter = requestParameter;
        getDailyVesselDetails();
    }


    private void getDailyVesselDetails() {
        volleyService = new VolleyService(TrafficFragment.this, context);
        volleyService.postJsonAuthBearerRequest(TRAFFIC, BASE_URL + TRAFFIC, requestParameter.getHashMap());

    }

    @Override
    public void notifySuccess(String requestType, String response) {
        Logger.v(requestType, response);
        if (requestType.equals(TRAFFIC)) {
            trafficResponse = volleyService.getGson().fromJson(response, TrafficResponse.class);
            if (trafficResponse.isStatus()) {
                trafficFrgAdapter = new TrafficFrgAdapter(context, trafficResponse);
                rvTrafficFrg.setAdapter(trafficFrgAdapter);
            } else {
                Toast.makeText(context, trafficResponse.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void notifyError(String requestType, VolleyError error) {
        Logger.v(requestType, error.getMessage());
    }
}
