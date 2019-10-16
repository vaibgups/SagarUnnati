package com.example.sagarunnati.appliaction;

import android.app.Application;
import android.widget.Toast;

import com.example.sagarunnati.utility.ConnectivityReceiver;
import com.example.sagarunnati.utility.SingletonRequestQueue;

public class MyApplication extends Application {

    public static final String TAG = " Sagar Unnati ";
    private static MyApplication myApplication;
    private SingletonRequestQueue singletonRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        singletonRequestQueue  = SingletonRequestQueue.getInstance(this);
    }

    public static synchronized MyApplication getMyApplicationInstance() {
        return myApplication;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }

    public SingletonRequestQueue getSingletonRequestQueue() {
        return singletonRequestQueue;
    }
}
