package com.example.myapplication.model;

public class PackageModel {
    private final int id;
    private final int quantity;
    private final String type;
    private final ProductModel productModel;

    public int getId() { return this.id; }
    public int getQuantity() { return this.quantity; }
    public String getType() { return this.type; }
    public ProductModel getProductModel() { return productModel; }

    public PackageModel(int id, int quantity, String type, ProductModel productModel){
        this.id = id;
        this.quantity = quantity;
        this.type = type;
        this.productModel = productModel;
    }
}