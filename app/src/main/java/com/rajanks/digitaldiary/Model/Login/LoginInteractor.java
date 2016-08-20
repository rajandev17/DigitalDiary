package com.rajanks.digitaldiary.Model.Login;

import android.os.Handler;
import android.text.TextUtils;

public class LoginInteractor implements LoginInteractorContract {
    boolean error = false;

    @Override
    public void login(final String mobile, final String password, final OnLoginFinishedListener listener) {
        if (TextUtils.isEmpty(mobile)) {
            listener.onUsernameError();
            error = true;
            return;
        } else {
            error = false;
        }
        if (TextUtils.isEmpty(password)) {
            listener.onPasswordError();
            error = true;
            return;
        } else {
            error = false;
        }
        listener.startedAuthenticating();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!(mobile.equalsIgnoreCase("7416272016") && password.equalsIgnoreCase("android"))) {
                    listener.onInvalidCredentials();
                    error = true;
                }
                if (!error) {
                    listener.onSuccess();
                }
            }
        }, 4000);
    }
}
