package com.example.sagarunnati.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sagarunnati.R;
import com.example.sagarunnati.model.daily_vessel.DailyVesselDataItem;
import com.example.sagarunnati.model.daily_vessel.DailyVesselResponse;

import java.util.List;

public class DailyVesselFrgAdapter extends RecyclerView.Adapter<DailyVesselFrgAdapter.ViewHolder> {

    private static final String TAG = DailyVesselFrgAdapter.class.getSimpleName();

    private Context context;
    private DailyVesselResponse dailyVesselResponse;
    private List<DailyVesselDataItem> dataItemList;
    private DailyVesselDataItem dataItem;

    public DailyVesselFrgAdapter(Context context, DailyVesselResponse dailyVesselResponse) {
        this.context = context;
        this.dailyVesselResponse = dailyVesselResponse;
        this.dataItemList = dailyVesselResponse.getData();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content_dvp_layout, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setWidgetsValue(position);
    }

    @Override
    public int getItemCount() {
        return dataItemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvDSVAdpSerialNo, tvDSVAdpPortName, tvDSVAdpNoOfVesselAtBerth, tvDSVAdpNoOfVesselAtAnchorage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDSVAdpSerialNo = itemView.findViewById(R.id.tvDSVAdpSerialNo);
            tvDSVAdpPortName = itemView.findViewById(R.id.tvDSVAdpPortName);
            tvDSVAdpNoOfVesselAtBerth = itemView.findViewById(R.id.tvDSVAdpNoOfVesselAtBerth);
            tvDSVAdpNoOfVesselAtAnchorage = itemView.findViewById(R.id.tvDSVAdpNoOfVesselAtAnchorage);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Toast.makeText(context, ""+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void setWidgetsValue(int position) {
            dataItem = dataItemList.get(position);
            tvDSVAdpSerialNo.setText(String.valueOf(position + 1));
            tvDSVAdpPortName.setText(dataItem.getPortName());
            tvDSVAdpNoOfVesselAtBerth.setText(dataItem.getAtBerth());
            tvDSVAdpNoOfVesselAtAnchorage.setText(dataItem.getAtAnchor());

        }
    }

}
