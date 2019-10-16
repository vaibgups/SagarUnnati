package com.example.sagarunnati.utility;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.NetworkError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class VolleyService {

    IResult mResultCallback = null;
    Context mContext;
    String requestType;
    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            /*if (error instanceof NetworkError) {
                Toast.makeText(mContext, "No network available", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(mContext, error.toString(), Toast.LENGTH_LONG).show();
            }*/
            if(mResultCallback != null){
                mResultCallback.notifyError(requestType,error);
        }
        }
    };

    VolleyService(IResult resultCallback, Context context){
        mResultCallback = resultCallback;
        mContext = context;
    }


    public void postDataVolley(final String requestType, String url,JSONObject sendObj){
        try {
            this.requestType = requestType;
            RequestQueue queue = Volley.newRequestQueue(mContext);

            JsonObjectRequest jsonObj = new JsonObjectRequest(url,sendObj, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    if(mResultCallback != null)
                        mResultCallback.notifySuccess(requestType,response);
                }
            },/* new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if(mResultCallback != null)
                        mResultCallback.notifyError(requestType,error);
                }
            }*/
            errorListener);

            queue.add(jsonObj);

        }catch(Exception e){

        }
    }

    public void getDataVolley(final String requestType, String url){
        try {
            this.requestType = requestType;
            RequestQueue queue = Volley.newRequestQueue(mContext);

            JsonObjectRequest jsonObj = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    if(mResultCallback != null)
                        mResultCallback.notifySuccess(requestType, response);
                }
            },/* new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if(mResultCallback != null)
                        mResultCallback.notifyError(requestType, error);
                }
            }*/
            errorListener);

            queue.add(jsonObj);

        }catch(Exception e){

        }
    }

    public interface IResult {
        public void notifySuccess(String requestType, JSONObject response);
        public void notifyError(String requestType,VolleyError error);
    }
}
