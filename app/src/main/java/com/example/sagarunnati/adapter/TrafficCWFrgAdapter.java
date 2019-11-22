package com.example.sagarunnati.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sagarunnati.R;
import com.example.sagarunnati.model.traffic_commodity_wise.LatestDate;
import com.example.sagarunnati.model.traffic_commodity_wise.TrafficCommodityWiseDataItem;
import com.example.sagarunnati.model.traffic_commodity_wise.TrafficCommodityWiseResponse;
import com.example.sagarunnati.utility.DateUtility;
import com.example.sagarunnati.utility.RequestParameter;

import java.util.List;

public class TrafficCWFrgAdapter extends RecyclerView.Adapter<TrafficCWFrgAdapter.ViewHolder> {

    private Context context;
    private TrafficCommodityWiseResponse trafficCommodityWiseResponse;
    private List<TrafficCommodityWiseDataItem> dataItemList;
    private TrafficCommodityWiseDataItem dataItem;
    private LatestDate latestDate;
    private String previousYear = "";
    private RequestParameter requestParameter;

    public TrafficCWFrgAdapter(Context context, TrafficCommodityWiseResponse trafficCommodityWiseResponse, RequestParameter requestParameter) {
        this.context = context;
        this.trafficCommodityWiseResponse = trafficCommodityWiseResponse;
        this.requestParameter = requestParameter;
        this.dataItemList = trafficCommodityWiseResponse.getData();
        this.latestDate = trafficCommodityWiseResponse.getLatestDate();
        this.previousYear = DateUtility.selectedPreviousYear(latestDate.getFinYear());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content_tcw_layout, null, false);
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

        private LinearLayout llTCWAdpPreYearRecord;
        private View viewTCWAdpLineBtwCrnAndPreRecord;


        private TextView tvTCWAdpPortName, tvTCWAdpPeriod, tvTCWAdpLPG, tvTCWAdpOtherLiquid,
                tvTCWAdpIronOre, tvTCWAdpFin, tvTCWAdpRaw, tvTCWAdpThermal, tvTCWAdpCoking,
                tvTCWAdpTonnage, tvTCWAdpTeus, tvTCWAdpOthersMiscCarg, tvTCWAdpTotal;

        private TextView tvTCWAdpPortNamePre, tvTCWAdpPeriodPre, tvTCWAdpLPGPre, tvTCWAdpOtherLiquidPre,
                tvTCWAdpIronOrePre, tvTCWAdpFinPre, tvTCWAdpRawPre, tvTCWAdpThermalPre, tvTCWAdpCokingPre,
                tvTCWAdpTonnagePre, tvTCWAdpTeusPre, tvTCWAdpOthersMiscCargPre, tvTCWAdpTotalPre;

        private TextView tvTCWAdpVariation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            llTCWAdpPreYearRecord = itemView.findViewById(R.id.llTCWAdpPreYearRecord);
            viewTCWAdpLineBtwCrnAndPreRecord = itemView.findViewById(R.id.viewTCWAdpLineBtwCrnAndPreRecord);


            tvTCWAdpPortName = itemView.findViewById(R.id.tvTCWAdpPortName);
            tvTCWAdpPeriod = itemView.findViewById(R.id.tvTCWAdpPeriod);
            tvTCWAdpLPG = itemView.findViewById(R.id.tvTCWAdpLPG);
            tvTCWAdpOtherLiquid = itemView.findViewById(R.id.tvTCWAdpOtherLiquid);

            tvTCWAdpIronOre = itemView.findViewById(R.id.tvTCWAdpIronOre);
            tvTCWAdpFin = itemView.findViewById(R.id.tvTCWAdpFin);
            tvTCWAdpRaw = itemView.findViewById(R.id.tvTCWAdpRaw);
            tvTCWAdpThermal = itemView.findViewById(R.id.tvTCWAdpThermal);
            tvTCWAdpCoking = itemView.findViewById(R.id.tvTCWAdpCoking);

            tvTCWAdpTonnage = itemView.findViewById(R.id.tvTCWAdpTonnage);
            tvTCWAdpTeus = itemView.findViewById(R.id.tvTCWAdpTeus);
            tvTCWAdpOthersMiscCarg = itemView.findViewById(R.id.tvTCWAdpOthersMiscCarg);
            tvTCWAdpTotal = itemView.findViewById(R.id.tvTCWAdpTotal);


