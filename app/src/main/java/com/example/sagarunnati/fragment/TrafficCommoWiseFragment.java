package com.example.sagarunnati.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.example.sagarunnati.R;
import com.example.sagarunnati.adapter.TrafficCWFrgAdapter;
import com.example.sagarunnati.model.traffic_commodity_wise.TrafficCommodityWiseDataItem;
import com.example.sagarunnati.model.traffic_commodity_wise.TrafficCommodityWiseResponse;
import com.example.sagarunnati.utility.Logger;
import com.example.sagarunnati.utility.RequestParameter;
import com.example.sagarunnati.utility.VolleyService;

import java.util.List;

import static com.example.sagarunnati.utility.Api.BASE_URL;
import static com.example.sagarunnati.utility.Api.TRAFFIC_COMMODITY_WISE;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrafficCommoWiseFragment extends Fragment implements VolleyService.InterfaceVolleyResult {

    private static final String TAG = TrafficCommoWiseFragment.class.getSimpleName();

    private RequestParameter requestParameter;
    private Context context;
    private View view;
    private TextView tvTCWFrgVariation;
    private RecyclerView rvTCWFrg;
    private TrafficCWFrgAdapter trafficCWFrgAdapter;
    private VolleyService volleyService;
    private TrafficCommodityWiseResponse trafficCommodityWiseResponse;
    private List<TrafficCommodityWiseDataItem> dataItemList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getContext();
        view = inflater.inflate(R.layout.fragment_traffic_commo_wise, container, false);
        init();
        Bundle bundle = getArguments();
        if (bundle.containsKey(RequestParameter.class.getSimpleName())) {
            requestParameter = (RequestParameter) bundle.getSerializable(RequestParameter.class.getSimpleName());
            getTrafficCommodityWiseDetails();
        }
        if (requestParameter.getAccessToken() != null) {
            tvTCWFrgVariation.setVisibility(View.VISIBLE);
        }
        return view;
    }

    private void getTrafficCommodityWiseDetails() {
        volleyService = new VolleyService(TrafficCommoWiseFragment.this, context);
        volleyService.postDataVolley(TRAFFIC_COMMODITY_WISE, BASE_URL + TRAFFIC_COMMODITY_WISE, requestParameter);

    }

    private void init() {
        tvTCWFrgVariation = view.findViewById(R.id.tvTCWFrgVariation);
        rvTCWFrg = view.findViewById(R.id.rvTCWFrg);
        rvTCWFrg.setHasFixedSize(true);
        rvTCWFrg.setLayoutManager(new LinearLayoutManager(context));

    }

    public void filterData(RequestParameter requestParameter) {
        Logger.v("FilterData called ", requestParameter.toString());
        this.requestParameter = requestParameter;
        getTrafficCommodityWiseDetails();
    }

    @Override
    public void notifySuccess(String requestType, String response) {
        Logger.v(requestType, response);
        if (requestType.equals(TRAFFIC_COMMODITY_WISE)) {
            try {
                trafficCommodityWiseResponse = volleyService.getGson().fromJson(response, TrafficCommodityWiseResponse.class);
                if (trafficCommodityWiseResponse.isStatus()) {
                    trafficCWFrgAdapter = new TrafficCWFrgAdapter(context, trafficCommodityWiseResponse, requestParameter);
                    rvTCWFrg.setAdapter(trafficCWFrgAdapter);
                    Toast.makeText(context, trafficCommodityWiseResponse.getMsg(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, trafficCommodityWiseResponse.getMsg(), Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Toast.makeText(context, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void notifyError(String requestType, VolleyError error) {
        Logger.v(requestType, error.getMessage());
    }
}
