package com.example.uzairzohaib.whatsaround;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import com.example.uzairzohaib.whatsaround.Service;

/**
 * Created by UZAIR on 6/9/2018.
 */

public interface Api {

    String BASE_URL = "http://192.168.1.6:8000/api/";

    @GET("service")
    Call<ArrayList<Service>> getServices();

    @POST("service")
    @FormUrlEncoded
    Call<Service>saveservice(
             @Field("service_name") String item_name,
             @Field("category") String item_description,
             @Field("location") String lost_date,
             @Field("photo") int photo);

    Call<Quote>savequotes(
            @Field("price") int price,
            @Field("description") String description,
            @Field("service_id") int service_id,
            @Field("partner_id") int partner_id
    );

    @POST("service")
    Call<Service> savequote(@Body Service lost);

    @POST("quote")
    Call<Quote> savequote(@Body Quote lost);
}
