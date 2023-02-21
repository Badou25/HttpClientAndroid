package sn.esmt.httpclientandroid;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


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
            }
        });
     }
}