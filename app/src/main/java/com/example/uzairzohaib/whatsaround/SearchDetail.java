package com.example.uzairzohaib.whatsaround;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.uzairzohaib.whatsaround.adapters.SearchAdapter;
import com.example.uzairzohaib.whatsaround.models.ServiceQuote;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchDetail extends AppCompatActivity {

    private ArrayList<ServiceQuote> lstServiceQuote = new ArrayList<ServiceQuote>(); // for click on recycler view postion
    Gson gson;
    SearchAdapter searchAdapter;
    RecyclerView myrecyclerview;


    @RequiresApi(api = Build.VERSION_CODES.M)   //if problem then examine this
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void test(ServiceQuoteEvent customEvent) {
        Log.i("check", "Hello");
        lstServiceQuote = customEvent.getMessage();
        searchAdapter.changeset(lstServiceQuote);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_detail);


        RecyclerView recyclerView = findViewById(R.id.search_detail_recyclerview);
        searchAdapter = new SearchAdapter(this, lstServiceQuote);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(searchAdapter);

        Retrofit rerofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        String id = getIntent().getStringExtra("service_Id"); //try wala method
        Api api = rerofit.create(Api.class);
        Call<ArrayList<ServiceQuote>> LostList = api.getServiceQuote(id); //kill me!


        //Getting data for services
        LostList.enqueue(new Callback<ArrayList<ServiceQuote>>()

        {
            @Override
            public void onResponse
                    (Call<ArrayList<ServiceQuote>> call, Response<ArrayList<ServiceQuote>> response) {
                Log.i("response_check", "onResponse() called with: call = [" + call + "], response = [" + response +"]");
                ArrayList<ServiceQuote> LostDetailList = response.body();
//                searchAdapter.changeset(LostDetailList);
                ServiceQuoteEvent lostEvent = new ServiceQuoteEvent(LostDetailList);
                EventBus.getDefault().post(lostEvent);
            }

            @Override
            public void onFailure(Call<ArrayList<ServiceQuote>> call, Throwable t) {
                Log.i("response_check", "onFailure() called with: call = [" + call + "], t = [" + t + "]");

            }
        });

    }
}
