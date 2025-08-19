package com.example.myapplication.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.myapplication.R;

public class FilterAdapter extends LinearLayout {
    private EditText datePrimary, dateSecondary, orderNumber, trackingNumber, name, ref;
    private Spinner transportation, country, status, type;

    public void onSearch(String datePrimary,
                         String dateSecondary,
                         String orderNumber,
                         String trackingNumber,
                         String name,
                         String ref,
                         String transportation,
                         String country,
                         String status,
                         String type){
        LinearLayout table = findViewById(R.id.table);
        /*for (int i=0; i<table.getChildCount(); i++){
            TableLayout tableLayout = (TableLayout) getChildAt(i);
            if (LocalDate.parse(datePrimary) > LocalDate.parse(findViewById(R.id.creation_date).toString()) ||
                LocalDate.parse(dateSecondary) < LocalDate.parse(findViewById(R.id.creation_date).toString()) ||
                orderNumber != findViewById(R.id.number_of_packages).toString() ||
                trackingNumber != findViewById(R.id.package_number).toString() ||
                name != findViewById(R.id.name).toString() ||
                ref  != findViewById(R.id.ref).toString() ||


        }*/
    }
    public FilterAdapter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.inner_fragment_filter, this, true);

        ImageButton filterButton = findViewById(R.id.tracking_search);
        this.datePrimary = findViewById(R.id.date_primary);
        this.dateSecondary = findViewById(R.id.date_secondary);
        this.orderNumber = findViewById(R.id.order_number);
        this.trackingNumber = findViewById(R.id.tracking_number);
        this.name = findViewById(R.id.name);
        this.ref = findViewById(R.id.ref);
        this.transportation = findViewById(R.id.transportation);
        this.country = findViewById(R.id.country);
        this.status = findViewById(R.id.status);
        this.type = findViewById(R.id.type);

        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSearch(datePrimary.toString(), dateSecondary.toString(), orderNumber.toString(), trackingNumber.toString(), name.toString(), ref.toString(), transportation.toString(), country.toString(), status.toString(), type.toString());
            }
        });
    }
}
