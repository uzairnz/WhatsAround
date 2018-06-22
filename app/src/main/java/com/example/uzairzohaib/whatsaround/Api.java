package com.example.uzairzohaib.whatsaround;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import com.example.uzairzohaib.whatsaround.models.Quote;
import com.example.uzairzohaib.whatsaround.models.Service;
import com.example.uzairzohaib.whatsaround.models.ServiceQuote;

/**
 * Created by UZAIR on 6/9/2018.
 */

public interface Api {

    String BASE_URL = "http://192.168.1.6:8000/api/";

    @GET("service")
    Call<ArrayList<Service>> getServices();

    @GET("quote")
    Call<ArrayList<Quote>> getQuotes();

    @GET("give/{id}")
    Call<ServiceQuote>getServiceQuote(@Path("id") String id);


    @GET("myquote/{id}")
    Call<ServiceQuote>getMyQuote(@Path("id") String id);

    @GET("give")
    Call<ArrayList<ServiceQuote>> getServiceQuote();

    @POST("service")
    @FormUrlEncoded
    Call<Service>saveservice(
             @Field("service_name") String item_name,
             @Field("category") String category,
             @Field("location") String location,
             @Field("quotes") int photo);

    @POST("quote")
    @FormUrlEncoded
    Call<Quote>savequotes(
            @Field("price") String price,
            @Field("description") String description,
            @Field("service_id") String service_id,
            @Field("partner_id") String partner_id
    );

    @POST("service")
    Call<Service> saveservice(@Body Service lost);

    @POST("quote")
    Call<Quote> savequotes(@Body Quote lost);
}
