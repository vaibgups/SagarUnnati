package com.example.sagarunnati.utility;

import android.content.Context;

import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

public class TestClass {
    private static final String TAG = TestClass.class.getSimpleName();
    VolleyService.IResult mResultCallback = new VolleyService.IResult() {
        @Override
        public void notifySuccess(String requestType, JSONObject response) {

        }

        @Override
        public void notifyError(String requestType, VolleyError error) {

        }
    };
    VolleyService mVolleyService;
    Context context;

    void setmVolleyService(){

        mVolleyService = new VolleyService(mResultCallback,context);
        mVolleyService.getDataVolley("GETCALL","http://192.168.1.150/datatest/get/data");
        JSONObject sendObj = null;

        try {
            sendObj = new JSONObject("{'Test':'Test'}");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mVolleyService.postDataVolley("POSTCALL", "http://192.168.1.150/datatest/post/data", sendObj);

    }
}
