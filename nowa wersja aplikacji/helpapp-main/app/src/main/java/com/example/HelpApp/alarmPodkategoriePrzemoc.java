package com.example.HelpApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class alarmPodkategoriePrzemoc extends AppCompatActivity {

    String alarmPodkategoria;
    String kategoria;

    public static final String PODKATEGORIA ="Alarm.podkategoria";
    public static final String KATEGORIA ="Alarm.kategoria";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_podkategorie_przemoc);

        Intent intent = getIntent();
        kategoria = intent.getStringExtra(alarm.KATEGORIA);


        Button podkategoria1 = (Button) findViewById(R.id.buttonPodkategoria1);
        Button podkategoria2 = (Button) findViewById(R.id.buttonPodkategoria2);
        Button podkategoria3 = (Button) findViewById(R.id.buttonPodkategoria3);
        Button podkategoria4 = (Button) findViewById(R.id.buttonPodkategoria4);
        Button podkategoria5 = (Button) findViewById(R.id.buttonPrzemocInne);
        Button dalej = (Button) findViewById(R.id.buttonDalej);
        TextView text = (TextView) findViewById(R.id.textViewPodkategoria);
        TextView textKategoria = (TextView) findViewById(R.id.textViewKategoria);
        textKategoria.setText("Kategoria: "+ kategoria);

        podkategoria1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmPodkategoria = "Atak terrorystyczny";
                text.setText("Podkategoria: " + alarmPodkategoria);
            }
        });

        podkategoria2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmPodkategoria = "Napad";
                text.setText("Podkategoria: " + alarmPodkategoria);
            }
        });

        podkategoria3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmPodkategoria = "Bójka";
                text.setText("Podkategoria: " + alarmPodkategoria);
            }
        });

        podkategoria4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmPodkategoria = "Cyberprzemoc";
                text.setText("Podkategoria: " + alarmPodkategoria);
            }
        });
        podkategoria5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmPodkategoria = "Inne ";
                text.setText("Podkategoria: " + alarmPodkategoria);
            }
        });

        dalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(alarmPodkategoria!=null){
                    openPodkategorie();
                }else{
                    Toast.makeText(getApplicationContext(),"Wybierz podkategorię", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openPodkategorie() {
        String text=alarmPodkategoria;
        Intent intent = new Intent(this, alarmLokalizacja.class);
        intent.putExtra(PODKATEGORIA,text);
        intent.putExtra(KATEGORIA,kategoria);
        startActivity(intent);
    }
}