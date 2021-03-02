package com.example.instagramapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {
    public static final String TAG = "SignUpActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etUsername = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPass);
        btnSignUp = findViewById(R.id.BtnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                ParseUser user = new ParseUser();
                user.setUsername(username);
                user.setPassword(password);
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e == null) {
                            goMainActivity();
                            Toast.makeText(SignUpActivity.this,"Success!", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Log.e(TAG,"Failed Signup!",e);
                        }
                    }
                });
            }
        });
    }
    private void goMainActivity()
    {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}