package com.example.uzairzohaib.whatsaround;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uzairzohaib.whatsaround.models.Book;
import com.example.uzairzohaib.whatsaround.models.Partner;
import com.example.uzairzohaib.whatsaround.models.ServiceQuote;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookServiceActivity extends AppCompatActivity {

    public String MYPRREFERENCE = "MyPreferences";
   @BindView(R.id.CALL_BUTTON) ImageButton Call;
    @BindView(R.id.book_now) Button Book_Now;
    @BindView(R.id.Partner_Name) TextView Partner_Name;
    @BindView(R.id.ratingBar2) RatingBar Rating;
    @BindView(R.id.Service_Name) TextView Service_Name;
    @BindView(R.id.category_name) TextView Category_Name;
    @BindView(R.id.description) TextView Description;
    @BindView(R.id.price) TextView Price;

    public String partner_name = "";
    public int rating = 0;
    double contact = 000000000;
    public String user_Id = "1";
    public String Service_id;
    public String Partner_id;
    public String Quote_id ;
    public String Service_name ;
    public String Service_category ;
    public String Quote_description ;
    public String Quote_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_service);
        ButterKnife.bind(this);






        // Data Gathering for Retro calls
        final SharedPreferences sharedPreferences = getSharedPreferences(MYPRREFERENCE, Context.MODE_PRIVATE);
        String ID_KEY = "mykey2";
        SharedPreferences.Editor editor = sharedPreferences.edit();
        user_Id = sharedPreferences.getString(ID_KEY, "1");
        editor.apply();
        Service_id = getIntent().getStringExtra("service_Id"); //try wala method
        Partner_id = getIntent().getStringExtra("partner_Id");
        Quote_id = getIntent().getStringExtra("quote_Id");
        Service_name = getIntent().getStringExtra("service_Name");
        Service_category = getIntent().getStringExtra("service_Category");
        Quote_description = getIntent().getStringExtra("quote_Description");
        Quote_price = getIntent().getStringExtra("quote_Price");

        //Retro call for Partner
        Retrofit rerofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = rerofit.create(Api.class);
        retrofit2.Call<ArrayList<Partner>> myList = api.getPartner(Partner_id);
        myList.enqueue(new Callback<ArrayList<Partner>>() {
            @Override
            public void onResponse(Call<ArrayList<Partner>> call, Response<ArrayList<Partner>> response) {
                Log.i("response_check", "onResponse() called with: call = [" + call + "], response = [" + response + "]");
                ArrayList<Partner> LostDetailList = response.body();
                partner_name = response.body().get(0).getName();
                rating = response.body().get(0).getRating();
                contact = response.body().get(0).getContact_number();
                PartnerEvent lostEvent = new PartnerEvent(LostDetailList);
                EventBus.getDefault().post(lostEvent);
            }

            @Override
            public void onFailure(Call<ArrayList<Partner>> call, Throwable t) {
                Log.i("response_check", "onFailure() called with: call = [" + call + "], t = [" + t + "]");

            }
        });

        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = String.valueOf(contact);
                Intent dialIntent = new Intent();
                dialIntent.setAction(Intent.ACTION_CALL);
                dialIntent.setData(Uri.parse(phoneNumber));
            }
        });

        Book_Now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Retrofit rerofit = new Retrofit.Builder()
                        .baseUrl(Api.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Api api = rerofit.create(Api.class);
                Call<Book> listList= api.savebook(user_Id, "pending", Quote_id,Partner_id);

                listList.enqueue(new Callback<Book>() {
                    @Override


                    public void onResponse(Call<Book> call, Response<Book> response) {
                        Log.d("Post", "onResponse() called with: call = [" + call + "], response = [" + response + "]");


                    }

                    @Override
                    public void onFailure(Call<Book> call, Throwable t) {
                        Log.d("Post", "onFailure() called with: call = [" + call + "], t = [" + t + "]");
                        Toast.makeText(BookServiceActivity.this,"Failed",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


        //Setting Text to views
        Partner_Name.setText(partner_name);
        Rating.setRating(rating);
        Service_Name.setText(Service_name);
        Category_Name.setText(Service_category);
        Description.setText(Quote_description);
        Price.setText(Quote_price);





    }
}
