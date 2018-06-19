package com.example.uzairzohaib.whatsaround;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;


public class QuotesFragment extends android.app.Fragment {
    View v;
    private RecyclerView myrecyclerview;
    private ArrayList<Service> lstQuote = new ArrayList();
    Gson gson;
    QuoteRecyclerViewAdapter recyclerAdapter;
   // private Button btnGoToActivity;
    public QuotesFragment() {
        // Required empty public constructor
    }
    private OnSampleFragmentListener mListener;


    @RequiresApi(api = Build.VERSION_CODES.M)   //if problem then examine this
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        //this might be new method check again if error exists

        View view  = inflater.inflate(R.layout.fragment_quotes, container, false);
        Button btnGoToActivity = (Button) view.findViewById(R.id.add_quote);

        btnGoToActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(getActivity(), AddQuoteActivity.class);
                getActivity().startActivity(intent);*/
                mListener.onButtonPressed();
            }
        });
        // Inflate the layout for this fragment

        myrecyclerview = (RecyclerView) view.findViewById(R.id.quotes_recyclerview);
        recyclerAdapter = new QuoteRecyclerViewAdapter(getContext(), lstQuote);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()) {});
        myrecyclerview.setAdapter(recyclerAdapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSampleFragmentListener) {
            mListener = (OnSampleFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSampleFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnSampleFragmentListener {
        // TODO: Update argument type and name
        void onButtonPressed();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void test(ServiceEvent customEvent) {
        Log.i("check","Hello");
        lstQuote = customEvent.getMessage();
        /*gson = new Gson();
        String str = gson.toJson(customEvent.getMessage());*/

        //Log.i("check",""+lostDetailList1);

        recyclerAdapter.changeset(lstQuote);

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

        /*Retrofit rerofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = rerofit.create(Api.class);
        Call<ArrayList<Service>> call = api.getServices();
        call.enqueue(new Callback<ArrayList<Service>>() {
            public static final String MTAG = "Response";

            @Override
            public void onResponse(Call<ArrayList<Service>> call, Response<ArrayList<Service>> response) {
            List<Service> services = response.body();
            Log.i("respose", response.body().toString());
                //lstQuote = new ArrayList<>();
            *//*for(int i = 0; i< services.size(); i++){
                lstQuote.add(new Service(services.get(i).getId(),services.get(i).getName(),
                        services.get(i).getCategory(), services.get(i).getLocation(), R.drawable.ic_if_education_3069198));
            }*//*
            }

            @Override
            public void onFailure(Call<ArrayList<Service>> call, Throwable t) {

                Log.i("response", "onFailure() called with: call = [" + call + "], t = [" + t + "]");
            }

        });*/

                //lstQuote = new ArrayList<>();
      /*  lstQuote.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstQuote.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstQuote.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstQuote.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstQuote.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstQuote.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstQuote.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstQuote.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstQuote.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstQuote.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstQuote.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstQuote.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstQuote.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstQuote.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstQuote.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstQuote.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstQuote.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstQuote.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstQuote.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstQuote.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstQuote.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstQuote.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstQuote.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstQuote.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstQuote.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstQuote.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstQuote.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstQuote.add(new Service(1,"Home Tution", "Education", "Johar Town", R.drawable.ic_if_education_3069198));
        lstQuote.add(new Service(2,"Car Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));
        lstQuote.add(new Service(3,"Dish Wash", "Cleaning", "Muslim Town", R.drawable.ic_if_brush));

*/
    }
}
