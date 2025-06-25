package com.example.myapplication.ui.sign;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentSignUpBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.net.URL;
import java.net.URLConnection;

public class SignUpFragment extends Fragment {
    private FragmentSignUpBinding binding;
    private FloatingActionButton fab;
    private EditText lastname, firstname, phone, email, password;
    private TextView sign_in, terms, website_link;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AppCompatActivity activity = (AppCompatActivity) requireActivity();
        if (activity.getSupportActionBar() != null)
            activity.getSupportActionBar().hide();

        SignUpViewModel signUpViewModel =
                new ViewModelProvider(this).get(SignUpViewModel.class);

        binding = FragmentSignUpBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fab = (FloatingActionButton) requireActivity().findViewById(R.id.fab);
        if(fab != null)
            fab.setVisibility(View.GONE);

        lastname = binding.signUpLastname;
        firstname = binding.signUpFirstname;
        phone = binding.signUpPhone;
        email = binding.signUpEmail;
        password = binding.signUpPassword;

        sign_in = binding.signInLink;
        terms = binding.termsLink;
        website_link = binding.websiteLink;

        Button button = binding.signUpButton;

        SignUpViewModel signUpViewModel =
                new ViewModelProvider(this).get(SignUpViewModel.class);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Fragment signInFragment = new SignInFragment();
                requireActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.drawer_layout, signInFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        terms.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
           /*     Fragment recoverFragment = new RecoverPasswordFragment();
                requireActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.drawer_layout, recoverFragment)
                        .addToBackStack(null)
                        .commit();
                */}
        });
        website_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    URL url = new URL("https://speedlehub.tactile.ma/home.php");
                    URLConnection connection = url.openConnection();
                    connection.connect();
                } catch (Exception e) {
                    Toast.makeText(getContext(), R.string.link_to_web_error, Toast.LENGTH_SHORT).show();
                }
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