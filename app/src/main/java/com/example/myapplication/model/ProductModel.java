package com.example.myapplication.model;

public class ProductModel {
    private final String reference;
    private final float weight;
    private final int[] dimension;
    private final float value;

    public String getReference(){ return this.reference; }
    public float getWeight(){ return this.weight; }
    public int[] getDimension() { return dimension; }
    public float getValue(){ return this.value; }

    public ProductModel(String reference, float weight, int[] dimension, float value){
        this.reference = reference;
        this.weight = weight;
        this.dimension = dimension;
        this.value = value;
    }
}
