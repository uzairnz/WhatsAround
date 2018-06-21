package com.example.uzairzohaib.whatsaround;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.uzairzohaib.whatsaround.models.Quote;
import com.example.uzairzohaib.whatsaround.models.Service;
import com.example.uzairzohaib.whatsaround.models.ServiceQuote;
import com.google.gson.Gson;

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
        ServiceQuote sq = gson.fromJson(target, ServiceQuote.class);

        //for service table
        final int Id = sq.getService_Id();
        String Name = sq.getService_Name();  //toString() removed due to redundency error
        String Category = sq.getCategory();
        String Location = sq.getLocation();
        String rating = sq.getQuotes();   // getQuotes into rating temporary chugar

        //for quote table
        String Quote_Id = sq.getQuote_Id();
        String Quote_Price = sq.getPrice();
        String Quote_Details = sq.getDescription();
        int Partner_Id = sq.getPartner_Id();



        id.setText(Id);
        service_name.setText(Name);
        service_category.setText(Category);
        service_location.setText(Location);
        quote_id.setText(Quote_Id);
        quote_Price.setText(Quote_Price);
        quote_Details.setText(Quote_Details);
        S_id.setText(Id);
        P_id.setText(Partner_Id);




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

    public void updateQuote(View view) {
    }

    public void deleteQuote(View view) {
    }
}
