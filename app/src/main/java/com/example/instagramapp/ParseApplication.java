package com.example.instagramapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("0gz4bMMacaW7QxzXUztkGZlIqjQZRMLoAtS4Tnnc")
                .clientKey("Z74S8Azimldt4RnxUowc3XiBmZQk052UK9gsRy3b")
                .server("https://parseapi.back4app.com")
                .build()
        );

        //New test creation of object below
        ParseObject testObject = new ParseObject("Test Object");
        testObject.put("foo","bar");
        testObject.saveInBackground();
    }
}
