
package com.example.myapplication.ui.shipment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentTrackingBinding;

public class TrackingFragment extends Fragment {

    private FragmentTrackingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TrackingViewModel trackingViewModelViewModel =
                new ViewModelProvider(this).get(TrackingViewModel.class);

        binding = FragmentTrackingBinding.inflate(inflater, container, false);
        //View root = binding.getRoot();

        //final TextView textView = binding.textTracking;
        // trackingViewModelViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}