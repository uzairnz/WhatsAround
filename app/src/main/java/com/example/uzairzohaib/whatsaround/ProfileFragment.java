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



public class ProfileFragment extends android.app.Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<Profile> lstProfile;

    public ProfileFragment() {
        // Required empty public constructor
    }
    @RequiresApi(api = Build.VERSION_CODES.M)   //if problem then examine this
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_profile, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.profile_recycler_view);
        ProfileRecyclerViewAdapter recyclerAdapter = new ProfileRecyclerViewAdapter(getContext(), lstProfile);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()) {});
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//
    lstProfile = new ArrayList<>();
        lstProfile.add(new Profile("Register as a Partner",R.drawable.ic_if_briefcase_1296365));
        lstProfile.add(new Profile("About WhatsAround!", R.drawable.ic_if_house_window_1378824));
        lstProfile.add(new Profile("Share WhatsAround!", R.drawable.ic_if_social_share_377940));
}
}
