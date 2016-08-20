/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.rajanks.digitaldiary.Presenter.Login;

import com.rajanks.digitaldiary.Model.Login.LoginInteractor;
import com.rajanks.digitaldiary.Model.Login.LoginInteractorContract;
import com.rajanks.digitaldiary.UI.Activities.Login.LoginActivityContract;

public class LoginPresenter implements LoginPresenterContract, LoginInteractorContract.OnLoginFinishedListener {

    private LoginActivityContract loginActivityContract;
    private LoginInteractorContract loginInteractorContract;

    public LoginPresenter(LoginActivityContract loginActivityContract) {
        this.loginActivityContract = loginActivityContract;
        this.loginInteractorContract = new LoginInteractor();
    }

    @Override
    public void validateCredentials(String mobileNumber, String password) {
        loginInteractorContract.login(mobileNumber, password, this);
    }

    @Override
    public void onDestroy() {
        loginActivityContract = null;
    }

    @Override
    public void onUsernameError() {
        if (loginActivityContract != null) {
            loginActivityContract.setUsernameError();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginActivityContract != null) {
            loginActivityContract.setPasswordError();
        }
    }

    @Override
    public void onInvalidCredentials() {
        if(loginActivityContract != null){
            loginActivityContract.hideProgress();
            loginActivityContract.showInvalidMessage();
        }
    }

    @Override
    public void onSuccess() {
        if (loginActivityContract != null) {
            loginActivityContract.hideProgress();
            loginActivityContract.navigateToHome();
        }
    }

    @Override
    public void startedAuthenticating() {
        if (loginActivityContract != null) {
            loginActivityContract.showProgress();
        }

    }
}
