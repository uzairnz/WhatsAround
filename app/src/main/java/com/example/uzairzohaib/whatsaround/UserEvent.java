package com.example.uzairzohaib.whatsaround;

import com.example.uzairzohaib.whatsaround.models.User;

import java.util.ArrayList;

/**
 * Created by UZAIR on 7/15/2018.
 */

public class UserEvent {
    private ArrayList<User> message;

    public UserEvent(ArrayList<User> message) {
        this.message = message;
    }



    public ArrayList<User> getMessage() {
        return message;
    }
}
