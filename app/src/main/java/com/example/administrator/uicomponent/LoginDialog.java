package com.example.administrator.uicomponent;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import com.example.administrator.uicomponent.R;

public class LoginDialog extends AlertDialog {

    public LoginDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_login);
        this.setCancelable(true);
    }
}
