package com.example.myapplication.tools;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.AddressModel;

import java.util.ArrayList;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {
    private ArrayList<AddressModel> addressList;

    public void setAddressList(ArrayList<AddressModel> addressList) {
        this.addressList.clear();
        this.addressList.addAll(addressList);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView etName, etType, etCorporateName, etMail, etPhone, etCountry, etPostCode, etCity, etStreet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.etName = itemView.findViewById(R.id.name_edit_text);
            this.etType = itemView.findViewById(R.id.type_edit_text);
            this.etCorporateName = itemView.findViewById(R.id.corporate_name_edit_text);
            this.etMail = itemView.findViewById(R.id.mail_edit_text);
            this.etPhone = itemView.findViewById(R.id.phone_edit_text);
            this.etCountry = itemView.findViewById(R.id.country_edit_text);
            this.etPostCode = itemView.findViewById(R.id.post_code_edit_text);
            this.etCity = itemView.findViewById(R.id.city_edit_text);
            this.etStreet = itemView.findViewById(R.id.street_edit_text);
        }
    }

    @NonNull
    @Override
    public AddressAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.inner_fragment_item_address, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AddressModel addressModel = addressList.get(position);
        String name = addressModel.getFirstname() + " " + addressModel.getSurname();
        holder.etName.setText(name);
        holder.etType.setText(addressModel.getType());
        holder.etCorporateName.setText(addressModel.getCorporateName());
        holder.etMail.setText(addressModel.getMail());
        holder.etPhone.setText(addressModel.getPhone());
        holder.etCountry.setText(addressModel.getCountry());
        holder.etPostCode.setText(addressModel.getPostCode());
        holder.etCity.setText(addressModel.getCity());
        holder.etStreet.setText(addressModel.getStreet());
    }

    @Override
    public int getItemCount() {
        return this.addressList.size();
    }

    public AddressAdapter(ArrayList<AddressModel> addressList) {
        this.addressList = addressList;
    }
}
