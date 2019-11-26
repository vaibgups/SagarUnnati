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
import com.example.sagarunnati.adapter.SagarmalaBeneFiciariesFrgAdapter;
import com.example.sagarunnati.model.sagarmala_beneficiaries.SgarmalaBeneficiariesResponse;
import com.example.sagarunnati.utility.Logger;
import com.example.sagarunnati.utility.RequestParameter;
import com.example.sagarunnati.utility.VolleyService;

import static com.example.sagarunnati.utility.Api.BASE_URL;
import static com.example.sagarunnati.utility.Api.SAGARMALA_BENEFICIARIES;

/**
 * A simple {@link Fragment} subclass.
 */
public class SagarmalaBeneficiariesFragment extends Fragment implements
        VolleyService.InterfaceVolleyResult {

    private static final String TAG = SagarmalaBeneficiariesFragment.class.getSimpleName();

    private RequestParameter requestParameter;
    private Context context;
    private View view;
    private RecyclerView rvSBFrg;
    private VolleyService volleyService;
    private SgarmalaBeneficiariesResponse sgarmalaBeneficiariesResponse;
    private SagarmalaBeneFiciariesFrgAdapter sagarmalaBeneFiciariesFrgAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getContext();
        view = inflater.inflate(R.layout.fragment_sagarmala_beneficiaries, container, false);
        init();
        Bundle bundle = getArguments();
        if (bundle.containsKey(RequestParameter.class.getSimpleName())) {
            requestParameter = (RequestParameter) bundle.getSerializable(RequestParameter.class.getSimpleName());

        }
        return view;
    }

    private void getSagarmalaBeneficiariesDetails() {
        volleyService = new VolleyService(SagarmalaBeneficiariesFragment.this, context);
        volleyService.postStringRequestWithOrOutParam(SAGARMALA_BENEFICIARIES, BASE_URL + SAGARMALA_BENEFICIARIES, null);
    }

    private void init() {
        rvSBFrg = view.findViewById(R.id.rvSBFrg);
        rvSBFrg.setHasFixedSize(true);
        rvSBFrg.setLayoutManager(new LinearLayoutManager(context));
        getSagarmalaBeneficiariesDetails();

    }


    @Override
    public void notifySuccess(String requestType, String response) {
        Logger.v(requestType, response);
        if (requestType.equals(SAGARMALA_BENEFICIARIES)) {
            sgarmalaBeneficiariesResponse = volleyService.getGson().
                    fromJson(response, SgarmalaBeneficiariesResponse.class);
            if (sgarmalaBeneficiariesResponse.isStatus()) {
                sagarmalaBeneFiciariesFrgAdapter = new SagarmalaBeneFiciariesFrgAdapter(context, sgarmalaBeneficiariesResponse);
                rvSBFrg.setAdapter(sagarmalaBeneFiciariesFrgAdapter);
            } else {
                Toast.makeText(context, sgarmalaBeneficiariesResponse.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void notifyError(String requestType, VolleyError error) {
        Logger.e(requestType, error.getMessage().toString());
        Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();

    }
}
