package com.example.myapplication.ui.sign;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.tools.JSONParser;
import com.example.myapplication.model.UserModel;

public class SignInViewModel extends ViewModel {

    private MutableLiveData<String> mError = new MutableLiveData<>();

    public LiveData<String> getError() { return mError; }
    /*public UserModel onSignIn(String login, String password) {
        //TODO: api call
        String apiUrl = "";
        String apiKey = "";
        JSONParser jsonParser = new JSONParser();

        

        String firstname = "";
        String surname = "";
        String phone = "";
        String mail = "";
        UserModel user = new UserModel(firstname, surname, phone, mail);
        return user;
    }*/

    public SignInViewModel() {
        mError.setValue("We couldn't log you in. Please check the information you wrote.");
    }
}