package com.example.uzairzohaib.whatsaround;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
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
import android.widget.Toast;

import com.example.uzairzohaib.whatsaround.adapters.BookingAdapter;
import com.example.uzairzohaib.whatsaround.models.Book;
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



public class OngoingFragment extends android.app.Fragment {
    public String MYPRREFERENCE = "MyPreferences";
    View v;
    private RecyclerView myrecyclerview;
    private ArrayList<Book> lstSearch = new ArrayList();
    Gson gson;
    BookingAdapter recyclerAdapter;

//    SharedPreferences mSettings = getActivity().getSharedPreferences(MYPRREFERENCE, Context.MODE_PRIVATE);
    //   String ID_KEY = "mykey2";
    //   String user_id = mSettings.getString(ID_KEY, "1");
    // SharedPreferences.Editor editor = this.getActivity().getPreferences().edit();
    // user_Id = sharedPreference.getString(ID_KEY, "1");
    // editor.apply();

    public OngoingFragment() {
        // Required empty public constructor
    }




    @RequiresApi(api = Build.VERSION_CODES.M)   //if problem then examine this
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_search, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.services_recyclerview);
        recyclerAdapter = new BookingAdapter(getContext(), lstSearch);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()) {});
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void test(BookEvent customEvent) {
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
        Call<ArrayList<Book>> LostList = api.getBooked("1");

        LostList.enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(Call<ArrayList<Book>> call, Response<ArrayList<Book>> response) {
                Log.i("response_check", "onResponse() called with: call = [" + call + "], response = [" + response + "] Booking fragment have data");
                ArrayList<Book> LostDetailList = response.body();
                BookEvent lostEvent = new BookEvent(LostDetailList);
                EventBus.getDefault().post(lostEvent);
            }

            @Override
            public void onFailure(Call<ArrayList<Book>> call, Throwable t) {
                Log.i("response_check", "onFailure() called with: call = [" + call + "], t = [" + t + "]");

            }
        });

    }
}