package com.example.uzairzohaib.whatsaround;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class SearchFragment extends android.app.Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private ArrayList<Service> lstService;

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
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), lstService);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()) {});
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstService = new ArrayList<>();
        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
    }

}
