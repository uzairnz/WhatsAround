package com.example.uzairzohaib.whatsaround.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by UZAIR on 6/9/2018.
 */

public class Quote {

    @SerializedName("quote_id")
    @Expose
    private int Id;

    @SerializedName("price")
    @Expose
    private int Price;

    @SerializedName("description")
    @Expose
    private String Description;

    @SerializedName("service_id")
    @Expose
    private int Service_id;

    @SerializedName("partner_id")
    @Expose
    private int Partner_id;

    public Quote() {
    }

    public Quote(int id, int price, String description, int service_id, int partner_id) {
        Id = id;
        Price = price;
        Description = description;
        Service_id = service_id;
        Partner_id = partner_id;
    }

    //Getter

    public int getId() { return Id; }

    public int getPrice() {
        return Price;
    }

    public String getDescription() {
        return Description;
    }

    public int getService_id() {
        return Service_id;
    }

    public int getPartner_id() {
        return Partner_id;
    }


    //Setter

    public void setId(int id) { Id = id; }

    public void setPrice(int price) {
        Price = price;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setService_id(int service_id) {
        Service_id = service_id;
    }

    public void setPartner_id(int partner_id) { Partner_id = partner_id; }

}

//    ******Old Quote******
//public class Quote {
//
//    private String Name;
//    private String Category;
//    private String Location;
//    private int Photo;
//
//    public Quote() {
//    }
//
//    public Quote(String name, String category, String location, int photo) {
//        Name = name;
//        Category = category;
//        Location = location;
//        Photo = photo;
//    }
//
//    //Getter
//
//    public String getName() {
//        return Name;
//    }
//
//    public String getCategory() {
//        return Category;
//    }
//
//    public String getLocation() {
//        return Location;
//    }
//
//    public int getPhoto() {
//        return Photo;
//    }
//
//
//    //Setter
//
//    public void setName(String name) {
//        Name = name;
//    }
//
//    public void setCategory(String category) {
//        Category = category;
//    }
//
//    public void setLocation(String location) {
//        Location = location;
//    }
//
//    public void setPhoto(int photo) {
//        Photo = photo;
//    }
//}