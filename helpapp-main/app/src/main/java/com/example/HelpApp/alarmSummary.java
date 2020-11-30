package com.example.HelpApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class alarmSummary extends AppCompatActivity {
    String template;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_summary);
        //przyciski
        Button dalej = (Button) findViewById(R.id.buttonDalej);
        Button popraw = (Button) findViewById(R.id.buttonPopraw);
        TextView tresc = (TextView) findViewById(R.id.textView20);
        //zmienne
        String kategoria;
        String podkategoria;
        String lokalizacjaUlica;
        String lokalizacjaLong;
        String lokalizacjaLat;
        String komentarz;
        //dane z poprzednich warstw
        Intent intent = getIntent();
        kategoria = intent.getStringExtra(alarmComms.KATEGORIA);
        podkategoria = intent.getStringExtra(alarmComms.PODKATEGORIA);
        lokalizacjaLat = intent.getStringExtra(alarmComms.LOKALIZACJA_LAT);
        lokalizacjaLong = intent.getStringExtra(alarmComms.LOKALIZACJA_LONG);
        lokalizacjaUlica = intent.getStringExtra(alarmComms.LOKALIZACJA_ULICA);
        komentarz = intent.getStringExtra(alarmComms.KOMENTARZ);

        //templatka zgłoszenia ( interaktywna )
        template="Zgłaszający: Imię Nazwisko " +
                "\n Nr telefonu: 666666666 " +
                "\n Lokalizacja: "+ lokalizacjaUlica +"\n" + lokalizacjaLong + "\n" + lokalizacjaLat +
                "\n Rodzaj zdarzenia: " + kategoria + " ( " +podkategoria + " )" +
                "\n Opis: " + komentarz;
        //pokazanie treści
        tresc.setText(template);


        dalej.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openStatus1();
            }
        });


        popraw.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openStatus2();
            }
        });

    }

    // operacje jeśli zostanie wybrany przycisk "wyślij"
    public void openStatus1() {
        Intent send = new Intent(this, mail.class);     // uruchom skrypt mail
        startActivity(send);

//        Intent intent = new Intent(this, alarmStusus.class);    // uruchom skrypt alarmStatus
//        startActivity(intent);
       };

    // operacje jeśli zostanie wybrany przycisk "popraw"
    public void openStatus2() {
        Intent intent = new Intent(this, alarm.class);      // uruchom skrypt alarm
        startActivity(intent);
    };


}