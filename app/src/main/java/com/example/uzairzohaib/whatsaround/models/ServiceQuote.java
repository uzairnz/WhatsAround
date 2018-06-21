package com.example.uzairzohaib.whatsaround.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by UZAIR on 6/20/2018.
 */

public class ServiceQuote {
    @SerializedName("service_id")
    @Expose
    private int Service_Id;

    @SerializedName("service_name")
    @Expose
    private String Service_Name;

    @SerializedName("category")
    @Expose
    private String Category;

    @SerializedName("location")
    @Expose
    private String Location;

    @SerializedName("quotes")
    @Expose
    private String Quotes; //will be used for rating

    @SerializedName("quote_id")
    @Expose
    private String Quote_Id;

    @SerializedName("price")
    @Expose
    private String Price;

    @SerializedName("description")
    @Expose
    private String Description;

    @SerializedName("partner_id")
    @Expose
    private int Partner_Id;


    public ServiceQuote(int service_Id, String service_Name, String category, String location, String quotes, String quote_Id, String price, String description, int partner_Id) {
        Service_Id = service_Id;
        Service_Name = service_Name;
        Category = category;
        Location = location;
        Quotes = quotes;
        Quote_Id = quote_Id;
        Price = price;
        Description = description;
        Partner_Id = partner_Id;
    }


    public int getService_Id() {
        return Service_Id;
    }

    public void setService_Id(int service_Id) {
        Service_Id = service_Id;
    }

    public String getService_Name() {
        return Service_Name;
    }

    public void setService_Name(String service_Name) {
        Service_Name = service_Name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getQuotes() {
        return Quotes;
    }

    public void setQuotes(String quotes) {
        Quotes = quotes;
    }

    public String getQuote_Id() {
        return Quote_Id;
    }

    public void setQuote_Id(String quote_Id) {
        Quote_Id = quote_Id;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getPartner_Id() {
        return Partner_Id;
    }

    public void setPartner_Id(int partner_Id) {
        Partner_Id = partner_Id;
    }







}
