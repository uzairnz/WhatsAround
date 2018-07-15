package com.example.uzairzohaib.whatsaround;

import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.uzairzohaib.whatsaround.models.Quote;
import com.example.uzairzohaib.whatsaround.models.Service;

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
    @BindView(R.id.extended_edit_text_quote_description) ExtendedEditText Quote_description;
    @BindView(R.id.extended_edit_text_quote_price) ExtendedEditText Quote_price;
    public String MYPRREFERENCE = "MyPreferences";
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
                String description = Quote_description.getText().toString().trim();
                String price = Quote_price.getText().toString().trim();

                Toast.makeText(AddQuoteActivity.this,"Quote Added",Toast.LENGTH_SHORT).show();


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Api quote1 = retrofit.create(Api.class);
                String Id = getIntent().getStringExtra("service_Id");

                final SharedPreferences sharedPreferences = getSharedPreferences(MYPRREFERENCE, Context.MODE_PRIVATE);
                String ID_KEY = "mykey";
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String Id2 = sharedPreferences.getString(ID_KEY, "1");

                Call<Quote> listList= quote1.savequotes(price, description, Id,Id2);

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