            tvTCWAdpPeriodPre = itemView.findViewById(R.id.tvTCWAdpPeriodPre);
            tvTCWAdpLPGPre = itemView.findViewById(R.id.tvTCWAdpLPGPre);
            tvTCWAdpOtherLiquidPre = itemView.findViewById(R.id.tvTCWAdpOtherLiquidPre);

            tvTCWAdpIronOrePre = itemView.findViewById(R.id.tvTCWAdpIronOrePre);
            tvTCWAdpFinPre = itemView.findViewById(R.id.tvTCWAdpFinPre);
            tvTCWAdpRawPre = itemView.findViewById(R.id.tvTCWAdpRawPre);
            tvTCWAdpThermalPre = itemView.findViewById(R.id.tvTCWAdpThermalPre);
            tvTCWAdpCokingPre = itemView.findViewById(R.id.tvTCWAdpCokingPre);

            tvTCWAdpTonnagePre = itemView.findViewById(R.id.tvTCWAdpTonnagePre);
            tvTCWAdpTeusPre = itemView.findViewById(R.id.tvTCWAdpTeusPre);
            tvTCWAdpOthersMiscCargPre = itemView.findViewById(R.id.tvTCWAdpOthersMiscCargPre);
            tvTCWAdpTotalPre = itemView.findViewById(R.id.tvTCWAdpTotalPre);

            tvTCWAdpVariation = itemView.findViewById(R.id.tvTCWAdpVariation);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        }

        public void setWidgetsValue(int position) {
            dataItem = dataItemList.get(position);
            tvTCWAdpPortName.setText(dataItem.getPortName());
            tvTCWAdpPeriod.setText("Apr - " + latestDate.getMonthName() + " ' " + latestDate.getFinYear());
            tvTCWAdpLPG.setText(dataItem.getCurrPol());
            tvTCWAdpOtherLiquid.setText(dataItem.getCurrOtherLiquid());

            tvTCWAdpIronOre.setText(dataItem.getCurrIronOre());
            tvTCWAdpFin.setText(dataItem.getCurrFertFin());
            tvTCWAdpRaw.setText(dataItem.getCurrFertRaw());
            tvTCWAdpThermal.setText(dataItem.getCurrCoalTherm());
            tvTCWAdpCoking.setText(dataItem.getCurrCoalCooking());

            tvTCWAdpTonnage.setText(dataItem.getCurrContTong());
            tvTCWAdpTeus.setText(dataItem.getCurrContTeu());
            tvTCWAdpOthersMiscCarg.setText(dataItem.getCurrOtherMiscCargo());
            tvTCWAdpTotal.setText(String.valueOf(dataItem.getCurrSumTotal()));


            if (requestParameter.getAccessToken() != null) {
                llTCWAdpPreYearRecord.setVisibility(View.VISIBLE);
                llTCWAdpPreYearRecord.setBackgroundColor(context.getColor(R.color.rate_card_bg_color));
                viewTCWAdpLineBtwCrnAndPreRecord.setVisibility(View.VISIBLE);
                tvTCWAdpVariation.setVisibility(View.VISIBLE);
                tvTCWAdpPeriodPre.setText("Apr - " + latestDate.getMonthName() + " ' " + previousYear);
                tvTCWAdpLPGPre.setText(dataItem.getPrevPol());
                tvTCWAdpOtherLiquidPre.setText(dataItem.getPrevOtherLiquid());

                tvTCWAdpIronOrePre.setText(dataItem.getPrevIronOre());
                tvTCWAdpFinPre.setText(dataItem.getPrevFertFin());
                tvTCWAdpRawPre.setText(dataItem.getPrevFertRaw());
                tvTCWAdpThermalPre.setText(dataItem.getPrevCoalTherm());
                tvTCWAdpCokingPre.setText(dataItem.getPrevCoalCooking());

                tvTCWAdpTonnagePre.setText(dataItem.getPrevContTong());
                tvTCWAdpTeusPre.setText(dataItem.getPrevContTeu());
                tvTCWAdpOthersMiscCargPre.setText(dataItem.getPrevOtherMiscCargo());
                tvTCWAdpVariation.setText(dataItem.getVariation());
                tvTCWAdpTotalPre.setText(String.valueOf(dataItem.getPrevSumTotal()));
                if (dataItemList.size() - 1 == position) {
                    llTCWAdpPreYearRecord.setVisibility(View.GONE);
                }
            }

        }
    }
}
