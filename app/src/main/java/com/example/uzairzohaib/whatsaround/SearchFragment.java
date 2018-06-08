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
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    private OnFragmentInteractionListener mListener;

    View v;
    private RecyclerView myrecyclerview;
    private List<Service> lstService;

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

    // TODO: Rename and change types and number of parameters
//    public static SearchFragment newInstance(String param1, String param2) {
//        SearchFragment fragment = new SearchFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
        lstService = new ArrayList<>();
        lstService.add(new Service("Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service("Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service("Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service("Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service("Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service("Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service("Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service("Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service("Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service("Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service("Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service("Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstService.add(new Service("Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstService.add(new Service("Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
    }


//
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            Toast.makeText(context, "Search Your Services here", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
