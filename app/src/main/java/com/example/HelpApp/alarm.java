package com.example.HelpApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class alarm extends AppCompatActivity {
    String alarmKategoria;
    public static final String KATEGORIA ="Alarm.kategoria";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Button kategoria1 = (Button) findViewById(R.id.buttonKategoria1);
        Button kategoria2 = (Button) findViewById(R.id.buttonKategoria2);
        Button kategoria3 = (Button) findViewById(R.id.buttonKategoria3);
        Button kategoria4 = (Button) findViewById(R.id.buttonKategoria4);
        Button dalej = (Button) findViewById(R.id.buttonDalej);
        TextView text = (TextView) findViewById(R.id.textViewKategoria);

        kategoria1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmKategoria = "Kategoria1";
                text.setText("Kategoria: " + alarmKategoria);
            }
        });

        kategoria2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmKategoria = "Kategoria2";
                text.setText("Kategoria: " + alarmKategoria);
            }
        });

        kategoria3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmKategoria = "Kategoria3";
                text.setText("Kategoria: " + alarmKategoria);
            }
        });

        kategoria4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmKategoria = "Kategoria4";
                text.setText("Kategoria: " + alarmKategoria);
            }
        });

        dalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPodkategorie();
            }
        });
    }

    public void openPodkategorie() {
        String text=alarmKategoria;
        Intent intent = new Intent(this, alarmPodkategoria.class);
        intent.putExtra(KATEGORIA,text);
        startActivity(intent);
    };
}