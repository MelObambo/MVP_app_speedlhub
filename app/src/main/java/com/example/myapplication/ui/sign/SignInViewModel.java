package com.example.myapplication.ui.sign;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.R;
import com.example.myapplication.object.User;
import com.example.myapplication.ui.dashboard.DashboardFragment;

public class SignInViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private MutableLiveData<String> username = new MutableLiveData<>();
    private MutableLiveData<String> password = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();

    public LiveData<String> getUsername() { return username; }
    public LiveData<String> getPassword() { return password; }
    public LiveData<Boolean> getIsLoading() { return isLoading; }
    public LiveData<String> getErrorMessage() { return errorMessage; }

    public SignInViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is sign in fragment");
    }

    public User signIn(String login, String password) {
        //TODO: database calls
        User user = new User();
        return user;
    }

    public LiveData<String> getText() {
        return mText;
    }
}