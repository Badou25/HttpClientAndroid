package sn.esmt.httpclientandroid;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sn.esmt.httpclientandroid.httpconfig.Api;
import sn.esmt.httpclientandroid.httpconfig.UsersApiResponse;


public class MainActivity extends AppCompatActivity {
    private EditText emailTxt;
    private EditText passwordTxt;
    private Button loginBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Definition des Widgets
        emailTxt = (EditText) findViewById(R.id.editTextEmail);
        passwordTxt = (EditText) findViewById(R.id.editTextPassword);
        loginBt = (Button) findViewById(R.id.loginButton);
        //Liaison
        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailTxt.getText().toString();
                String password = passwordTxt.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://172.20.1.248:8081")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Api api = retrofit.create(Api.class);

                Call<UsersApiResponse> call = api.login(email, password);

                call.enqueue(new Callback<UsersApiResponse>() {
                    @Override
                    public void onResponse(Call<UsersApiResponse> call, Response<UsersApiResponse> response) {
                        if (response.isSuccessful()) {
                            Log.d("Response :", response.body().toString());
                            String message = response.body().getMessage();
                            String email = response.body().getEmail();
                            Toast.makeText(MainActivity.this, message + "  " + email, Toast.LENGTH_LONG).show();
                        } else {
                            Log.d("error message exception", response.toString());

                        }
                    }

                    @Override
                    public void onFailure(Call<UsersApiResponse> call, Throwable t) {
                        Log.d("Error : ", t.getMessage());
                        //D/Error :: CLEARTEXT communication to 192.168.90.167 not permitted by network security policy
                        Toast.makeText(MainActivity.this, "Impossible d'acceder au serveur !", Toast.LENGTH_LONG).show();
                    }

                });
            }
        });
     }
}