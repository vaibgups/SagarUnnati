package com.example.sagarunnati.utility;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.sagarunnati.R;
import com.squareup.picasso.Picasso;

public class CustomDialogBoxEnlargeGalleryImage implements View.OnClickListener {
    private Context context;
    private Dialog dialog;
    private ImageView ivCancelImage, ivGalleryImageEnlarge;
//    private Button btnCstDigDecline, btnCstDigAccept;

    public CustomDialogBoxEnlargeGalleryImage(Context context) {
        this.context = context;
    }

    public void initCustomDialog(String imageUrl){
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.default_custom_image_view);
        ivCancelImage = dialog.findViewById(R.id.ivCancelImage);
        ivGalleryImageEnlarge = dialog.findViewById(R.id.ivGalleryImageEnlarge);
        Picasso.get().load(imageUrl).into(ivGalleryImageEnlarge);
//        ivGalleryImageEnlarge.setImageResource(imageUrl);
//        ivGalleryImageEnlarge.setImageResource(id);
//        btnCstDigDecline = dialog.findViewById(R.id.btnCstDigDecline);
//        btnCstDigDecline.setOnClickListener(this);
//        btnCstDigAccept = dialog.findViewById(R.id.btnCstDigAccept);
        ivCancelImage.setOnClickListener(this);
        dialog.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ivCancelImage:{
                dialog.dismiss();
                break;
            }
        }
    }
}
