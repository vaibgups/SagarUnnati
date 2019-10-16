package com.example.sagarunnati.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sagarunnati.R;
import com.example.sagarunnati.activity.DashBoardClickUrlActivity;
import com.example.sagarunnati.appliaction.MyApplication;
import com.example.sagarunnati.mInterface.HomeScreenButtonInterface;
import com.example.sagarunnati.utility.ConnectivityReceiver;

import java.util.ArrayList;

public class DashBoardAdapter extends RecyclerView.Adapter<DashBoardAdapter.ViewHolder> {

    private final String TAG = MyApplication.TAG + DashBoardAdapter.class.getSimpleName();

    private Context context;

    private HomeScreenButtonInterface homeScreenButtonInterface;

    private int[] drawableImageArray = new int[]{R.drawable.river_notice_least_available,
            R.drawable.traffic, R.drawable.traffic_commodity_wise, R.drawable.average_turnaround_time,
            R.drawable.average_output_per_ship, R.drawable.anual_overseas_coastal_traffic,
            R.drawable.river_notice_least_available, R.drawable.projects_under_sagarmala, R.drawable.sagarmala_beneficiaries,
            R.drawable.monthly_statement_of_cargo};

    private int[] colorCodeArray = new int[]{R.color.daily_vessel_position, R.color.traffic, R.color.commodity_wise,
            R.color.average_turnaround_time, R.color.average_output_pser_ship, R.color.annual_overseas_coastal_traffic,
            R.color.river_notice_least_available, R.color.projects_under_sagarmala, R.color.sagarmala_beneficiaries,
            R.color.monthly_statement_of_cargo};

    private ArrayList<Color> colorArrayList = new ArrayList<>();

    public DashBoardAdapter(Context context) {
        this.context = context;
//        homeScreenButtonInterface = (HomeScreenButtonInterface) context;
//        colorArrayList.add(Color)
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content_dash_board_details, null, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setWidgetValue(position);

    }

    @Override
    public int getItemCount() {
        return drawableImageArray.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RelativeLayout rlDashBoardDetailSubParent;
        private CardView cvDashBoardBackGround;
        private ImageView ivDashBoardIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rlDashBoardDetailSubParent = itemView.findViewById(R.id.rlDashBoardDetailSubParent);
            cvDashBoardBackGround = itemView.findViewById(R.id.cvDashBoardBackGround);
            ivDashBoardIcon = itemView.findViewById(R.id.ivDashBoardIcon);
            itemView.setOnClickListener(this);
        }

        public void setWidgetValue(int position) {
            if (position == 4 || position == 5) {
                final float inPixels = context.getResources().getDimension(R.dimen.dashboard_image_icon_size);
                ViewGroup.LayoutParams params = ivDashBoardIcon.getLayoutParams();
                params.width = (int) inPixels;
                params.height = (int) inPixels;
                ivDashBoardIcon.setLayoutParams(params);
            }

            ivDashBoardIcon.setBackgroundResource(drawableImageArray[position]);
            cvDashBoardBackGround.setCardBackgroundColor(ContextCompat.getColor(context, colorCodeArray[position]));
            cvDashBoardBackGround.setRadius(10);
            Drawable background = rlDashBoardDetailSubParent.getBackground();

            if (background instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) background;
                gradientDrawable.setColor(ContextCompat.getColor(context, colorCodeArray[position]));
                gradientDrawable.setCornerRadius(10);
                gradientDrawable.setStroke(2, Color.WHITE);
            }
        }

        @Override
        public void onClick(View view) {
            if (ConnectivityReceiver.isConnected()) {
                context.startActivity(new Intent(context, DashBoardClickUrlActivity.class));
            }else {
                Toast.makeText(context, "Please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
