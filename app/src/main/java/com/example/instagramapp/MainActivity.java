package com.example.instagramapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private Button loginBtn;
    private Button signupBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginBtn = findViewById(R.id.loginBtn);
        signupBtn = findViewById(R.id.signUpBtn);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if(currentUser != null) {
                Intent i = new Intent(this,MakePostActivity.class);
                startActivity(i);
        }
        else
        {
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLoginActivity();
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
            }
        });
        signupBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goSignUpActivity();
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void goLoginActivity()
    {
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
    }
    public void goSignUpActivity()
    {
        Intent i = new Intent(this,SignUpActivity.class);
        startActivity(i);
    }
}