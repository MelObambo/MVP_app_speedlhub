package com.example.myapplication.ui.dashboard;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    Button buttonDay, buttonMonth, buttonYear, buttonDayOne, buttonMonthOne, buttonYearOne, searchButton;
    ImageButton buttonDatePicker;
    EditText editTextDate;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModelViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        //View root = binding.getRoot();

        //final TextView textView = binding.textDashboard;
        // dashboardViewModelViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.buttonDay = binding.dashboardSearchTimeDay;
        this.buttonMonth = binding.dashboardSearchTimeMonth;
        this.buttonYear = binding.dashboardSearchTimeYear;
        this.buttonDayOne = binding.dashboardSearchTimeDayOne;
        this.buttonMonthOne = binding.dashboardSearchTimeMonth;
        this.buttonYearOne = binding.dashboardSearchTimeYearOne;
        this.searchButton = binding.dashboardSearchTimeButton;
        this.buttonDatePicker = binding.dashboardSearchTimeDateButton;
        this.editTextDate = binding.dashboardSearchTimeDateEdittext;

        int maxLength = 8;
        InputFilter[] filterArray = new InputFilter[1];
        filterArray[0] = new InputFilter.LengthFilter(maxLength);
        editTextDate.setFilters(filterArray);

        editTextDate.addTextChangedListener(new TextWatcher() {
            int charLength;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                charLength = s.length()+1;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = editTextDate.getText().toString();
                if(charLength <= input.length()) {
                    if (input.matches("\\d{2}") || input.matches("\\d{2}/\\d{2}"))
                        editTextDate.getText().append('/');
                // condition doesn't work
                } else if (input.endsWith("/"))
                    editTextDate.getText().delete(input.length()-1, 1);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}