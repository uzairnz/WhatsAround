package com.example.uzairzohaib.whatsaround.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by UZAIR on 7/15/2018.
 */

public class User {

    @SerializedName("user_id")
    @Expose
    private String Id;
    private String password;
    private String name;
    private double cnic_number;
    private double contact_number;
    private String email;
    private int rating;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCnic_number() {
        return cnic_number;
    }

    public void setCnic_number(double cnic_number) {
        this.cnic_number = cnic_number;
    }

    public double getContact_number() {
        return contact_number;
    }

    public void setContact_number(double contact_number) {
        this.contact_number = contact_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }



    public User(String id, String password, String name, double cnic_number, double contact_number, String email, int rating) {
        Id = id;
        this.password = password;
        this.name = name;
        this.cnic_number = cnic_number;
        this.contact_number = contact_number;
        this.email = email;
        this.rating = rating;
    }


}
