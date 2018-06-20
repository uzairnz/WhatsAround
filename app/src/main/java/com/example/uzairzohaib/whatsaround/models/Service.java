package com.example.uzairzohaib.whatsaround.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by UZAIR&ZOHAIB on 4/12/2018.
 */

public class Service {

    @SerializedName("service_id")
    @Expose
    private int Id;

    @SerializedName("service_name")
    @Expose
    private String Name;

    @SerializedName("category")
    @Expose
    private String Category;

    @SerializedName("location")
    @Expose
    private String Location;

    @SerializedName("quotes")
    @Expose
    private int Photo;

    public Service() {
    }

    public Service(int id, String name, String category, String location, int photo) {
        Id = id;
        Name = name;
        Category = category;
        Location = location;
        Photo = photo;
    }

    //Getter

    public int getId() { return Id; }

    public String getName() {
        return Name;
    }

    public String getCategory() {
        return Category;
    }

    public String getLocation() {
        return Location;
    }

    public int getPhoto() {
        return Photo;
    }


    //Setter

    public void setId(int id) { Id = id; }

    public void setName(String name) {
        Name = name;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

}

