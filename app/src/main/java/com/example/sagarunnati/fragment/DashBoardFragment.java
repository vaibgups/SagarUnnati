package com.example.sagarunnati.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.VolleyError;
import com.example.sagarunnati.R;
import com.example.sagarunnati.adapter.DashBoardAdapter;
import com.example.sagarunnati.appliaction.MyApplication;
import com.example.sagarunnati.model.performance.PerformanceResponse;
import com.example.sagarunnati.utility.EqualSpacingItemDecoration;
import com.example.sagarunnati.utility.Logger;
import com.example.sagarunnati.utility.VolleyService;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import static com.example.sagarunnati.utility.Api.BASE_URL;
import static com.example.sagarunnati.utility.Api.DASHBOARD_DATA;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment implements
        VolleyService.InterfaceVolleyResult {
    private final String TAG = MyApplication.TAG + this.getClass().getSimpleName();
    private View view;
    private Context context;

    private RecyclerView recyclerView;

    private DashBoardAdapter dashBoardAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private EqualSpacingItemDecoration equalSpacingItemDecoration;
    private VolleyService volleyService;
    private List<PerformanceResponse> responseList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dash_board, container, false);
        context = getContext();
        init();
        getDashboardData();
        return view;
    }

    private void init() {
        recyclerView = view.findViewById(R.id.rvDashBoardDetails);
        setRecyclerViewParam(recyclerView);
        equalSpacingItemDecoration = new EqualSpacingItemDecoration(20);
        recyclerView.addItemDecoration(equalSpacingItemDecoration);
//        dashBoardAdapter = new DashBoardAdapter(getContext());
//        recyclerView.setAdapter(dashBoardAdapter);


    }

    private void setRecyclerViewParam(RecyclerView recyclerView) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 100);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(layoutManager);

    }

    private void getDashboardData() {
        volleyService = new VolleyService(DashBoardFragment.this, context);
        volleyService.postStringRequestWithParam(DASHBOARD_DATA, BASE_URL + DASHBOARD_DATA, null);
    }

    @Override
    public void notifySuccess(String requestType, String response) {
        Logger.v(requestType, response.toString());
        try {
            JSONObject jsonObject = new JSONObject(response);
            String userJson = jsonObject.getString("dashboard_data");

            Type performanceListType = new TypeToken<List<PerformanceResponse>>(){}.getType();
            responseList = volleyService.getGson().fromJson(userJson, performanceListType);
            Logger.v(requestType, ""+responseList.size());
            dashBoardAdapter = new DashBoardAdapter(getContext(),responseList);
//            dashBoardAdapter = new DashBoardAdapter(getContext());
            recyclerView.setAdapter(dashBoardAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void notifyError(String requestType, VolleyError error) {
        Logger.e(requestType, error.getMessage());
    }
}
