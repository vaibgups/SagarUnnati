package com.example.sagarunnati.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sagarunnati.R;
import com.example.sagarunnati.mInterface.HomeScreenButtonInterface;

import java.util.ArrayList;

public class HomeButtonAdapter extends RecyclerView.Adapter<HomeButtonAdapter.ViewHolder> {

    private Context context;
    private int size;
    private HomeScreenButtonInterface homeScreenButtonInterface;
    private ArrayList<String> homeScreenButtonText = new ArrayList<String>();
    private int[] drawableImageID = new int[]{R.drawable.about_512_512, R.drawable.gallery_500_500,
            R.drawable.contact_us_512_512, R.drawable.ic_dashboard_black_24dp};
//    R.drawable.contact_us_512_512, R.drawable.ic_dashboard_black_24dp, R.drawable.ic_login_outline_black_24dp};

//    R.drawable.publication_512_512

    public HomeButtonAdapter(Context context) {
        this.context = context;
        this.size = size;
        homeScreenButtonInterface = (HomeScreenButtonInterface) context;
        homeScreenButtonText.add("About Us");
        homeScreenButtonText.add("Gallery");
//        homeScreenButtonText.add("Publications");
        homeScreenButtonText.add("Contact Us");
        homeScreenButtonText.add("Performance");
//        homeScreenButtonText.add("Login");

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content_home_screen_btn_rcv,null,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewHomeScreen2.setText(homeScreenButtonText.get(position));
        holder.imageViewHomeScreenButton.setImageResource(drawableImageID[position]);
    }

    @Override
    public int getItemCount() {
        return homeScreenButtonText.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewHomeScreenButton;
        TextView textViewHomeScreen,textViewHomeScreen2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            textViewHomeScreen = itemView.findViewById(R.id.textViewHomeScreen);
            textViewHomeScreen2 = itemView.findViewById(R.id.textViewHomeScreen2);

            imageViewHomeScreenButton = itemView.findViewById(R.id.imageViewHomeScreenButton);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (homeScreenButtonInterface != null){
                        homeScreenButtonInterface.homeScreenButtonClick(getAdapterPosition());
                    }
                }
            });

        }
    }


}
