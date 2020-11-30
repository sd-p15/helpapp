package com.example.HelpApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class alarmPodkategoriePomocMedyczna extends AppCompatActivity {
    String alarmPodkategoria;
    public static final String PODKATEGORIA ="Alarm.podkategoria";
    public static final String KATEGORIA ="Alarm.kategoria";
    String kategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_podkategorie_pomoc_medyczna);

        Intent intent = getIntent();
        kategoria = intent.getStringExtra(alarm.KATEGORIA);

        Button podkategoria1 = (Button) findViewById(R.id.buttonPodkategoria1);
        Button podkategoria2 = (Button) findViewById(R.id.buttonPodkategoria2);
        Button podkategoria3 = (Button) findViewById(R.id.buttonPodkategoria3);
        Button podkategoria4 = (Button) findViewById(R.id.buttonPodkategoria4);
        Button podkategoria5 = (Button) findViewById(R.id.buttonPodkategoria5);
        Button podkategoria6 = (Button) findViewById(R.id.buttonPodkategoria6);
        Button dalej = (Button) findViewById(R.id.buttonDalej);
        TextView text = (TextView) findViewById(R.id.textViewPodkategoria);
        TextView textKategoria = (TextView) findViewById(R.id.textViewKategoria);
        textKategoria.setText("Kategoria: "+ kategoria);

        podkategoria1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmPodkategoria = "Zasłabnięcie";
                text.setText("Kategoria: " + alarmPodkategoria);
            }
        });

        podkategoria2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmPodkategoria = "Atak Drgawek";
                text.setText("Podkategoria: " + alarmPodkategoria);
            }
        });

        podkategoria3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmPodkategoria = "Tonięcie";
                text.setText("Podkategoria: " + alarmPodkategoria);
            }
        });

        podkategoria4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmPodkategoria = "Złamanie";
                text.setText("Podkategoria: " + alarmPodkategoria);
            }
        });
        podkategoria5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmPodkategoria = "Krwotok";
                text.setText("Podkategoria: " + alarmPodkategoria);
            }
        });
        podkategoria6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmPodkategoria = "Zatrucie";
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