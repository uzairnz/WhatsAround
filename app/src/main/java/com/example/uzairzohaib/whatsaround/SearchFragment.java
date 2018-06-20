package com.example.uzairzohaib.whatsaround;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uzairzohaib.whatsaround.adapters.RecyclerViewAdapter;
import com.example.uzairzohaib.whatsaround.models.Service;
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


public class SearchFragment extends android.app.Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private ArrayList<Service> lstSearch = new ArrayList();
    Gson gson;
    RecyclerViewAdapter recyclerAdapter;

    public SearchFragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.M)   //if problem then examine this
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_search, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.services_recyclerview);
        recyclerAdapter = new RecyclerViewAdapter(getContext(), lstSearch);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()) {});
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void test(ServiceEvent customEvent) {
        Log.i("check","Hello");
        lstSearch = customEvent.getMessage();
        /*gson = new Gson();
        String str = gson.toJson(customEvent.getMessage());*/

        //Log.i("check",""+lostDetailList1);

        recyclerAdapter.changeset(lstSearch);

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        EventBus.getDefault().register(this);
        Retrofit rerofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = rerofit.create(Api.class);
        Call<ArrayList<Service>> LostList = api.getServices();

        LostList.enqueue(new Callback<ArrayList<Service>>() {
            @Override
            public void onResponse(Call<ArrayList<Service>> call, Response<ArrayList<Service>> response) {
                Log.i("response_check", "onResponse() called with: call = [" + call + "], response = [" + response + "]");
                ArrayList<Service> LostDetailList = response.body();
                ServiceEvent lostEvent = new ServiceEvent(LostDetailList);
                EventBus.getDefault().post(lostEvent);
            }

            @Override
            public void onFailure(Call<ArrayList<Service>> call, Throwable t) {
                Log.i("response_check", "onFailure() called with: call = [" + call + "], t = [" + t + "]");

            }
        });
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        lstService = new ArrayList<>();
//        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
//        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
//        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
//        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
//        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
//        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
//        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
//        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
//        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
//        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
//        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
//        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
//    }

}
