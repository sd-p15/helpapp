package com.example.KOPIA;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SzkodyPodkategoria extends AppCompatActivity {
    public static final String KATEGORIA ="SzkodyPodkategoria.kategoria";
    public static final String PODKATEGORIA ="SzkodyPodategoria.podkategoria";
    public static final String KOMENTARZ ="SzkodyPodkategoria.komentarz";
    String kategoria;
    String podkategoria="";
    String komentarz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_szkody_podkategoria);

        Intent intent = getIntent();
        kategoria = intent.getStringExtra(SzkodyKategoria.KATEGORIA);
        TextView textView1 = (TextView) findViewById(R.id.kategoria);
        textView1.setText("Kategoria: " + kategoria);
        TextView textView2 = (TextView) findViewById(R.id.podkategoria);
        textView2.setText("Wybierz kategorię");
        //Przyciski podkategorii
        Button podkategoria1 =(Button) findViewById(R.id.Podkategoria1);
        Button podkategoria2 =(Button) findViewById(R.id.Podkategoria2);
        Button podkategoria3 =(Button) findViewById(R.id.Podkategoria3);
        Button podkategoria4 =(Button) findViewById(R.id.Podkategoria4);
        //Komendy przycisków
        podkategoria1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                podkategoria ="podkategoria1";
                textView2.setText(podkategoria);

            }
        });
        podkategoria2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                podkategoria ="podkategoria2";
                textView2.setText(podkategoria);
            }
        });
        podkategoria3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                podkategoria ="podkategoria3";
                textView2.setText(podkategoria);
            }
        });
        podkategoria4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                podkategoria ="podkategoria4";
                textView2.setText(podkategoria);
            }
        });
        //przycisk Dalej
        Button button = (Button) findViewById(R.id.Dalej);
        //Komenda przycisku
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if  (podkategoria != "") {
                    openZdjecie();
                }
            }
        });

    }

    public void openZdjecie(){
        EditText komText = findViewById(R.id.Komentarz);
        komentarz = komText.getText().toString();
        Intent intent = new Intent(this, SzkodyZdjecie.class);
        intent.putExtra(KATEGORIA,kategoria);
        intent.putExtra(PODKATEGORIA,podkategoria);
        intent.putExtra(KOMENTARZ,komentarz);
        startActivity(intent);
    }

    }
