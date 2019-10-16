package com.example.sagarunnati.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sagarunnati.R;

import com.example.sagarunnati.utility.CustomDialogBoxEnlargeGalleryImage;


public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private Context context;
    private int[] galleryImageArray = new int[]{R.drawable.gallery_1, R.drawable.gallery_2, R.drawable.gallery_3};
    private CustomDialogBoxEnlargeGalleryImage customDialogBoxEnlargeGalleryImage;

    public GalleryAdapter(Context context) {
        this.context = context;
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
        return galleryImageArray.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivCntAdpFrgGallery;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCntAdpFrgGallery = itemView.findViewById(R.id.ivCntAdpFrgGallery);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    customDialogBoxEnlargeGalleryImage.initCustomDialog(galleryImageArray[getAdapterPosition()]);

//                    context.startActivity(new Intent(context, ExpandedImageActivity.class));

//                    Intent intent = new Intent();
//                    intent.setAction(Intent.ACTION_VIEW);
//                    Uri path = Uri.parse("android.resource://com.example.sagarunnati/" + R.drawable.gallery_1);
//                    intent.setDataAndType(path, "image/*");
//                    String imageUri = "drawable://" + galleryImageArray[getAdapterPosition()];
//                    Uri path = Uri.parse("android.resource://com.example.sagarunnati/" + galleryImageArray[getAdapterPosition()]);
//                    Uri path = Uri.parse("android.resource://com.example.sagarunnati/drawable/" + galleryImageArray[getAdapterPosition()]);
//                    File file = new File(path.toString());
//                    if (file.exists()){
//                        intent.setDataAndType(Uri.fromFile(file), "image/*");
//                    }
//                    Bitmap b = BitmapFactory.decodeResource( context.getResources() , galleryImageArray[getAdapterPosition()] );
//                    Intent.createChooser(intent, "View using");
//                    context.startActivity(Intent.createChooser(intent, "View using"));
                }
            });
        }

        public void setWidgetValue(int position) {
           ivCntAdpFrgGallery.setImageResource(galleryImageArray[position]);
        }


    }
}
