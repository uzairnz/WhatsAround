package com.example.uzairzohaib.whatsaround.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by UZAIR on 7/18/2018.
 */

public class Book {

    @SerializedName("bs_id")
    @Expose
    private String bs_id;

    @SerializedName("user_id")
    @Expose
    private String user_id;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("quote_id")
    @Expose
    private String quote_id;

    @SerializedName("partner_id")
    @Expose
    private String partner_id;


    public Book(String bs_id, String user_id, String status, String quote_id, String partner_id) {
        this.bs_id = bs_id;
        this.user_id = user_id;
        this.status = status;
        this.quote_id = quote_id;
        this.partner_id = partner_id;
    }

    public String getBs_id() {
        return bs_id;
    }

    public void setBs_id(String bs_id) {
        this.bs_id = bs_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQuote_id() {
        return quote_id;
    }

    public void setQuote_id(String quote_id) {
        this.quote_id = quote_id;
    }

    public String getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(String partner_id) {
        this.partner_id = partner_id;
    }






}
