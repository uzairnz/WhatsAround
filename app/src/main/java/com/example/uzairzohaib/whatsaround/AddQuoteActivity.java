package com.example.uzairzohaib.whatsaround;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.QuickContactBadge;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Request;
import retrofit2.Call;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import studio.carbonylgroup.textfieldboxes.ExtendedEditText;

import static com.example.uzairzohaib.whatsaround.Api.BASE_URL;

public class AddQuoteActivity extends AppCompatActivity {

            //Binding buttons & text views with layout
    @BindView(R.id.save_quote) Button SaveQuote;
    @BindView(R.id.close_addquote) ImageButton Close;
    @BindView(R.id.extended_edit_text_service_name) ExtendedEditText Service_name;
    @BindView(R.id.extended_edit_text_service_category) ExtendedEditText Service_category;
    @BindView(R.id.extended_edit_text_service_location) ExtendedEditText Service_location;
    @BindView(R.id.extended_edit_text_quote_description) ExtendedEditText Quote_description;
    @BindView(R.id.extended_edit_text_quote_price) ExtendedEditText Quote_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quote);
        ButterKnife.bind(this);

        Close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                if (fm.getBackStackEntryCount() > 0) {
                    Log.i("MainActivity", "popping backstack");
                    fm.popBackStack();
                } else {
                    Log.i("MainActivity", "nothing on backstack, calling super");
                }

            }
        });

        SaveQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_name = Service_name.getText().toString().trim();
                String category = Service_category.getText().toString().trim();
                String location = Service_location.getText().toString().trim();
                String description = Quote_description.getText().toString().trim();
                int price = 10000;

                Toast.makeText(AddQuoteActivity.this,"Quote Added",Toast.LENGTH_SHORT).show();


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Api service1 = retrofit.create(Api.class);
                Api quote1 = retrofit.create(Api.class);

                Call<Service> LostList = service1.saveservice(s_name, category, location, 333); //photo missing
                Call<Quote> listList= quote1.savequotes(price, description, 1,1);
                LostList.enqueue(new Callback<Service>() {
                    @Override
                    public void onResponse(Call<Service> call, Response<Service> response) {
                        Log.d("Post", "onResponse() called with: call = [" + call + "], response = [" + response + "]");


                    }

                    @Override
                    public void onFailure(Call<Service> call, Throwable t) {
                        Log.d("Post", "onFailure() called with: call = [" + call + "], t = [" + t + "]");
                        Toast.makeText(AddQuoteActivity.this,"Failed",Toast.LENGTH_SHORT).show();
                    }
                });

                listList.enqueue(new Callback<Quote>() {
                    @Override


                    public void onResponse(Call<Quote> call, Response<Quote> response) {
                        Log.d("Post", "onResponse() called with: call = [" + call + "], response = [" + response + "]");


                    }

                    @Override
                    public void onFailure(Call<Quote> call, Throwable t) {
                        Log.d("Post", "onFailure() called with: call = [" + call + "], t = [" + t + "]");
                        Toast.makeText(AddQuoteActivity.this,"Failed",Toast.LENGTH_SHORT).show();
                    }
                });




            }
        });


}
}