package com.example.myapplication.model;

public class AddressModel {
    private final int id;
    private final String type;
    private final String firstname;
    private final String surname;
    private final String mail;
    private final String phone;
    private final String country;
    private final String postCode;
    private final String city;
    private final String street;
    private final String addressComplement;

    public int getId() { return id; }
    public String getType() { return type; }
    public String getFirstname() { return firstname; }
    public String getSurname() { return surname; }
    public String getMail() { return mail; }
    public String getPhone() { return phone; }
    public String getCountry() { return country; }
    public String getPostCode() { return postCode; }
    public String getCity() { return city; }
    public String getAddress() { return street; }
    public String getAddressComplement() { return addressComplement; }

    public AddressModel(int id,
                        String type,
                        String firstname,
                        String surname,
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
        this.mail = mail;
        this.phone = phone;
        this.country = country;
        this.postCode = postCode;
        this.city = city;
        this.street = street;
        this.addressComplement = addressComplement;
    }
}