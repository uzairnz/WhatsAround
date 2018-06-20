package com.example.uzairzohaib.whatsaround;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uzairzohaib.whatsaround.Service;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import studio.carbonylgroup.textfieldboxes.ExtendedEditText;

public class Quote_Detail extends AppCompatActivity {

    private static final String TAG = "Quote_Detail";  //check if error


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

        gson = new Gson();
        String target = getIntent().getStringExtra("Details");

        //Classes
        Service service = gson.fromJson(target, Service.class);
        Quote quote = gson.fromJson(target, Quote.class);

        //for service table
        final int Id = service.getId();
        String Name = service.getName().toString();
        String Category = service.getCategory().toString();
        String Location = service.getLocation().toString();
        int Photo = service.getPhoto();

        //for quote table
        int Quote_Id = quote.getId();
        int Quote_Price = quote.getPrice();
        String Quote_Details = quote.getDescription().toString();
        int Service_Id = quote.getService_id();
        int Partner_Id = quote.getPartner_id();



        id.setText(Id);
        service_name.setText(Name);
        service_category.setText(Category);
        service_location.setText(Location);
        quote_id.setText(Quote_Id);
        quote_Price.setText(Quote_Price);
        quote_Details.setText(Quote_Details);
        S_id.setText(Service_Id);
        P_id.setText(Partner_Id);




    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("quote_Price") && getIntent().hasExtra("quote_Id")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            int Quote_Id = getIntent().getIntExtra("quote_Price", 99);
            int Quote_Price = getIntent().getIntExtra("quote_Id", 10);
        }
    }


    public void return_aq(View view) {
    }

    public void updateQuote(View view) {
    }

    public void deleteQuote(View view) {
    }
}
