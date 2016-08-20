package com.rajanks.digitaldiary.UI.Activities.Login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.rajanks.digitaldiary.BuildConfig;
import com.rajanks.digitaldiary.Presenter.Login.LoginPresenter;
import com.rajanks.digitaldiary.Presenter.Login.LoginPresenterContract;
import com.rajanks.digitaldiary.R;
import com.rajanks.digitaldiary.UI.Activities.MainActivity;
import com.rajanks.digitaldiary.Util.AppBase;
import com.rajanks.digitaldiary.Util.Util;


public class LoginActivity extends Activity implements LoginActivityContract, View.OnClickListener {

    private EditText mobile;
    private EditText password;
    private LoginPresenterContract presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        mobile = (EditText) findViewById(R.id.mobile);
        password = (EditText) findViewById(R.id.password);

        if(BuildConfig.DEBUG){
            mobile.setText("7416272016");
            password.setText("android");
        }

        mobile.setHintTextColor(Color.parseColor("#99bbbbbb"));
        password.setHintTextColor(Color.parseColor("#99bbbbbb"));

        findViewById(R.id.button).setOnClickListener(this);

        presenter = new LoginPresenter(this);
    }

    @Override
    public void showProgress() {
        Util.showProgressDialog(this,"Verifying Credentials . . .");
    }

    @Override
    public void hideProgress() {
        Util.hideProgressBar();
    }

    @Override
    public void setUsernameError() {
        mobile.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void showInvalidMessage() {
        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {
        AppBase.getInstance().setName("Rajan ks");
        AppBase.getInstance().setDetail("Roll Number 17,Class - 10 A");
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void onClick(View v) {
        presenter.validateCredentials(mobile.getText().toString(), password.getText().toString());
    }
}
