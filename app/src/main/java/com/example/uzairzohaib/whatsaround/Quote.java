package com.example.uzairzohaib.whatsaround;

/**
 * Created by UZAIR on 6/9/2018.
 */

public class Quote {

    private String Name;
    private String Category;
    private String Location;
    private int Photo;

    public Quote() {
    }

    public Quote(String name, String category, String location, int photo) {
        Name = name;
        Category = category;
        Location = location;
        Photo = photo;
    }

    //Getter

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