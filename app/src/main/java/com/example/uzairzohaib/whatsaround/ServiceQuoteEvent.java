package com.example.uzairzohaib.whatsaround;


import com.example.uzairzohaib.whatsaround.models.Quote;
import com.example.uzairzohaib.whatsaround.models.ServiceQuote;

import java.util.ArrayList;
/**
 * Created by UZAIR on 6/20/2018.
 */

public class ServiceQuoteEvent {
    private ArrayList<ServiceQuote> message;

    public ServiceQuoteEvent(ArrayList<ServiceQuote> message) {
        this.message = message;
    }



    public ArrayList<ServiceQuote> getMessage() {
        return message;
    }
}
