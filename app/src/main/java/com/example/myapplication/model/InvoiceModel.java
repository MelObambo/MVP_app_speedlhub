package com.example.myapplication.model;

public class InvoiceModel {
    private final int id;
    private final float price;

    public int getId() { return this.id; }
    public float getPrice() { return this.price; }

    public InvoiceModel(int id, float price) {
        this.id = id;
        this.price = price;
    }
}
