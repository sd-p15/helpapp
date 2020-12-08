package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Singup_form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup_form);
        getSupportActionBar().setTitle("Signup Form");
    }
}