package com.example.HelpApp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class alarmSummary extends AppCompatActivity {
    String nazwaFolderu;
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
        Date currentTime = Calendar.getInstance().getTime();
        nazwaFolderu= "Zgłoszenie" + currentTime.toString();
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
                CreateFolder();
                createFile(v, nazwaFolderu );
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

    private void CreateFolder() {
        //inicjacja


        //tworzenie głównego repo
        String extStorageDirectory = Environment.getExternalStorageDirectory().toString() +"/HelpApp/Alarmy";
        File file = new File(extStorageDirectory, nazwaFolderu );
        //sprawdzam warunki
        if (file.exists()) {
            //jesli istnieje
            //Toast.makeText(getApplicationContext(), "Folder istnieje", Toast.LENGTH_SHORT).show();
        } else {
            //kiedy nie ma folderu
            //tworzę nowy
            file.mkdir();
            //sprawdzam
            if (file.isDirectory()) {
                //jak utworzyło wuswietlam
                Toast.makeText(getApplicationContext(), "Utworzono folder zgłoszenia", Toast.LENGTH_SHORT).show();

            } else {
                //jak nie ma wyswietlam alert
                AlertDialog.Builder builder = new AlertDialog.Builder(alarmSummary.this);
                String message = "nie udalo sie utworzyc folderu glownego" +
                        "\nPath : " + Environment.getExternalStorageDirectory() +
                        "\nmkdir " + file.mkdir();
                builder.setMessage(message);
                builder.show();
            }
        }
    }

    //komenda zapisz string jako plik txt
    public void createFile(View v, String folder ) {
        try {
            //tworzę interesującą mnie scieżkę
            File root = new File(Environment.getExternalStorageDirectory().toString() + "/HelpApp/Alarmy/" + folder);
            //sprawdzam czy jest poprawna
            if (root.exists()) {
                //nazwa pliku txt
                String nazwa = "Treść zgłoszenia.txt";
                //tworzę scezke zapisu z nazwa pliku
                File filepath = new File(root, nazwa);
                //tworzę "pisak"
                FileWriter writer = new FileWriter(filepath);
                //w pliku pisze tekst
                writer.append(template);
                //zatwierdzam
                writer.flush();
                //zamykam
                writer.close();
            }
            //warunek bezpieczenstwa
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}