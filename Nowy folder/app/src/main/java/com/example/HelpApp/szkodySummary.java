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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class szkodySummary extends AppCompatActivity {
    String nazwaFolderu;
    String template;
    String dane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szkody_summary);

        Button dalej= (Button) findViewById(R.id.buttonDalej2);
        Button popraw= (Button) findViewById(R.id.buttonPopraw3);
        TextView tresc = (TextView) findViewById(R.id.szablon);

        //zmienne
        String kategoria;
        String lokalizacjaUlica;
        String lokalizacjaLong;
        String lokalizacjaLat;
        String komentarz;
        Date currentTime = Calendar.getInstance().getTime();
        //dane z poprzednich warstw
        Intent intent = getIntent();
        kategoria = intent.getStringExtra(szkodyPodkategoria.KATEGORIA);
        lokalizacjaLat = intent.getStringExtra(szkodyPodkategoria.LOKALIZACJA_LAT);
        lokalizacjaLong = intent.getStringExtra(szkodyPodkategoria.LOKALIZACJA_LONG);
        lokalizacjaUlica = intent.getStringExtra(szkodyPodkategoria.LOKALIZACJA_ULICA);
        komentarz = intent.getStringExtra(szkodyPodkategoria.KOMENTARZ);
        nazwaFolderu= "Szkoda " + kategoria + currentTime.toString();

        //wczytywanie imienia i nazwiska oraz numeru telefonu
        FileReader fr=null;
        File myData = new File(Environment.getExternalStorageDirectory().toString() , "HelpApp/Main/Dane.txt" );
        StringBuilder stringBuilder = new StringBuilder();
        try{
            fr = new FileReader(myData);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null){
                stringBuilder.append(line).append('\n');
                line= br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            String fileContents =  stringBuilder.toString();
            dane = fileContents;
        }
        //templatka zgłoszenia
        template="ZGŁASZAJĄCY ZDARZENIE\n\n" + dane +
                "\n\n\nINFORMACJE O ZDARZENIU\n" +
                "\n Lokalizacja: "+ lokalizacjaUlica +"\n" + lokalizacjaLong + "\n" + lokalizacjaLat +
                "\n Rodzaj zdarzenia: " + kategoria  +
                "\n Opis: " + komentarz;
        //pokazanie treści
        tresc.setText(template);

        dalej.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                CreateFolder();
                createFile(v, nazwaFolderu );
                openMail();
            }
        });
        popraw.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openStatus();
            }
        });
    }
    public void openMail() {
        Intent send = new Intent(this, mail.class);     // uruchom skrypt mail
        startActivity(send);

//        Intent intent = new Intent(this, alarmStusus.class);    // uruchom skrypt alarmStatus
//        startActivity(intent);
    };

    public void openStatus() {
        Intent intent = new Intent(this, szkody.class);      // uruchom skrypt alarm
        startActivity(intent);
    };
    private void CreateFolder() {
        //inicjacja


        //tworzenie głównego repo
        String extStorageDirectory = Environment.getExternalStorageDirectory().toString() +"/HelpApp/Szkody";
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
                AlertDialog.Builder builder = new AlertDialog.Builder(szkodySummary.this);
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
            File root = new File(Environment.getExternalStorageDirectory().toString() + "/HelpApp/Szkody/" + folder);
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