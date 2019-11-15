package com.example.sagarunnati.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sagarunnati.R;

import com.example.sagarunnati.model.gallery.GalleryResponse;
import com.example.sagarunnati.utility.CustomDialogBoxEnlargeGalleryImage;
import com.squareup.picasso.Picasso;

import java.util.List;


public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private Context context;
    private List<GalleryResponse> galleryResponseList;
    private GalleryResponse galleryResponse;
    private int[] galleryImageArray = new int[]{R.drawable.gallery_1, R.drawable.gallery_2, R.drawable.gallery_3};
    private CustomDialogBoxEnlargeGalleryImage customDialogBoxEnlargeGalleryImage;



    public GalleryAdapter(Context context, List<GalleryResponse> galleryResponseList) {
        this.context = context;
        this.galleryResponseList = galleryResponseList;
        customDialogBoxEnlargeGalleryImage = new CustomDialogBoxEnlargeGalleryImage(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content_adapter_gallery_fragment,null, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setWidgetValue(position);
    }

    @Override
    public int getItemCount() {
        return galleryResponseList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivCntAdpFrgGallery;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCntAdpFrgGallery = itemView.findViewById(R.id.ivCntAdpFrgGallery);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GalleryResponse galleryResponse = galleryResponseList.get(getAdapterPosition());
                    customDialogBoxEnlargeGalleryImage.initCustomDialog(galleryResponse.getImgPath());
                }
            });
        }

        public void setWidgetValue(int position) {
            galleryResponse = galleryResponseList.get(position);
            Picasso.get().load(galleryResponse.getImgPath()).into(ivCntAdpFrgGallery);
        }


    }
}
