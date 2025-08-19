package com.example.myapplication.model;

public class AddressModel {
    private final int id;
    private final String type;
    private final String firstname;
    private final String surname;
    private String corporateName;
    private final String mail;
    private final String phone;
    private final String country;
    private final String postCode;
    private final String city;
    private final String street;
    private String addressComplement;

    public int getId() {
        return this.id;
    }
    public String getType() {
        return this.type;
    }
    public String getFirstname() {
        return this.firstname;
    }
    public String getSurname() {
        return this.surname;
    }
    public String getCorporateName () {
        return this.corporateName;
    }
    public String getMail() {
        return this.mail;
    }
    public String getPhone() {
        return this.phone;
    }
    public String getCountry() {
        return this.country;
    }
    public String getPostCode() {
        return this.postCode;
    }
    public String getCity() {
        return this.city;
    }
    public String getStreet(){
        return this.street;
    }
    public String getAddressComplement() {
        return this.addressComplement;
    }

    public AddressModel(int id,
                        String type,
                        String firstname,
                        String surname,
                        String corporateName,
                        String mail,
                        String phone,
                        String country,
                        String postCode,
                        String city,
                        String street,
                        String addressComplement){
        this.id = id;
        this.type = type;
        this.firstname = firstname;
        this.surname = surname;
        this.corporateName = corporateName;
        this.mail = mail;
        this.phone = phone;
        this.country = country;
        this.postCode = postCode;
        this.city = city;
        this.street = street;
        this.addressComplement = addressComplement;
    }
}