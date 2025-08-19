package com.example.myapplication.model;

public class OrderModel {
    private final int id;
    private final String carrier;
    private final PackageModel packageModel;
    private final InvoiceModel invoiceModel;
    private final AddressModel addressModel;

    public int getId() {
        return id;
    }
    public String getCarrier() {
        return carrier;
    }
    public PackageModel getPackageModel() {
        return packageModel;
    }

    public InvoiceModel getInvoiceModel() {
        return invoiceModel;
    }

    public AddressModel getAddressModel() {
        return addressModel;
    }

    public OrderModel(int id, String carrier, PackageModel packageModel, InvoiceModel invoiceModel, AddressModel addressModel){
        this.id = id;
        this.carrier = carrier;
        this.packageModel = packageModel;
        this.invoiceModel = invoiceModel;
        this.addressModel = addressModel;
    }
}
