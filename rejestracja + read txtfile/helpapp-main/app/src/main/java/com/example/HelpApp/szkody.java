package com.example.HelpApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class szkody extends AppCompatActivity {
    private Button button2;
    ImageButton imageButton;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    ImageButton imageButton5;
    ImageButton imageButton6;
    ImageButton imageButton7;
    ImageButton imageButton8;
    ImageButton imageButton9;
    ImageButton imageButton10;
    ImageButton imageButton11;
    String szkodyKategoria;
    public static final String KATEGORIA ="Szkody.kategoria";
    public szkody() throws FileNotFoundException {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szkody);

        imageButton = (ImageButton) findViewById(R.id.buttonDrogi);
        imageButton2 = (ImageButton) findViewById(R.id.buttonKomunikacja);
        imageButton3 = (ImageButton) findViewById(R.id.buttonLokalowe);
        imageButton4 = (ImageButton) findViewById(R.id.buttonOdsniezanie);
        imageButton5 = (ImageButton) findViewById(R.id.buttonSmieci);
        imageButton6 = (ImageButton) findViewById(R.id.buttonDewastacja);
        imageButton7 = (ImageButton) findViewById(R.id.buttonKanalizacyjne);
        imageButton8 = (ImageButton) findViewById(R.id.buttonZielen);
        imageButton9 = (ImageButton) findViewById(R.id.buttonZwierzeta);
        imageButton10 = (ImageButton) findViewById(R.id.buttonPorzadek);
        imageButton11 = (ImageButton) findViewById(R.id.buttonInne);
        TextView text = (TextView) findViewById(R.id.textView2);
        Button dalej = (Button) findViewById(R.id.buttonDalej1);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szkodyKategoria= "Drogi";
                text.setText("Kategoria: " + szkodyKategoria);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szkodyKategoria= "Komunikacja";
                text.setText("Kategoria: " + szkodyKategoria);
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szkodyKategoria= "Lokalowe";
                text.setText("Kategoria: " + szkodyKategoria);
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szkodyKategoria= "Odśnieżanie";
                text.setText("Kategoria: " + szkodyKategoria);
            }
        });
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szkodyKategoria= "Śmieci";
                text.setText("Kategoria: " + szkodyKategoria);
            }
        });
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szkodyKategoria= "Dewastacja";
                text.setText("Kategoria: " + szkodyKategoria);
            }
        });
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szkodyKategoria= "Kanalizacyjne";
                text.setText("Kategoria: " + szkodyKategoria);

            }
        });
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szkodyKategoria= "Zieleń";
                text.setText("Kategoria: " + szkodyKategoria);
            }
        });
        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szkodyKategoria = "Zwierzęta";
                text.setText("Kategoria: " + szkodyKategoria);
            }
        });
        imageButton10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    szkodyKategoria= "Porządek";
                    text.setText("Kategoria: " + szkodyKategoria);
            }
        });
        imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szkodyKategoria= "Inne";
                text.setText("Kategoria: " + szkodyKategoria);
            }
        });
        dalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                writeToCSV();
                openPodkategorie1();

            }
        });
    }

            public void openPodkategorie1() {
                String text = szkodyKategoria;
                Intent intent = new Intent(this, szkodyPodkategoria.class);
                intent.putExtra(KATEGORIA, text);
                startActivity(intent);
            }
        };
