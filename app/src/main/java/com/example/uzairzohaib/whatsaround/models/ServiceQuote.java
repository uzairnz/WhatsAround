package com.example.uzairzohaib.whatsaround.models;

/**
 * Created by UZAIR on 6/20/2018.
 */

public class ServiceQuote {
    private int Service_Id;
    private String Service_Name;
    private String Category;
    private String Location;
    private String Quotes;
    private int Quote_Id;  //will be used for rating
    private int Price;
    private String Description;
    private int Partner_Id;


    public ServiceQuote(int service_Id, String service_Name, String category, String location, String quotes, int quote_Id, int price, String description, int partner_Id) {
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

    public int getQuote_Id() {
        return Quote_Id;
    }

    public void setQuote_Id(int quote_Id) {
        Quote_Id = quote_Id;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
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
