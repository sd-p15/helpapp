package com.example.HelpApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class alarmComms extends AppCompatActivity {
    EditText comment;

    String komentarz;
    String Podkategoria;
    String kategoria;
    String lokalizacjaUlica;
    String lokalizacjaLatitude;
    String lokalizacjaLongtitude;

    public static final String LOKALIZACJA_ULICA ="Alarm.lokalizacjaUlica";
    public static final String LOKALIZACJA_LONG ="Alarm.lokalizacjaLong";
    public static final String LOKALIZACJA_LAT ="Alarm.lokalizacjaLat";
    public static final String PODKATEGORIA ="Alarm.lokalizacjaPodkategoria";
    public static final String KATEGORIA ="Alarm.lokalizacjaKategoria";
    public static final String KOMENTARZ ="Alarm.komentarz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_comms);

        Intent intent = getIntent();
        kategoria = intent.getStringExtra(alarmCamera.KATEGORIA);
        Podkategoria =intent.getStringExtra(alarmCamera.PODKATEGORIA);
        lokalizacjaLatitude =intent.getStringExtra(alarmCamera.LOKALIZACJA_LAT);
        lokalizacjaLongtitude =intent.getStringExtra(alarmCamera.LOKALIZACJA_LONG);
        lokalizacjaUlica =intent.getStringExtra(alarmCamera.LOKALIZACJA_ULICA);

        Button dalej = (Button) findViewById(R.id.buttonDalej);

        comment = (EditText)findViewById(R.id.editTextCom);

        dalej.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                openStatus();
            }
        });
    }



    public void openStatus() {
        komentarz = comment.getText().toString();
        Intent intent = new Intent(this, alarmSummary.class);
        intent.putExtra(KOMENTARZ,komentarz);
        intent.putExtra(LOKALIZACJA_ULICA,lokalizacjaUlica);
        intent.putExtra(LOKALIZACJA_LONG,lokalizacjaLongtitude);
        intent.putExtra(LOKALIZACJA_LAT,lokalizacjaLatitude);
        intent.putExtra(PODKATEGORIA,Podkategoria);
        intent.putExtra(KATEGORIA,kategoria);
        startActivity(intent);
    };
}

///////////////////////


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//
//        poleTekstowe1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                String tekst =poleTekstowe1.getText().toString();;
//                poleTekstowe2.setText(tekst);
//            }
//        });
//
//        poleTekstowe2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                String tekst =poleTekstowe2.getText().toString();;
//                poleTekstowe1.setText(tekst);
//            }
//        });
//    }