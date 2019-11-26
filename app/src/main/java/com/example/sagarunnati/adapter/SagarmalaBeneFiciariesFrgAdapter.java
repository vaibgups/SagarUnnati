package com.example.sagarunnati.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sagarunnati.R;
import com.example.sagarunnati.model.sagarmala_beneficiaries.SgarmalaBeneficiariesDataItem;
import com.example.sagarunnati.model.sagarmala_beneficiaries.SgarmalaBeneficiariesResponse;

import java.util.List;

public class SagarmalaBeneFiciariesFrgAdapter extends RecyclerView.Adapter<SagarmalaBeneFiciariesFrgAdapter.ViewHolder> {

    private static final String TAG = SagarmalaBeneFiciariesFrgAdapter.class.getSimpleName();
    private Context context;
    private SgarmalaBeneficiariesResponse sgarmalaBeneficiariesResponse;
    private List<SgarmalaBeneficiariesDataItem> dataItemList;
    private SgarmalaBeneficiariesDataItem dataItem;

    public SagarmalaBeneFiciariesFrgAdapter(Context context, SgarmalaBeneficiariesResponse sgarmalaBeneficiariesResponse) {
        this.context = context;
        this.sgarmalaBeneficiariesResponse = sgarmalaBeneficiariesResponse;
        this.dataItemList = sgarmalaBeneficiariesResponse.getData();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content_sb_layout, null, false);
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

        private TextView tvSbAdpTitle, tvSbAdpNumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSbAdpTitle = itemView.findViewById(R.id.tvSbAdpTitle);
            tvSbAdpNumber = itemView.findViewById(R.id.tvSbAdpNumber);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        }

        public void setWidgetsValue(int position) {
            dataItem = dataItemList.get(position);
            tvSbAdpTitle.setText(dataItem.getTitle());
            tvSbAdpNumber.setText(dataItem.getValue());
        }
    }
}
