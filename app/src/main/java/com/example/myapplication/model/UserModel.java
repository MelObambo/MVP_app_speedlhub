package com.example.myapplication.model;

public class UserModel {
    private final String firstname;
    private final String surname;
    private final String phone;
    private final String mail;

    public String getFirstname() { return this.firstname; }
    public String getSurname() { return this.surname; }
    public String getPhone() { return this.phone; }
    public String getMail() { return this.mail; }

    public UserModel(String firstname, String surname, String phone, String mail) {
        this.firstname = firstname;
        this.surname = surname;
        this.phone = phone;
        this.mail = mail;
    }
}