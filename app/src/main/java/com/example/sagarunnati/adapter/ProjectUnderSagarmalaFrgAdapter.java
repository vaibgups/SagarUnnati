package com.example.sagarunnati.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sagarunnati.R;
import com.example.sagarunnati.model.project_under_sagarmala.ProjectUnderSagarmalaDataItem;
import com.example.sagarunnati.model.project_under_sagarmala.ProjectUnderSagarmalaResponse;

import java.util.List;

public class ProjectUnderSagarmalaFrgAdapter extends RecyclerView.Adapter<ProjectUnderSagarmalaFrgAdapter.ViewHolder> {

    private Context context;
    private ProjectUnderSagarmalaResponse projectUnderSagarmalaResponse;
    private List<ProjectUnderSagarmalaDataItem> dataItemList;
    private ProjectUnderSagarmalaDataItem dataItem;

    public ProjectUnderSagarmalaFrgAdapter(Context context, ProjectUnderSagarmalaResponse projectUnderSagarmalaResponse) {
        this.context = context;
        this.projectUnderSagarmalaResponse = projectUnderSagarmalaResponse;
        this.dataItemList = projectUnderSagarmalaResponse.getData();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content_psu_layout, null, false);
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

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvPSUAdpTitle, tvPSUAdpValue, tvPSUAdpCost;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPSUAdpTitle = itemView.findViewById(R.id.tvPSUAdpTitle);
            tvPSUAdpValue = itemView.findViewById(R.id.tvPSUAdpValue);
            tvPSUAdpCost = itemView.findViewById(R.id.tvPSUAdpCost);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        }

        public void setWidgetsValue(int position) {
            dataItem = dataItemList.get(position);
            tvPSUAdpTitle.setText(dataItem.getProgrammeName());
            tvPSUAdpValue.setText(dataItem.getProjectValues());
            tvPSUAdpCost.setText(dataItem.getProjectCost());
        }
    }
}
