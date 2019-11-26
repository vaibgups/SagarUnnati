package com.example.sagarunnati.fragment;


import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.example.sagarunnati.R;
import com.example.sagarunnati.model.statement_cargo_traf_frg.StatementCargoTrafFrgResponse;
import com.example.sagarunnati.utility.Logger;
import com.example.sagarunnati.utility.VolleyService;

import static com.example.sagarunnati.utility.Api.BASE_URL;
import static com.example.sagarunnati.utility.Api.DIRECTORATE_GENERAL_SHIPPING;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatementCargoTrafFragment extends Fragment implements
        VolleyService.InterfaceVolleyResult {


    private View view;
    private Context context;
    private WebView webViewSCTFrg;
    private VolleyService volleyService;
    private StatementCargoTrafFrgResponse statementCargoTrafFrgResponse;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getContext();
        view = inflater.inflate(R.layout.fragment_statement_cargo_traf, container, false);
        init();
        return view;
    }

    private void init() {
        webViewSCTFrg = view.findViewById(R.id.webViewSCTFrg);
        getDirectorateGeneralShippingDetails();

    }

    private void getDirectorateGeneralShippingDetails() {
        volleyService = new VolleyService(StatementCargoTrafFragment.this, context);
        volleyService.postStringRequestWithOrOutParam(DIRECTORATE_GENERAL_SHIPPING, BASE_URL + DIRECTORATE_GENERAL_SHIPPING, null);
    }


    private void loadUrl() {
      /*  webViewSCTFrg.getSettings().setJavaScriptEnabled(true);
        webViewSCTFrg.getSettings().setSupportZoom(true);
        webViewSCTFrg.getSettings().setBuiltInZoomControls(true);
        webViewSCTFrg.getSettings().setDisplayZoomControls(false);
        webViewSCTFrg.getSettings().setJavaScriptEnabled(true);
//        webViewAboutUs.setWebViewClient(new MyWebViewClient());
        webViewSCTFrg.loadUrl(statementCargoTrafFrgResponse.getData());

//        webViewSCTFrg.loadUrl("http://docs.google.com/gview?embedded=true&url="+statementCargoTrafFrgResponse.getData());
*/


        try {
//            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(statementCargoTrafFrgResponse.getData()));
//            startActivity(browserIntent);
            Intent i = new Intent("android.intent.action.MAIN");
            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
            i.addCategory("android.intent.category.LAUNCHER");
            i.setData(Uri.parse("googlechrome://navigate?url=" + statementCargoTrafFrgResponse.getData()));
            startActivity(i);
        } catch (ActivityNotFoundException e) {
            // Chrome is not installed
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(statementCargoTrafFrgResponse.getData()));
            startActivity(i);
        }
    }

    @Override
    public void notifySuccess(String requestType, String response) {
        Logger.v(requestType, response);
        if (requestType.equals(DIRECTORATE_GENERAL_SHIPPING)) {
            statementCargoTrafFrgResponse = volleyService.getGson().
                    fromJson(response, StatementCargoTrafFrgResponse.class);
            if (statementCargoTrafFrgResponse.isStatus()) {
                loadUrl();
            } else {
                Toast.makeText(context, statementCargoTrafFrgResponse.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void notifyError(String requestType, VolleyError error) {
        Logger.v(requestType, error.getMessage());
        Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();

    }
}
