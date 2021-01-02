package com.example.HelpApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;

import java.net.URI;
import java.util.jar.Attributes;

public class alarmCamera extends AppCompatActivity {
    private static int VIDEO_REQUEST = 101;
    private Uri videoUri = null;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_camera);

        Intent intent = getIntent();
        kategoria = intent.getStringExtra(alarmLokalizacja.KATEGORIA);
        Podkategoria =intent.getStringExtra(alarmLokalizacja.PODKATEGORIA);
        lokalizacjaLatitude =intent.getStringExtra(alarmLokalizacja.LOKALIZACJA_LAT);
        lokalizacjaLongtitude =intent.getStringExtra(alarmLokalizacja.LOKALIZACJA_LONG);
        lokalizacjaUlica =intent.getStringExtra(alarmLokalizacja.LOKALIZACJA_ULICA);

        Button dalej = (Button) findViewById(R.id.buttonDalej);

        dalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openComms();
            }
        });
    }

    public void CaptureVideo(View view) {
        Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        if (videoIntent.resolveActivity(getPackageManager()) != null)
            startActivityForResult(videoIntent, VIDEO_REQUEST); //rozpoczęcie nagrywania

    }

        protected void onActiviyResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == VIDEO_REQUEST && resultCode == RESULT_OK) //daje zwrot czy aktywność została pomyślnie zakończona
        {
            videoUri = data.getData();
        }
    }

    public void openComms() {
        Intent intent = new Intent(this, alarmComms.class);
        intent.putExtra(LOKALIZACJA_ULICA,lokalizacjaUlica);
        intent.putExtra(LOKALIZACJA_LONG,lokalizacjaLongtitude);
        intent.putExtra(LOKALIZACJA_LAT,lokalizacjaLatitude);
        intent.putExtra(PODKATEGORIA,Podkategoria);
        intent.putExtra(KATEGORIA,kategoria);
        startActivity(intent);
    };
}