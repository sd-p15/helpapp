package com.example.HelpApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class alarmPodkategoria extends AppCompatActivity {
    String alarmPodkategoria;

    public static final String PODKATEGORIA ="Alarm.podkategoria";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_podkategoria);
        Intent intent = getIntent();
        String kategoria = intent.getStringExtra(alarm.KATEGORIA);

        Button podkategoria1 = (Button) findViewById(R.id.buttonPodkategoria1);
        Button podkategoria2 = (Button) findViewById(R.id.buttonPodkategoria2);
        Button podkategoria3 = (Button) findViewById(R.id.buttonPodkategoria3);
        Button podkategoria4 = (Button) findViewById(R.id.buttonPodkategoria4);
        Button dalej = (Button) findViewById(R.id.buttonDalej);
        TextView text = (TextView) findViewById(R.id.textViewPodkategoria);
        TextView textKategoria = (TextView) findViewById(R.id.textViewKategoria);
        textKategoria.setText("Kategoria: "+ kategoria);

        podkategoria1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmPodkategoria = "Kategoria1";
                text.setText("Kategoria: " + alarmPodkategoria);
            }
        });

        podkategoria2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmPodkategoria = "Podkategoria2";
                text.setText("Podkategoria: " + alarmPodkategoria);
            }
        });

        podkategoria3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmPodkategoria = "Podkategoria3";
                text.setText("Podkategoria: " + alarmPodkategoria);
            }
        });

        podkategoria4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmPodkategoria = "Podkategoria4";
                text.setText("Podkategoria: " + alarmPodkategoria);
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
        String text=alarmPodkategoria;
        Intent intent = new Intent(this, alarmLokalizacja.class);
        intent.putExtra(PODKATEGORIA,text);
        startActivity(intent);
    };

}