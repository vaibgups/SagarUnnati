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
import com.example.sagarunnati.adapter.DailyVesselFrgAdapter;
import com.example.sagarunnati.model.daily_vessel.DailyVesselResponse;
import com.example.sagarunnati.utility.Logger;
import com.example.sagarunnati.utility.RequestParameter;
import com.example.sagarunnati.utility.VolleyService;

import static com.example.sagarunnati.utility.Api.BASE_URL;
import static com.example.sagarunnati.utility.Api.DAILY_VESSEL_DETAIL;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class DailyVesselFragment extends Fragment implements
        VolleyService.InterfaceVolleyResult {

    private static final String TAG = DailyVesselFragment.class.getSimpleName();

    private RequestParameter requestParameter;
    private View view;
    private Context context;
    private TextView tvDSVReason;
    private RecyclerView rvDVFrg;
    private DailyVesselFrgAdapter dailyVesselFrgAdapter;
    private VolleyService volleyService;
    private DailyVesselResponse dailyVesselResponse;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getContext();
        view = inflater.inflate(R.layout.fragment_daily_vessel, container, false);
        init();
        Bundle bundle = getArguments();
        if (bundle.containsKey(RequestParameter.class.getSimpleName())) {
            requestParameter = (RequestParameter) bundle.getSerializable(RequestParameter.class.getSimpleName());
            getDailyVesselDetails();
        }
        if (requestParameter.getAccessToken() != null) {
            tvDSVReason.setVisibility(View.VISIBLE);
        }
        return view;
    }


    private void init() {
        tvDSVReason = view.findViewById(R.id.tvDSVReason);
        rvDVFrg = view.findViewById(R.id.rvDVFrg);
        rvDVFrg.setHasFixedSize(true);
        rvDVFrg.setLayoutManager(new LinearLayoutManager(context));

    }



    @Override
    public void notifySuccess(String requestType, String response) {
        Logger.v(requestType, response);
        if (requestType.equals(DAILY_VESSEL_DETAIL)) {
            dailyVesselResponse = volleyService.getGson().fromJson(response, DailyVesselResponse.class);
            if (dailyVesselResponse.isStatus()) {
                dailyVesselFrgAdapter = new DailyVesselFrgAdapter(context, dailyVesselResponse, requestParameter);
                rvDVFrg.setAdapter(dailyVesselFrgAdapter);
            } else {
                Toast.makeText(context, dailyVesselResponse.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void notifyError(String requestType, VolleyError error) {
        Logger.v(requestType, error.getMessage());
    }

    private void getDailyVesselDetails() {
        volleyService = new VolleyService(DailyVesselFragment.this, context);
        volleyService.postDataVolley(DAILY_VESSEL_DETAIL, BASE_URL + DAILY_VESSEL_DETAIL, requestParameter);

    }
}
