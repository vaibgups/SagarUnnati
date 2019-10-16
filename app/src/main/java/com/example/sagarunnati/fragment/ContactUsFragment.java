package com.example.sagarunnati.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.sagarunnati.R;
import com.example.sagarunnati.appliaction.MyApplication;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUsFragment extends Fragment {


    private static final String TAG = MyApplication.TAG + ContactUsFragment.class.getSimpleName();

    private View view;
    private Context context;
    private WebView webViewContactUs;

    public ContactUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contact_us, container, false);
        context  = getContext();
        init();
        loadUrl();
        return view;
    }

    private void init() {
        webViewContactUs = view.findViewById(R.id.webViewContactUs);
    }

    private void loadUrl() {
        webViewContactUs.getSettings().setJavaScriptEnabled(true);
        webViewContactUs.getSettings().setSupportZoom(true);
        webViewContactUs.getSettings().setBuiltInZoomControls(true);
        webViewContactUs.getSettings().setDisplayZoomControls(false);
//        webViewAboutUs.setWebViewClient(new MyWebViewClient());
        webViewContactUs.loadUrl("http://shipmin.dashboard.nic.in/contact_us.html");
    }


}
