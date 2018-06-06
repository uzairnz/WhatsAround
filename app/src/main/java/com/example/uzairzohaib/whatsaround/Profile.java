package com.example.uzairzohaib.whatsaround;

/**
 * Created by UZAIR on 6/7/2018.
 */

public class Profile {
    private String Name;
    private int Photo;

    public Profile() {
    }

    public Profile(String name, int photo) {
        Name = name;
        Photo = photo;
    }

    //Getter

    public String getName() {
        return Name;
    }

    public int getPhoto() {
        return Photo;
    }


    //Setter

    public void setName(String name) {
        Name = name;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}
