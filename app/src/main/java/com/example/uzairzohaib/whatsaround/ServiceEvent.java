package com.example.uzairzohaib.whatsaround;

import com.example.uzairzohaib.whatsaround.models.Service;

import java.util.ArrayList;

/**
 * Created by UZAIR on 6/10/2018.
 */

class ServiceEvent {
    private ArrayList<Service> message;

    public ServiceEvent(ArrayList<Service> message) {
        this.message = message;
    }



    public ArrayList<Service> getMessage() {
        return message;
    }
}
