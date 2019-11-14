package com.example.sagarunnati.utility;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.example.sagarunnati.R;

import java.util.Arrays;
import java.util.List;

public class SpinnerYearMonth {
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


    public SpinnerYearMonth(Context context) {
        this.context = context;
        this.activity = (Activity) context;
        this.selectedYearMonthInterFace = (SelectedYearMonthInterFace) context;
        init();
        loadSpinner();
    }

    public SpinnerYearMonth(Context context, RequestParameter requestParameter) {
        this.context = context;
        this.requestParameter = requestParameter;
        this.activity = (Activity) context;
        this.selectedYearMonthInterFace = (SelectedYearMonthInterFace) activity;
        init();
        loadSpinner();

    }

    public SpinnerYearMonth(Fragment fragment, Context context, View view) {
        this.context = context;
        this.view = view;
        this.fragment = fragment;
        this.activity = (Activity) context;
        this.selectedYearMonthInterFace = (SelectedYearMonthInterFace) fragment;
        initByView();
        loadSpinner();
    }

    private void init() {
        year = activity.findViewById(R.id.year);
        month = activity.findViewById(R.id.month);
    }

    private void initByView() {
        year = view.findViewById(R.id.year);
        month = view.findViewById(R.id.month);
    }

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

    public interface SelectedYearMonthInterFace {
        void selectedYear(String selectedYear);
        void selectedMonth(int selectedMonth, String selectedMonthString);
    }
}
