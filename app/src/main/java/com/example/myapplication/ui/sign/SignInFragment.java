package com.example.myapplication.ui.sign;

import static androidx.core.app.ActivityCompat.recreate;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentSignInBinding;
import com.example.myapplication.tools.LanguageManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;

public class SignInFragment extends Fragment {
    private Button button;
    private EditText login, password;
    private FragmentSignInBinding binding;
    private FloatingActionButton fab;
    private ImageButton language_button;
    private TextView forgotten_pwd, sign_up;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SignInViewModel signInViewModel =
                new ViewModelProvider(this).get(SignInViewModel.class);
        binding = FragmentSignInBinding.inflate(inflater, container, false);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("flag_drawable", Context.MODE_PRIVATE);
        int flag = sharedPreferences.getInt("flag_drawable", R.drawable.ic_flag_french);
        language_button.setBackground(AppCompatResources.getDrawable(getContext(), flag));

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppCompatActivity activity = (AppCompatActivity) requireActivity();
        if (activity.getSupportActionBar() != null)
            activity.getSupportActionBar().hide();
        fab = requireActivity().findViewById(R.id.fab);
        if(fab != null)
            fab.setVisibility(View.GONE);

        login = binding.signInLogin;
        password = binding.signInPassword;
        forgotten_pwd = binding.signInForgottenPwd;
        sign_up = binding.signUpLink;
        button = binding.signInButton;
        language_button = binding.signInLanguageButton;

        SignInViewModel signInViewModel =
                new ViewModelProvider(this).get(SignInViewModel.class);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //if(signInViewModel.onSignIn(login.getText().toString(), password.getText().toString()) != null) {
                    Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main).navigate(R.id.menu_dashboard);
                //}
            }
        });
        forgotten_pwd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
//                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
//                navController.navigate(R.id.recover_password);
                }
        });
        sign_up.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main).navigate(R.id.sign_up);
            }
        });
        language_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null && getContext() != null) {
                    Locale currentLang = getResources().getConfiguration().getLocales().get(0);
                    LanguageManager languageManager = new LanguageManager(getContext());
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
                    if (currentLang.toLanguageTag().equals("en-GB")) {
                        languageManager.updateResources("fr_FR");
                        prefs.edit().putInt("flag_drawable", R.drawable.ic_flag_chinese).apply();
                        recreate(getActivity());
                    } else if (currentLang.toLanguageTag().equals("fr-FR")) {
                        languageManager.updateResources("zh_ZH");
                        prefs.edit().putInt("flag_drawable", R.drawable.ic_flag_uk).apply();
                        recreate(getActivity());
                    }
                    else {
                        languageManager.updateResources("en_US");
                        prefs.edit().putInt("flag_drawable", R.drawable.ic_flag_french).apply();
                        recreate(getActivity());
                    }
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