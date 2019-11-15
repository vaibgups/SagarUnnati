package com.example.sagarunnati.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.example.sagarunnati.R;
import com.example.sagarunnati.appliaction.MyApplication;
import com.example.sagarunnati.utility.JustifiedTextView;
import com.example.sagarunnati.utility.Logger;
import com.example.sagarunnati.utility.VolleyService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.sagarunnati.utility.Api.ABOUT_US;
import static com.example.sagarunnati.utility.Api.BASE_INFO_URL;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment implements VolleyService.InterfaceVolleyResult {

    private static final String TAG = MyApplication.TAG + AboutUsFragment.class.getSimpleName();

    private View view;
    private Context context;
    private JustifiedTextView tvMyJustifyAboutUsMessage;
    private VolleyService volleyService;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_about_us, container, false);
        context = getContext();
        init();
        getAboutUsContent();
        return view;
    }


    private void init() {
        tvMyJustifyAboutUsMessage = view.findViewById(R.id.tvAboutUsMessage);
    }

    private void getAboutUsContent() {
        volleyService = new VolleyService(AboutUsFragment.this, context);

        Map<String, String> param = new HashMap<>();
        param.put("action", ABOUT_US);
        volleyService.postStringRequestWithParam(ABOUT_US, BASE_INFO_URL, param);
    }


    @Override
    public void notifySuccess(String requestType, String response) {
        Logger.v(requestType, response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            boolean status  =(Boolean) jsonObject.get("status");
            if (status){
                JSONObject jsonObject2 = new JSONObject((jsonObject.getString("data")));
                String content = jsonObject2.getString("content");
                tvMyJustifyAboutUsMessage.setText(content);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void notifyError(String requestType, VolleyError error) {

        Logger.e(requestType, error.getMessage());
    }

}
