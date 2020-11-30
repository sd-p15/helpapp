package com.example.HelpApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class szkodySummary extends AppCompatActivity {
    String template;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szkody_summary);

        Button dalej= (Button) findViewById(R.id.wyslij);
        TextView tresc = (TextView) findViewById(R.id.szablon);

        //zmienne
        String kategoria;
        String lokalizacjaUlica;
        String lokalizacjaLong;
        String lokalizacjaLat;
        String komentarz;
        //dane z poprzednich warstw
        Intent intent = getIntent();
        kategoria = intent.getStringExtra(szkodyPodkategoria.KATEGORIA);
        lokalizacjaLat = intent.getStringExtra(szkodyPodkategoria.LOKALIZACJA_LAT);
        lokalizacjaLong = intent.getStringExtra(szkodyPodkategoria.LOKALIZACJA_LONG);
        lokalizacjaUlica = intent.getStringExtra(szkodyPodkategoria.LOKALIZACJA_ULICA);
        komentarz = intent.getStringExtra(szkodyPodkategoria.KOMENTARZ);

        template="Zgłaszający: Imię Nazwisko " +
                "\n Nr telefonu: 666666666 " +
                "\n Lokalizacja: "+ lokalizacjaUlica +"\n" + lokalizacjaLong + "\n" + lokalizacjaLat +
                "\n Rodzaj zdarzenia: " + kategoria  +
                "\n Opis: " + komentarz;
        //pokazanie treści
        tresc.setText(template);

        dalej.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //wyslij();
            }
        });
    }

}