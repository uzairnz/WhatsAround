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
import com.example.uzairzohaib.whatsaround.models.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PartnerSignup extends AppCompatActivity {
    private static final String TAG = "PartnerSignup";
    public     String  id = "";
    public String MYPRREFERENCE = "MyPreferences";

    @BindView(R.id.input_name) EditText _nameText;
    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.btn_signup) Button _signupButton;
    @BindView(R.id.link_login) TextView _loginLink;
    @BindView(R.id.input_cnic_number) TextView _cnic_number;
    @BindView(R.id.input_contact) TextView _contact;
    @BindView(R.id.input_occupation) TextView _occupation;
    @BindView(R.id.input_service_category) TextView _service_category;
    @BindView(R.id.input_age) TextView _age;
    @BindView(R.id.input_location) TextView _location;
    @BindView(R.id.gender) TextView _gender;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_signup);
        ButterKnife.bind(this);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit rerofit = new Retrofit.Builder()
                        .baseUrl(Api.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

//                email = _emailText.getText().toString();
//                password =  _passwordText.getText().toString();


                Api api = rerofit.create(Api.class);
                Call<Partner> LostList = api.savepartner(_passwordText.getText().toString(),
                        _nameText.getText().toString(), _cnic_number.getText().toString(), _contact.getText().toString(), _emailText.getText().toString(), _occupation.getText().toString()
                        , _service_category.getText().toString(), _age.getText().toString(), _location.getText().toString(), _gender.getText().toString(), "0"); //kill me!


                //Getting data for services
                LostList.enqueue(new Callback<Partner>() {
                    @Override
                    public void onResponse(Call<Partner> call, Response<Partner> response) {
                        Log.i("response_check", "Partner Sign up Sucess! onResponse() called with: call = [" + call + "], response = [" + response + "]");
                        // ArrayList<User> LostDetailList = response.body();
                        // UserEvent lostEvent = new UserEvent(LostDetailList);
                        id = response.body().getId();
                        //EventBus.getDefault().post(lostEvent);
                        signup();
                    }

                    @Override
                    public void onFailure(Call<Partner> call, Throwable t) {
                        Log.i("response_check", "Partner Sign up failed onFailure() called with: call = [" + call + "], t = [" + t + "]");
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

        final ProgressDialog progressDialog = new ProgressDialog(PartnerSignup.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

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
        Intent myIntent = new Intent(PartnerSignup.this,
                PartnerHome.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        final SharedPreferences sharedPreferences = getSharedPreferences(MYPRREFERENCE, Context.MODE_PRIVATE);
        String ID_KEY = "mykey2";
        SharedPreferences.Editor editor = sharedPreferences.edit();
        myIntent.putExtra("Partner_ka_Id", id);
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
        String occupation = _occupation.getText().toString();
        String service = _service_category.getText().toString();
        String age = _age.getText().toString();
        String location = _location.getText().toString();
        String gender = _gender.getText().toString();

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

        if(occupation.isEmpty() || occupation.length() < 3 || occupation.length() > 50) {
            _occupation.setError("between 3 and 50 numbers");
        } else {
            _occupation.setError(null);
        }

        if(service.isEmpty() || service.length() < 3 || service.length() > 50) {
            _service_category.setError("between 3 and 50 numbers");
        } else {
            _service_category.setError(null);
        }

        if(age.isEmpty() || age.length() < 2 || age.length() > 2) {
            _age.setError("between 8 and 100 numbers");
        } else {
            _age.setError(null);
        }

        if(location.isEmpty() || location.length() < 2 || location.length() > 200) {
            _location.setError("between 2 and 200 numbers");
        } else {
            _location.setError(null);
        }

        if(gender.isEmpty() || _gender.getText().toString().equals("male") ||  _gender.getText().toString().equals("female") ||  _gender.getText().toString().equals("other") ) {
            _location.setError("Only male, female & other only");
        } else {
            _location.setError(null);
        }




        return valid;
    }
}
