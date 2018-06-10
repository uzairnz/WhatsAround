package com.example.uzairzohaib.whatsaround;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by UZAIR on 6/9/2018.
 */

public interface Api {

    String BASE_URL = "http://192.168.1.6:8000/api/";

    @GET("service")
    Call<ArrayList<Service>> getServices();
}
