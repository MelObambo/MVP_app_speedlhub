package com.example.myapplication.ui.invoice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentInvoiceBinding;

public class InvoiceFragment extends Fragment {

    private FragmentInvoiceBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        InvoiceViewModel invoiceViewModelViewModel =
                new ViewModelProvider(this).get(InvoiceViewModel.class);

        binding = FragmentInvoiceBinding.inflate(inflater, container, false);
        //View root = binding.getRoot();

        //final TextView textView = binding.textInvoice;
        // invoiceViewModelViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
