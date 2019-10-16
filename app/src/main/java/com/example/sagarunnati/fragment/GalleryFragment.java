package com.example.sagarunnati.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.sagarunnati.R;
import com.example.sagarunnati.adapter.GalleryAdapter;
import com.example.sagarunnati.utility.EqualSpacingItemDecoration;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {

    private View view;
    private Context context;
    private RecyclerView rvFrgGallery;
    private RecyclerView.LayoutManager layoutManager;
    private EqualSpacingItemDecoration equalSpacingItemDecoration;
    private GalleryAdapter galleryAdapter;
//    private Ad

    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_gallery, container, false);
        context  = getContext();
        init();
        return view;
    }

    private void init() {
        rvFrgGallery = view.findViewById(R.id.rvFrgGallery);
        setRecyclerViewParam(rvFrgGallery);
        galleryAdapter = new GalleryAdapter(getContext());
        equalSpacingItemDecoration = new EqualSpacingItemDecoration(20);
        rvFrgGallery.addItemDecoration(equalSpacingItemDecoration);
        rvFrgGallery.setAdapter(galleryAdapter);

    }

    private void setRecyclerViewParam(RecyclerView recyclerView) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 100);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(layoutManager);
    }



}
