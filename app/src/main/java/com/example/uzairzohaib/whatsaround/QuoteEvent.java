package com.example.uzairzohaib.whatsaround;


import com.example.uzairzohaib.whatsaround.models.Quote;

import java.util.ArrayList;
/**
 * Created by UZAIR on 6/20/2018.
 */

public class QuoteEvent {
    private ArrayList<Quote> message;

    public QuoteEvent(ArrayList<Quote> message) {
        this.message = message;
    }



    public ArrayList<Quote> getMessage() {
        return message;
    }
}
