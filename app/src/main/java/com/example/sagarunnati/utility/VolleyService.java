package com.example.sagarunnati.utility;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sagarunnati.utility.Logger;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class VolleyService {

    private InterfaceVolleyResult mResultCallback = null;
    private Context mContext;
    private SingletonRequestQueue singletonRequestQueue;
    private String requestType;
    private RequestQueue requestQueue;
    private Gson gson;
    private JSONObject jsonObjectParam = null;
    private ProgressDialog progressDialog;
    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            progressDialog.dismiss();
            if (error instanceof NetworkError) {
                Logger.e(requestType,error.getMessage());
//                Toast.makeText(mContext, "No network available", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(mContext, error.toString(), Toast.LENGTH_LONG).show();
            }
            if (mResultCallback != null) {
                mResultCallback.notifyError(requestType, error);
            }
        }
    };

    public VolleyService(Activity resultCallback, Context context) {
        mResultCallback = (InterfaceVolleyResult) resultCallback;
        mContext = context;
        singletonRequestQueue = SingletonRequestQueue.getInstance(mContext);
        requestQueue = singletonRequestQueue.getRequestQueue();
        gson = new Gson();
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Please wait...");
        progressDialog.setCancelable(true);
    }
    public VolleyService(InterfaceVolleyResult resultCallback, Context context) {
        mResultCallback = resultCallback;
        mContext = context;
        singletonRequestQueue = SingletonRequestQueue.getInstance(mContext);
        requestQueue = singletonRequestQueue.getRequestQueue();
        gson = new Gson();
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Please wait...");
        progressDialog.setCancelable(true);
    }

    private void convertStringToJSONObject(Object objectParam) {
        try {
            String jsonString = gson.toJson(objectParam);
            jsonObjectParam = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void postDataVolley(final String requestType, String url, final Object objectParam) {
        try {
            this.requestType = requestType;
            progressDialog.show();
            convertStringToJSONObject(objectParam);
            JsonObjectRequest jsonObj = new JsonObjectRequest(Request.Method.POST, url, jsonObjectParam, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    progressDialog.dismiss();
                    if (mResultCallback != null)
                        mResultCallback.notifySuccess(requestType, response.toString());
                }
            }, errorListener) {
            };

            jsonObj.setRetryPolicy(new DefaultRetryPolicy(
                    4000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            requestQueue.add(jsonObj);

        } catch (Exception e) {

        }
    }

    public void postStringRequestWithParam(final String requestType, String url, final Map<String, String> param) {
        try {
            this.requestType = requestType;
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    if (mResultCallback != null) {
                        mResultCallback.notifySuccess(requestType, response);

                    }
                }
            }, errorListener) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
//                    param.put("Content-Type", "application/x-www-form-urlencoded");
                    return param;
                }

            };
            request.setShouldCache(false);
            request.setRetryPolicy(new DefaultRetryPolicy(
                    4000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            requestQueue.add(request);

        } catch (Exception e) {
            progressDialog.dismiss();
        }
    }


    public Gson getGson() {
        return gson;
    }

    public void postJsonAuthBearerRequest(final String requestType, String url, final Map<String, String> param) {
        try {
            this.requestType = requestType;

            JsonObjectRequest jsonObj = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    if (mResultCallback != null)
                        mResultCallback.notifySuccess(requestType, response.toString());
                }
            },
                    errorListener){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    return param;
                }
            };

            jsonObj.setShouldCache(false);
            jsonObj.setRetryPolicy(new DefaultRetryPolicy(
                    4000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            requestQueue.add(jsonObj);

        } catch (Exception e) {
        }


    }



    public interface InterfaceVolleyResult {
        void notifySuccess(String requestType, String response);

        void notifyError(String requestType, VolleyError error);
    }
}


    /*@Override

    public Map getHeaders() throws AuthFailureError {
        HashMap headers = new HashMap();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return headers;
    }


    @Override
    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }*/