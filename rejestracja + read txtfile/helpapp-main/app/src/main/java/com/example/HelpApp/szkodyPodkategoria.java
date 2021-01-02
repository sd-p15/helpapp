package com.example.HelpApp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class szkodyPodkategoria extends AppCompatActivity {
    String szkodyPodkategoria;

    public static final String PODKATEGORIA ="Szkody.podkategoria";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szkody_podkategoria);
        Intent intent = getIntent();
        String kategoria = intent.getStringExtra(szkody.KATEGORIA);

    }

}
