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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sagarunnati.R;
import com.example.sagarunnati.activity.DashBoardClickUrlActivity;
import com.example.sagarunnati.appliaction.MyApplication;
import com.example.sagarunnati.mInterface.HomeScreenButtonInterface;
import com.example.sagarunnati.model.performance.PerformanceResponse;
import com.example.sagarunnati.utility.ConnectivityReceiver;

import java.util.ArrayList;
import java.util.List;

public class DashBoardAdapter extends RecyclerView.Adapter<DashBoardAdapter.ViewHolder> {

    private final String TAG = MyApplication.TAG + DashBoardAdapter.class.getSimpleName();

    private Context context;
    private List<PerformanceResponse> responseList;
    private PerformanceResponse performanceResponseDataItem;


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

 /*   public DashBoardAdapter(Context context) {
        this.context = context;
//        homeScreenButtonInterface = (HomeScreenButtonInterface) context;
//        colorArrayList.add(Color)
    }
*/
    public DashBoardAdapter(Context context, List<PerformanceResponse> responseList) {
        this.context = context;
        this.responseList = responseList;
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
//        return drawableImageArray.length;
        return responseList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RelativeLayout rlDashBoardDetailSubParent;
        private CardView cvDashBoardBackGround;
        private ImageView ivDashBoardIcon;
        private TextView tvDashbordHead, tvDashbordSubHead1, tvDashbordSubHead1_1,
                tvDashbordSubHead2, tvDashbordSubHead2_1, tvDashbordSubHead3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rlDashBoardDetailSubParent = itemView.findViewById(R.id.rlDashBoardDetailSubParent);
            cvDashBoardBackGround = itemView.findViewById(R.id.cvDashBoardBackGround);
            ivDashBoardIcon = itemView.findViewById(R.id.ivDashBoardIcon);
            tvDashbordHead = itemView.findViewById(R.id.tvDashbordHead);
            tvDashbordSubHead1 = itemView.findViewById(R.id.tvDashbordSubHead1);
//            tvDashbordSubHead1_1 = itemView.findViewById(R.id.tvDashbordSubHead1_1);
            tvDashbordSubHead2 = itemView.findViewById(R.id.tvDashbordSubHead2);
//            tvDashbordSubHead2_1 = itemView.findViewById(R.id.tvDashbordSubHead2_1);
            tvDashbordSubHead3 = itemView.findViewById(R.id.tvDashbordSubHead3);
            itemView.setOnClickListener(this);
        }

        public void setWidgetValue(int position) {
            performanceResponseDataItem = responseList.get(position);
            tvDashbordHead.setText(performanceResponseDataItem.getTitle());
            if(!performanceResponseDataItem.getContentOne().equals("")){
                tvDashbordSubHead1.setVisibility(View.VISIBLE);
                tvDashbordSubHead1.setText(performanceResponseDataItem.getContentOne());
            }
            if(!performanceResponseDataItem.getContentTwo().equals("")){
                tvDashbordSubHead2.setVisibility(View.VISIBLE);
                tvDashbordSubHead2.setText(performanceResponseDataItem.getContentTwo());
            }
            if(!performanceResponseDataItem.getFinancialYear().equals("")){
                tvDashbordSubHead3.setVisibility(View.VISIBLE);
                tvDashbordSubHead3.setText(performanceResponseDataItem.getFinancialYear());
            }
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
            context.startActivity(new Intent(context, DashBoardClickUrlActivity.class)
                    .putExtra("FragmentLoad",getAdapterPosition()+1));
        }
    }
}
