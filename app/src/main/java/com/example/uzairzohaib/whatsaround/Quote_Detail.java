package com.example.uzairzohaib.whatsaround;

import android.content.Context;
import android.content.Intent;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uzairzohaib.whatsaround.models.Quote;
import com.example.uzairzohaib.whatsaround.models.Service;
import com.example.uzairzohaib.whatsaround.models.ServiceQuote;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import studio.carbonylgroup.textfieldboxes.ExtendedEditText;

public class Quote_Detail extends AppCompatActivity {

    private static final String TAG = "Quote_Detail";  //check if error
    Context context;

    //  Services
    ExtendedEditText id;
    ExtendedEditText service_name;
    ExtendedEditText service_category;
    ExtendedEditText service_location;

    //  Quote
    ExtendedEditText quote_id;
    ExtendedEditText S_id;  //service_id
    ExtendedEditText P_id;  //partner_id
    ExtendedEditText quote_Details;
    ExtendedEditText quote_Price;

    //  Buttons
    Button btn_update;
    Button btn_delete;

    public void setQt_Id(String qt_Id) {
        this.qt_Id = qt_Id;
    }

    String qt_Id;


    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_detail);

        //Service ID
        //Partner ID
        //Quote ID

        id = (ExtendedEditText) this.findViewById(R.id.extended_edit_text_service_ID);
        service_name = (ExtendedEditText) this.findViewById(R.id.extended_edit_text_service_name);
        service_category = (ExtendedEditText) this.findViewById(R.id.extended_edit_text_service_category);
        service_location = (ExtendedEditText) this.findViewById(R.id.extended_edit_text_service_location);


        quote_id = (ExtendedEditText) this.findViewById(R.id.extended_edit_text_quote_ID);
        quote_Details = (ExtendedEditText) this.findViewById(R.id.extended_edit_text_quote_description);
        quote_Price = (ExtendedEditText) this.findViewById(R.id.extended_edit_text_quote_price);

        //Buttons

        btn_update = (Button) this.findViewById(R.id.updateQuote);
        btn_delete = (Button) this.findViewById(R.id.deleteQuote);


        //Classes
        // ServiceQuote sq = gson.fromJson(one, ServiceQuote.class);

        //for service table
        final String Id;
        String Name;  //toString() removed due to redundency error
        String Category;
        String Location;
        String rating;   // getQuotes into rating temporary chugar

        //for quote table
       final String Quote_Id;
        String Quote_Price;
        String Quote_Details;
      final  String Partner_Id;

        gson = new Gson();
        Id = getIntent().getStringExtra("service_Id");
        Name = getIntent().getStringExtra("service_Name");
        Category = getIntent().getStringExtra("service_Category");
        Location = getIntent().getStringExtra("service_Location");
        rating = getIntent().getStringExtra("service_Rating");  // not used
        Quote_Id = getIntent().getStringExtra("quote_Id");
        setQt_Id(Quote_Id);
        Quote_Price = getIntent().getStringExtra("quote_Price");
        Quote_Details = getIntent().getStringExtra("quote_Description");
        Partner_Id = getIntent().getStringExtra("partner_id");

        id.setText(Id);
        service_name.setText(Name);
        service_category.setText(Category);
        service_location.setText(Location);
        quote_id.setText(Quote_Id);
        quote_Price.setText(Quote_Price);
        quote_Details.setText(Quote_Details);
//        S_id.setText(Id);
        //   P_id.setText(Partner_Id);      do not need it here

        // Delete in My Quotes
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Quote_Detail.this, "Quote Deleted", Toast.LENGTH_SHORT).show();


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Api.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Api service1 = retrofit.create(Api.class);

                Call<ArrayList<Quote>> LostList = service1.deleteMyQuote(getIntent().getStringExtra("quote_Id"));
                LostList.enqueue(new Callback<ArrayList<Quote>>() {
                    @Override

                    public void onResponse(Call<ArrayList<Quote>> call, Response<ArrayList<Quote>> response) {
                        Log.d("Post", "onResponse() called with: call = [" + call + "], response = [" + response + "]");
                        Intent intent = new Intent(Quote_Detail.this, MyQuotesActivity.class);
                        intent.putExtra("partner_id",getIntent().getStringExtra("partner_id"));
                        Toast.makeText(Quote_Detail.this, "Success!", Toast.LENGTH_SHORT).show();
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<ArrayList<Quote>> call, Throwable t) {
                        Log.d("Post", "onFailure() called with: call = [" + call + "], t = [" + t + "]");
                        Toast.makeText(Quote_Detail.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
            //  Update MyQuote
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String price = quote_Price.getText().toString();
                String details = quote_Details.getText().toString();

                Toast.makeText(Quote_Detail.this, "Quote Updated", Toast.LENGTH_SHORT).show();


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Api.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Api service1 = retrofit.create(Api.class);


                /*Call<Quote> LostList = service1.updateQuote
                        (getQt_Id(), quote_Price.getText().toString(),
                                quote_Details.getText().toString(), Id, Partner_Id);*/
                Call<Quote> LostList = service1.updateQuote
                        (Quote_Id, price, details,Id, Partner_Id);

                LostList.enqueue(new Callback<Quote>() {
                    @Override

                    public void onResponse(Call<Quote> call, Response<Quote> response) {
                        Log.d("Post", "onResponse() called with: call = [" + call + "], response = [" + response + "]");

                        Intent intent = new Intent(Quote_Detail.this, MyQuotesActivity.class);
                        intent.putExtra("partner_id",Partner_Id);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<Quote> call, Throwable t) {
                        Log.d("Post", "onFailure() called with: call = [" + call + "], t = [" + t + "]");
                        Toast.makeText(Quote_Detail.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });




    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("quote_Price") && getIntent().hasExtra("quote_Id")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            int Service_Id = getIntent().getIntExtra("service_Id", 99);
        }
    }


    public void return_aq(View view) {
    }

    public void updateQuote(View view)
    {



    }

    public String getQt_Id() {
        return qt_Id;
    }



//    public void deleteQuote(View view)
//    {
//        EventBus.getDefault().register(this.context);
//        Retrofit rerofit = new Retrofit.Builder()
//                .baseUrl(Api.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        Api api = rerofit.create(Api.class);
//        Call<ArrayList<Quote>> LostList = api.deleteMyQuote(getQt_Id());
//        //Getting data for services
//        LostList.enqueue(new Callback<ArrayList<Quote>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Quote>> call, Response<ArrayList<Quote>> response) {
//                Log.i("response_check", "onResponse() called with: call = [" + call + "], response = [" + response + "]");
//                Toast.makeText(context, "Quote Deleted!", Toast.LENGTH_SHORT).show();
//                ArrayList<Quote> LostDetailList = response.body();
//                QuoteEvent lostEvent = new QuoteEvent(LostDetailList);
//                EventBus.getDefault().post(lostEvent);
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Quote>> call, Throwable t) {
//                Log.i("response_check", "onFailure() called with: call = [" + call + "], t = [" + t + "]");
//
//            }
//        });
    }

