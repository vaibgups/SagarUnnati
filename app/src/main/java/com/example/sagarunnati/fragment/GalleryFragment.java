package com.example.sagarunnati.fragment;


import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.example.sagarunnati.R;
import com.example.sagarunnati.adapter.GalleryAdapter;
import com.example.sagarunnati.model.gallery.GalleryResponse;
import com.example.sagarunnati.utility.EqualSpacingItemDecoration;
import com.example.sagarunnati.utility.Logger;
import com.example.sagarunnati.utility.VolleyService;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import static com.example.sagarunnati.utility.Api.BASE_URL;
import static com.example.sagarunnati.utility.Api.GALLERY;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment implements VolleyService.InterfaceVolleyResult {

    private View view;
    private Context context;
    private RecyclerView rvFrgGallery;
    private RecyclerView.LayoutManager layoutManager;
    private EqualSpacingItemDecoration equalSpacingItemDecoration;
    private GalleryAdapter galleryAdapter;
    private VolleyService volleyService;
    private List<GalleryResponse> galleryResponseList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_gallery, container, false);
        context = getContext();
        init();
        getGalleryImages();
        return view;
    }

    private void init() {
        rvFrgGallery = view.findViewById(R.id.rvFrgGallery);
        setRecyclerViewParam(rvFrgGallery);
        equalSpacingItemDecoration = new EqualSpacingItemDecoration(20);
        rvFrgGallery.addItemDecoration(equalSpacingItemDecoration);

    }

    private void setRecyclerViewParam(RecyclerView recyclerView) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 100);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void getGalleryImages() {
        volleyService = new VolleyService(GalleryFragment.this, context);
        volleyService.postStringRequestWithOrOutParam(GALLERY, BASE_URL + GALLERY, null);
    }

    @Override
    public void notifySuccess(String requestType, String response) {
        Logger.v(requestType, response.toString());
        try {
            JSONObject jsonObject = new JSONObject(response);
            String userJson = jsonObject.getString("data");
            Logger.v(requestType, userJson);
            Type userListType = new TypeToken<List<GalleryResponse>>(){}.getType();
            galleryResponseList = volleyService.getGson().fromJson(userJson, userListType);
            galleryAdapter = new GalleryAdapter(getContext(),galleryResponseList);
            rvFrgGallery.setAdapter(galleryAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void notifyError(String requestType, VolleyError error) {
        Logger.e(requestType, error.getMessage());
    }


}
