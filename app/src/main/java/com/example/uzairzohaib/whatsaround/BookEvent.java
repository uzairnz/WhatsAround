package com.example.uzairzohaib.whatsaround;

import com.example.uzairzohaib.whatsaround.models.Book;
import com.example.uzairzohaib.whatsaround.models.Service;

import java.util.ArrayList;

/**
 * Created by UZAIR on 7/30/2018.
 */

public class BookEvent {

    private ArrayList<Book> message;

    public BookEvent(ArrayList<Book> message) {
        this.message = message;
    }



    public ArrayList<Book> getMessage() {
        return message;
    }
}
