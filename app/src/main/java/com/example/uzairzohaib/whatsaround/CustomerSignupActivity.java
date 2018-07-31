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

import com.example.uzairzohaib.whatsaround.models.User;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CustomerSignupActivity extends AppCompatActivity {
    private static final String TAG = "CustomerSignupActivity";
    public     String  id = "";
    public String MYPRREFERENCE = "MyPreferences";
    @BindView(R.id.input_name) EditText _nameText;
    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.btn_signup) Button _signupButton;
    @BindView(R.id.link_login) TextView _loginLink;
    @BindView(R.id.input_cnic_number) TextView _cnic_number;
    @BindView(R.id.input_contact) TextView _contact;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_signup);
        ButterKnife.bind(this);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //EventBus.getDefault().register(this);
                Retrofit rerofit = new Retrofit.Builder()
                        .baseUrl(Api.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

//                email = _emailText.getText().toString();
//                password =  _passwordText.getText().toString();


                Api api = rerofit.create(Api.class);
                Call<User> LostList = api.saveuser(_passwordText.getText().toString(),
                        _nameText.getText().toString(), _cnic_number.getText().toString(), _contact.getText().toString(), _emailText.getText().toString(), "0"); //kill me!


                //Getting data for services
                LostList.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Log.i("response_check", "Customer Sign up Sucess! onResponse() called with: call = [" + call + "], response = [" + response + "]");
                       // ArrayList<User> LostDetailList = response.body();
                       // UserEvent lostEvent = new UserEvent(LostDetailList);
                        id = response.body().getId();
                        //EventBus.getDefault().post(lostEvent);
                        signup();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.i("response_check", "Customer Sign up failed onFailure() called with: call = [" + call + "], t = [" + t + "]");
                        onSignupFailed();

                    }
                });

            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(CustomerSignupActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        String cnic = _cnic_number.getText().toString();
        String contact = _contact.getText().toString();

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        Intent myIntent = new Intent(CustomerSignupActivity.this,
                CustomerHome.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        final SharedPreferences sharedPreferences = getSharedPreferences(MYPRREFERENCE, Context.MODE_PRIVATE);
        String ID_KEY = "mykey2";
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ID_KEY, id);
        editor.apply();
        startActivity(myIntent);
//        _signupButton.setEnabled(true);
//        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        String contact = _contact.getText().toString();
        String cnic = _cnic_number.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 6 || password.length() > 25) {
            _passwordText.setError("between 6 and 25 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        if(contact.isEmpty() || contact.length() < 11 || contact.length() > 15) {
            _contact.setError("between 11 and 15 numbers");
        } else {
            _contact.setError(null);
        }

        if(cnic.isEmpty() || cnic.length() == 13 ) {
            _cnic_number.setError("Invalid cnic");
        } else {
            _cnic_number.setError(null);
        }


        return valid;
    }
}
