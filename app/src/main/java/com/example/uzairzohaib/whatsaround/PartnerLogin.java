package com.example.uzairzohaib.whatsaround;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uzairzohaib.whatsaround.models.Partner;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PartnerLogin extends AppCompatActivity {
    private static final String TAG = "CustomerLogin";
    private static final int REQUEST_SIGNUP = 0;

    public     String  id = "";

    @BindView(R.id.input_email)
    EditText _emailText;
    @BindView(R.id.input_password)
    EditText _passwordText;
    @BindView(R.id.btn_login)
    Button _loginButton;
    @BindView(R.id.link_signup)
    TextView _signupLink;

public String MYPRREFERENCE = "MyPreferences";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_login);
        ButterKnife.bind(this);




        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                //EventBus.getDefault().register(this);
                Retrofit rerofit = new Retrofit.Builder()
                        .baseUrl(Api.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                email = _emailText.getText().toString();
                password =  _passwordText.getText().toString();


                Api api = rerofit.create(Api.class);
                Call<ArrayList<Partner>> LostList = api.partnerLogin(email, password ); //kill me!


                //Getting data for services
                LostList.enqueue(new Callback<ArrayList<Partner>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Partner>> call, Response<ArrayList<Partner>> response) {
                        Log.i("response_check", "Partner Login Sucess! onResponse() called with: call = [" + call + "], response = [" + response + "]"+ "where id ="+response.body().get(0).getId());
                        ArrayList<Partner> LostDetailList = response.body();
                        PartnerEvent lostEvent = new PartnerEvent(LostDetailList);
                        id = response.body().get(0).getId().toString();
                        EventBus.getDefault().post(lostEvent);
                        login();
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Partner>> call, Throwable t) {
                        Log.i("response_check", "onFailure() called with: call = [" + call + "], t = [" + t + "]");

                    }
                });


            }
        });


        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), PartnerSignup.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });





    }



    private    String email = "";

    private    String password = "";



    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(PartnerLogin.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();



        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        //  onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        Intent myIntent = new Intent(PartnerLogin.this,
                PartnerHome.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        final SharedPreferences sharedPreferences = getSharedPreferences(MYPRREFERENCE, Context.MODE_PRIVATE);
        String ID_KEY = "mykey";
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ID_KEY, id);
        myIntent.putExtra("Partner_ka_Id", id);
        editor.commit();
        startActivity(myIntent);

        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }
}