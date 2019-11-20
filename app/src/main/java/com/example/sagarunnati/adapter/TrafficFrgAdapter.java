package com.example.sagarunnati.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sagarunnati.R;
import com.example.sagarunnati.model.traffic.TrafficDataItem;
import com.example.sagarunnati.model.traffic.TrafficResponse;

import java.util.List;

public class TrafficFrgAdapter extends RecyclerView.Adapter<TrafficFrgAdapter.ViewHolder>{

    private Context context;
    private TrafficResponse trafficResponse;
    private List<TrafficDataItem> dataItemList;
    private TrafficDataItem dataItem;

    public TrafficFrgAdapter(Context context, TrafficResponse trafficResponse) {
        this.context = context;
        this.trafficResponse = trafficResponse;
        this.dataItemList = trafficResponse.getData();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content_traffic_layout,null, false);
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

        private TextView tvTrfAdpPortName, tvTrfAdpValue;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTrfAdpPortName = itemView.findViewById(R.id.tvTrfAdpPortName);
            tvTrfAdpValue = itemView.findViewById(R.id.tvTrfAdpValue);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Toast.makeText(context, ""+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void setWidgetsValue(int position) {
            dataItem = dataItemList.get(position);
            tvTrfAdpPortName.setText(dataItem.getPortName());
//            tvTrfAdpPortName.setText("Name Test");
            tvTrfAdpValue.setText(String.valueOf(dataItem.getTotalSum()));
//            tvTrfAdpValue.setText(String.valueOf("Number test 1"));
        }
    }
}
