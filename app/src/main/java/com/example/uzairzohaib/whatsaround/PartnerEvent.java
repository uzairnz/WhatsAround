package com.example.uzairzohaib.whatsaround;

import com.example.uzairzohaib.whatsaround.models.Partner;

import java.util.ArrayList;

/**
 * Created by UZAIR on 6/10/2018.
 */

class PartnerEvent {
    private ArrayList<Partner> message;

    public PartnerEvent(ArrayList<Partner> message) {
        this.message = message;
    }



    public ArrayList<Partner> getMessage() {
        return message;
    }
}

