package com.example.myapplication.ui.sign;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentSignInBinding;
import com.example.myapplication.ui.dashboard.DashboardFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SignInFragment extends Fragment {
    private FragmentSignInBinding binding;
    private FloatingActionButton fab;
    private EditText login, password;
    private TextView forgotten_pwd, sign_up;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SignInViewModel signInViewModel =
                new ViewModelProvider(this).get(SignInViewModel.class);

        binding = FragmentSignInBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppCompatActivity activity = (AppCompatActivity) requireActivity();
        if (activity.getSupportActionBar() != null)
            activity.getSupportActionBar().hide();

        fab = (FloatingActionButton) requireActivity().findViewById(R.id.fab);
        if(fab != null)
            fab.setVisibility(View.GONE);
        login = binding.signInLogin;
        password = binding.signInPassword;
        forgotten_pwd = binding.signInForgottenPwd;
        sign_up = binding.signUpLink;
        Button button = binding.signInButton;

        SignInViewModel signInViewModel =
                new ViewModelProvider(this).get(SignInViewModel.class);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(signInViewModel.signIn(login.getText().toString(), password.getText().toString()) != null) {
                    NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
                    navController.navigate(R.id.menu_dashboard);
                }
            }
        });
        forgotten_pwd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                /*NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.recover_password);*/
                }
        });
        sign_up.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.sign_up);
                }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        AppCompatActivity activity = (AppCompatActivity) requireActivity();
        if (activity.getSupportActionBar() != null)
            activity.getSupportActionBar().show();

        if(fab != null)
            fab.setVisibility(View.VISIBLE);
        binding = null;
    }
}