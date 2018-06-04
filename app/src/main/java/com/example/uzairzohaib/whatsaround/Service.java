package com.example.uzairzohaib.whatsaround;

import java.util.PriorityQueue;

/**
 * Created by UZAIR&ZOHAIB on 4/12/2018.
 */

public class Service {

    private String Name;
    private String Category;
    private String Location;
    private int Photo;

    public Service() {
    }

    public Service(String name, String category, String location, int photo) {
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

