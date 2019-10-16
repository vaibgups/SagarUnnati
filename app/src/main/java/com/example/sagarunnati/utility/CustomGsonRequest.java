package com.example.sagarunnati.utility;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;


import java.io.UnsupportedEncodingException;
import java.util.Map;

public class CustomGsonRequest extends Request {
    private final Gson gson = new Gson();
    private final Class myClass;
    private final Map headers;
    private final Map params;
    private final Response.Listener listener;

    public CustomGsonRequest(String url, Class myClass, Map headers,
                             Response.Listener listener, Response.ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        this.myClass = myClass;
        this.headers = headers;
        this.params = null;
        this.listener = listener;
    }

    public CustomGsonRequest(int type, String url, Class myClass, Map headers,
                             Map params,
                             Response.Listener listener, Response.ErrorListener errorListener) {
        super(type, url, errorListener);
        this.myClass = myClass;
        this.headers = headers;
        this.params = params;
        this.listener = listener;
    }

    @Override
    public Map getHeaders() throws AuthFailureError {
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected Map getParams() throws AuthFailureError {
        return params != null ? params : super.getParams();
    }

    @Override
    protected void deliverResponse(Object response) {
        if(null != listener){
            listener.onResponse(response);
        }
    }

    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {
        try {


            String json = new String(
                    response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(
                    gson.fromJson(json, myClass), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }


}
