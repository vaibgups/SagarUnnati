package com.example.sagarunnati.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.sagarunnati.R;
import com.example.sagarunnati.utility.TouchImageView;


public class ExpandedImageActivity extends FragmentActivity {

    String imgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bitmap b = BitmapFactory.decodeResource(this.getResources(), R.drawable.gallery_1);
        TouchImageView img = new TouchImageView(this, b);
        img.setMaxZoom(10f);
        setContentView(img);
    }
}
