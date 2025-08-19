package com.example.myapplication.ui.address;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.FragmentAddressBinding;
import com.example.myapplication.model.AddressModel;
import com.example.myapplication.tools.AddressAdapter;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AddressFragment extends Fragment {

    private FragmentAddressBinding binding;
    private MaterialButton mbFilter;
    private EditText etSearch, etPeriod;
    private Spinner sType;

    private AddressViewModel addressViewModel;
    private ArrayList<AddressModel> addresses = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addressViewModel = new ViewModelProvider(this).get(AddressViewModel.class);
        binding = FragmentAddressBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = binding.addressRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        AddressAdapter addressAdapter = new AddressAdapter(new ArrayList<>());
        recyclerView.setAdapter(addressAdapter);

        addressViewModel = new ViewModelProvider(this).get(AddressViewModel.class);
        addressViewModel.getTable().observe(getViewLifecycleOwner(), addresses -> {
            android.util.Log.d("Adapter", "item count: " + this.addresses.size());
            addressAdapter.setAddressList(addresses);
        });

        this.mbFilter = binding.addressFilterButton;
        this.etSearch = binding.addressSearch;
        this.etPeriod = binding.addressPeriod;
        this.sType = binding.addressType;
        mbFilter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (!etSearch.getText().toString().isEmpty() ||
                    !etPeriod.getText().toString().isEmpty() ||
                    !sType.getSelectedItem().toString().isEmpty()) {
                    ArrayList<AddressModel> updatedAddresses = addressUpdate();
                    addressAdapter.setAddressList(updatedAddresses);
                }
            }
        });
    }

    private ArrayList<AddressModel> addressUpdate() {
        String label = etSearch.getText().toString();
        String type = sType.getSelectedItem().toString();
        ArrayList<AddressModel> updatedAddresses = addresses
                .stream()
                .filter(am ->
                        (label.equalsIgnoreCase(am.getFirstname()) ||
                                label.equalsIgnoreCase(am.getSurname()) ||
                                label.equalsIgnoreCase(am.getCorporateName()) ||
                                label.equalsIgnoreCase(am.getMail()) ||
                                label.equalsIgnoreCase(am.getPhone()) ||
                                label.equalsIgnoreCase(am.getCountry()) ||
                                label.equalsIgnoreCase(am.getPostCode()) ||
                                label.equalsIgnoreCase(am.getCity()) ||
                                label.equalsIgnoreCase(am.getStreet())) &&
                                type.equalsIgnoreCase(am.getType()))
                .collect(Collectors.toCollection(ArrayList::new));

        android.util.Log.d("Search", "item count: " + updatedAddresses.size());
        return updatedAddresses;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}