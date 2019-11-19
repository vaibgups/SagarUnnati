package com.example.sagarunnati.utility;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.sagarunnati.R;
import com.example.sagarunnati.activity.UserAfterLoginActivity;
import com.example.sagarunnati.model.login.LoginResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.example.sagarunnati.utility.Api.BASE_URL;
import static com.example.sagarunnati.utility.Api.VALIDATE_USER;

public class CustomDialogBoxLogin implements View.OnClickListener,
        VolleyService.InterfaceVolleyResult {

    private Activity activity;
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
    private ImageView ivCstDigCancel;
    private EditText edtCstDigRegEnterName, edtCstDigRegEnterEmail, edtCstDigRegEnterPhoneNumber, edtCstDigRegEnterPortOtherName;
    private Button btnCstDigRegSubmit;
    private Spinner edtCstDigRegEnterPort;

    private VolleyService volleyService;
    private RequestParameter requestParameter;
    private LoginResponse loginResponse;
    private SharedPreferenceData mSharedPreferenceData;

    public CustomDialogBoxLogin(Context context) {
        this.context = context;
        this.activity = (Activity) context;
    }

    public void initCustomDialog() {
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.default_custom_dialog_box_login);

        tvCstDigHeadForm = dialog.findViewById(R.id.tvCstDigHeadForm);
        ivCstDigCancel = dialog.findViewById(R.id.ivCstDigCancel);
        ivCstDigCancel.setOnClickListener(this);

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
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivCstDigCancel: {

                dialog.dismiss();
                break;
            }
            case R.id.btnCstDigLogin: {

                validateLogin();
                break;
            }
            case R.id.tvCstDigLoginForgetPassword: {

                break;
            }
            case R.id.tvCstDigLoginRegister: {

                llCstDigLoginParent.setVisibility(View.GONE);
                viewRL.setVisibility(View.VISIBLE);
                tvCstDigHeadForm.setText("Sign up");

                break;
            }
            case R.id.btnCstDigRegSubmit: {

                llCstDigLoginParent.setVisibility(View.VISIBLE);
                viewRL.setVisibility(View.GONE);
                tvCstDigHeadForm.setText("LOGIN");

                break;
            }
        }
    }

    private void validateLogin() {
        String emailID = edtCstDigLoginId.getText().toString();
        String password = edtCstDigLoginPassword.getText().toString();
        String hashPassword = get_SHA_512_SecurePassword(password);
        requestParameter = new RequestParameter();
        requestParameter.setLoginEmail(emailID);
        requestParameter.setLoginPassword(hashPassword);
        getContactUsContent();


    }


    public String get_SHA_512_SecurePassword(String passwordToHash) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    private void getContactUsContent() {
        volleyService = new VolleyService(CustomDialogBoxLogin.this, context);
        volleyService.postStringRequestWithParam(VALIDATE_USER, BASE_URL+VALIDATE_USER, requestParameter.getHashMap());
    }

    @Override
    public void notifySuccess(String requestType, String response) {
        Logger.v(requestType,response);
        if (requestType.equals(VALIDATE_USER)){
            loginResponse = volleyService.getGson().fromJson(response, LoginResponse.class);
            if (loginResponse.isStatus()){
                Toast.makeText(context, loginResponse.getMsg(),
                        Toast.LENGTH_SHORT).show();
                mSharedPreferenceData = SharedPreferenceData.getInstance(context);
                mSharedPreferenceData.put(LoginResponse.class.getSimpleName(),response);
                dialog.dismiss();
                context.startActivity(new Intent(context, UserAfterLoginActivity.class));
                activity.finish();

            }else {
                Toast.makeText(context, loginResponse.getMsg(),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void notifyError(String requestType, VolleyError error) {

        Logger.v(requestType,""+error.getMessage());
    }
}
