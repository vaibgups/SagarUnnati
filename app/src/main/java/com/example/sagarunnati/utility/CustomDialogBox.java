package com.example.sagarunnati.utility;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sagarunnati.R;

public class CustomDialogBox implements View.OnClickListener {
    private Context context;
    private Dialog dialog;
    private JustifiedTextView tvCstDigMessage;
    private Button btnCstDigDecline, btnCstDigAccept;

    public CustomDialogBox(Context context) {
        this.context = context;
    }

    public void initCustomDialog(){
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.default_custom_dialog_box);
        tvCstDigMessage = dialog.findViewById(R.id.tvCstDigMessage);
        btnCstDigDecline = dialog.findViewById(R.id.btnCstDigDecline);
        btnCstDigDecline.setOnClickListener(this);
        btnCstDigAccept = dialog.findViewById(R.id.btnCstDigAccept);
        btnCstDigAccept.setOnClickListener(this);
        dialog.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCstDigDecline:{
                dialog.dismiss();
                break;
            }
            case R.id.btnCstDigAccept:{
                dialog.dismiss();
                break;
            }
        }
    }
}
