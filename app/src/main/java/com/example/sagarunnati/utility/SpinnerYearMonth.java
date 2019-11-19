package com.example.sagarunnati.utility;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.example.sagarunnati.R;
import com.example.sagarunnati.model.yearMonth.FinancialMonthItem;
import com.example.sagarunnati.model.yearMonth.YearMonthResponse;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.sagarunnati.utility.Api.BASE_URL;
import static com.example.sagarunnati.utility.Api.YEAR_MONTH_FINANCIAL;

public class SpinnerYearMonth implements VolleyService.InterfaceVolleyResult {
    private static final String TAG = "SpinnerYearMonth";
    private Context context;
    private Activity activity;
    private View view;
    private Spinner year, month;
    private List<String> yearStringArrayList;
    private List<String> monthStringArrayList;
    private String selectedYear;
    private SelectedYearMonthInterFace selectedYearMonthInterFace;
    private RequestParameter requestParameter;
    private Fragment fragment;
    private VolleyService volleyService;
    private Gson gson;
    private YearMonthResponse yearMonthResponse;


   /* public SpinnerYearMonth(Context context) {
        this.context = context;
        this.activity = (Activity) context;
        this.selectedYearMonthInterFace = (SelectedYearMonthInterFace) context;
        init();
        loadSpinner();
    }*/

    public SpinnerYearMonth(Context context, RequestParameter requestParameter) {
        this.context = context;
        this.requestParameter = requestParameter;
        this.activity = (Activity) context;
        this.selectedYearMonthInterFace = (SelectedYearMonthInterFace) activity;
        init();
//        loadSpinner();

    }

   /* public SpinnerYearMonth(Fragment fragment, Context context, View view) {
        this.context = context;
        this.view = view;
        this.fragment = fragment;
        this.activity = (Activity) context;
        this.selectedYearMonthInterFace = (SelectedYearMonthInterFace) fragment;
        initByView();
        loadSpinner();
    }*/

    private void init() {
        year = activity.findViewById(R.id.year);
        month = activity.findViewById(R.id.month);
        volleyService = new VolleyService(SpinnerYearMonth.this,context);
        gson = volleyService.getGson();
        volleyService.postJsonAuthBearerRequest(YEAR_MONTH_FINANCIAL,BASE_URL+YEAR_MONTH_FINANCIAL,requestParameter.getHashMap());


    }

    private void getYearMonth() {
        volleyService.postJsonAuthBearerRequest(YEAR_MONTH_FINANCIAL,BASE_URL+YEAR_MONTH_FINANCIAL,requestParameter.getHashMap());
    }

   /* private void initByView() {
        year = view.findViewById(R.id.year);
        month = view.findViewById(R.id.month);
    }
*/
/*
    private void loadSpinner() {

        yearStringArrayList = Arrays.asList(context.getResources().getStringArray(R.array.spinner_year));
        monthStringArrayList = Arrays.asList(context.getResources().getStringArray(R.array.spinner_month));

        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, yearStringArrayList);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        year.setAdapter(yearAdapter);
        if (requestParameter!= null){
            year.setSelection(yearStringArrayList.indexOf(requestParameter.getFinancialYear()));
        }else {
            year.setSelection(yearStringArrayList.size() - 1);
        }

        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedYear = yearStringArrayList.get(position);
                if (selectedYearMonthInterFace != null) {
                    selectedYearMonthInterFace.selectedYear(selectedYear);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        ArrayAdapter<String> adapter_option = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, monthStringArrayList);
        adapter_option.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        month.setAdapter(adapter_option);
        if (requestParameter!= null){
            month.setSelection(monthStringArrayList.indexOf(monthStringArrayList.get(requestParameter.getFy_month()-1)));
        }else {
            month.setSelection(monthStringArrayList.indexOf(DateUtility.currentMonth()));
        }
        month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (selectedYearMonthInterFace != null) {
                    selectedYearMonthInterFace.selectedMonth(position + 1,monthStringArrayList.get(position));
//                    requestParameter.setSelectedMonth(monthStringArrayList.get(position));
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
*/

    @Override
    public void notifySuccess(String requestType, String response) {
        Logger.v(requestType,response);
        if (requestType.equals(YEAR_MONTH_FINANCIAL)) {
            yearMonthResponse = gson.fromJson(response, YearMonthResponse.class);
            if (yearMonthResponse.isStatus()) {
                loadSpinner();
            }
        }
    }

    private void loadSpinner() {
        yearStringArrayList = yearMonthResponse.getMasterData().getFinancialYear();


        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, yearStringArrayList);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        year.setAdapter(yearAdapter);
        year.setSelection(0);
       /* year.setAdapter(yearAdapter);
        if (requestParameter!= null){
            year.setSelection(yearStringArrayList.indexOf(requestParameter.getFinancialYear()));
        }else {
            year.setSelection(yearStringArrayList.size() - 1);
        }*/

        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedYear = yearStringArrayList.get(position);
                if (selectedYearMonthInterFace != null) {
                    selectedYearMonthInterFace.selectedYear(selectedYear);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        monthStringArrayList = new ArrayList<>();
        for (FinancialMonthItem item : yearMonthResponse.getMasterData().getFinancialMonth()){
            monthStringArrayList.add(item.getFyMonthName().toUpperCase().substring(0,3));
        }

        ArrayAdapter<String> adapter_option = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, monthStringArrayList);
        adapter_option.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        month.setAdapter(adapter_option);
        month.setSelection(monthStringArrayList.indexOf(DateUtility.currentMonth()));
       /* if (requestParameter!= null){
            month.setSelection(monthStringArrayList.indexOf(monthStringArrayList.get(requestParameter.getFy_month()-1)));
        }else {
            month.setSelection(monthStringArrayList.indexOf(DateUtility.currentMonth()));
        }*/
        month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (selectedYearMonthInterFace != null) {
                    selectedYearMonthInterFace.selectedMonth(position,
                            yearMonthResponse.getMasterData().getFinancialMonth());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    @Override
    public void notifyError(String requestType, VolleyError error) {
        Logger.v(requestType,""+error.getMessage().toString());
    }

    public interface SelectedYearMonthInterFace {
        void selectedYear(String selectedYear);
        void selectedMonth(int selectedMonth, List<FinancialMonthItem> financialMonthItemList);
    }
}
