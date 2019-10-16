package com.example.sagarunnati.fragment;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.sagarunnati.R;
import com.example.sagarunnati.appliaction.MyApplication;
import com.example.sagarunnati.utility.JustifiedTextView;



/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment {

    private static final String TAG = MyApplication.TAG + AboutUsFragment.class.getSimpleName();

    private View view;
    private Context context;
    private WebView webViewAboutUs;
    private JustifiedTextView tvMyJustifyAboutUsMessage;
//    private JustifyTextView tvAboutUsMessage;

    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_about_us, container, false);
        context  = getContext();
        init();
//        loadUrl();
        return view;
    }

    private void init() {
//        webViewAboutUs = view.findViewById(R.id.webViewAboutUs);
        tvMyJustifyAboutUsMessage = view.findViewById(R.id.tvAboutUsMessage);
        String text= context.getResources().getString(R.string.about_us_message);
        tvMyJustifyAboutUsMessage.setText(text);
//        tvMyJustifyAboutUsMessage.setJustificationMode(JustifiedTextView.AUTO_SIZE_TEXT_TYPE_UNIFORM);
    }

    private void loadUrl() {
        webViewAboutUs.getSettings().setJavaScriptEnabled(true);
        webViewAboutUs.getSettings().setSupportZoom(true);
        webViewAboutUs.getSettings().setBuiltInZoomControls(true);
        webViewAboutUs.getSettings().setDisplayZoomControls(false);
//        webViewAboutUs.setWebViewClient(new MyWebViewClient());
        webViewAboutUs.loadUrl("http://shipmin.dashboard.nic.in/about_us.html");
    }

  /*  private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageStarted(final WebView view, final String url, final Bitmap favicon) {
//            progressBar.setVisibility(View.VISIBLE);
            super.onPageStarted(view, url, favicon);
        }
        @Override
        public void onPageFinished(WebView view, String url) {
//            progressBar.setVisibility(View.GONE);
            super.onPageFinished(view, url);
        }
    }*/
}
