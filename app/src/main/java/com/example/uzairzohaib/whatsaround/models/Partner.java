package com.example.uzairzohaib.whatsaround.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by UZAIR on 7/14/2018.
 */

public class Partner {
    @SerializedName("partner_id")
    @Expose
    private String Id;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cnic_number")
    @Expose
    private double cnic_number;
    @SerializedName("contact_number")
    @Expose
    private double contact_number;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("occupation")
    @Expose
    private String occupation;
    @SerializedName("service_category")
    @Expose
    private String service_category;
    @SerializedName("age")
    @Expose
    private int age;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("rating")
    @Expose
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getService_category() {
        return service_category;
    }

    public void setService_category(String service_category) {
        this.service_category = service_category;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }



    public Partner(String id, String password, String name, int cnic_number, int contact_number, String email, String occupation, String service_category, int age, String location, String gender, int rating) {
        Id = id;
        this.password = password;
        this.name = name;
        this.cnic_number = cnic_number;
        this.contact_number = contact_number;
        this.email = email;
        this.occupation = occupation;
        this.service_category = service_category;
        this.age = age;
        this.location = location;
        this.gender = gender;
        this.rating = rating;
    }


}
