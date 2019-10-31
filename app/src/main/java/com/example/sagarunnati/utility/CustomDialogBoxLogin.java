package com.example.sagarunnati.utility;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sagarunnati.R;

public class CustomDialogBoxLogin implements View.OnClickListener {

    private Context context;
    private Dialog dialog;

    private TextView tvCstDigHeadForm;

//    Login Form Widgets
    private Button btnCstDigLogin;
    private EditText edtCstDigLoginId, edtCstDigLoginPassword;
    private TextView tvCstDigLoginForgetPassword, tvCstDigLoginRegister;
    private LinearLayout llCstDigLoginParent;

//    Register form widgets
    private View viewRL;
    private TextView tvCstDigRegEnterPortOtherName;
    private EditText edtCstDigRegEnterName, edtCstDigRegEnterEmail, edtCstDigRegEnterPhoneNumber, edtCstDigRegEnterPortOtherName;
    private Button btnCstDigRegSubmit;
    private Spinner edtCstDigRegEnterPort;

    public CustomDialogBoxLogin(Context context) {
        this.context = context;
    }

    public void initCustomDialog(){
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.default_custom_dialog_box_login);

        tvCstDigHeadForm = dialog.findViewById(R.id.tvCstDigHeadForm);

//        Login Form Widgets
        edtCstDigLoginId = dialog.findViewById(R.id.edtCstDigLoginId);
        edtCstDigLoginPassword = dialog.findViewById(R.id.edtCstDigLoginPassword);

        btnCstDigLogin = dialog.findViewById(R.id.btnCstDigLogin);
        btnCstDigLogin.setOnClickListener(this);

        tvCstDigLoginForgetPassword = dialog.findViewById(R.id.tvCstDigLoginForgetPassword);
        tvCstDigLoginForgetPassword.setOnClickListener(this);

        tvCstDigLoginRegister = dialog.findViewById(R.id.tvCstDigLoginRegister);
        tvCstDigLoginRegister.setOnClickListener(this);

        llCstDigLoginParent = dialog.findViewById(R.id.llCstDigLoginParent);
        viewRL = dialog.findViewById(R.id.includeRegister);

//        Register Form Widgets
        edtCstDigRegEnterName = dialog.findViewById(R.id.edtCstDigRegEnterName);
        edtCstDigRegEnterEmail = dialog.findViewById(R.id.edtCstDigRegEnterEmail);
        edtCstDigRegEnterPhoneNumber = dialog.findViewById(R.id.edtCstDigRegEnterPhoneNumber);
        edtCstDigRegEnterPortOtherName = dialog.findViewById(R.id.edtCstDigRegEnterPortOtherName);

        tvCstDigRegEnterPortOtherName = dialog.findViewById(R.id.tvCstDigRegEnterPortOtherName);
        edtCstDigRegEnterPort = dialog.findViewById(R.id.edtCstDigRegEnterPort);

        btnCstDigRegSubmit = dialog.findViewById(R.id.btnCstDigRegSubmit);
        btnCstDigRegSubmit.setOnClickListener(this);

        dialog.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCstDigLogin:{

                validateLogin();
                break;
            }
            case R.id.tvCstDigLoginForgetPassword:{

                break;
            }
            case R.id.tvCstDigLoginRegister:{

                llCstDigLoginParent.setVisibility(View.GONE);
                viewRL.setVisibility(View.VISIBLE);
                tvCstDigHeadForm.setText("Sign up");

                break;
            }
            case R.id.btnCstDigRegSubmit:{

                llCstDigLoginParent.setVisibility(View.VISIBLE);
                viewRL.setVisibility(View.GONE);
                tvCstDigHeadForm.setText("LOGIN");

                break;
            }
        }
    }

    private void validateLogin() {

    }
}
