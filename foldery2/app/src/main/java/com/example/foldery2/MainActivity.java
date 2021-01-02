package com.example.foldery2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.PatternMatcher;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    //zmienne
    String nazwa;
    String message;
    EditText text;
    Button main;
    Button alarm;
    Button szkody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //przypisanie deklaracji
        nazwa = "Test";
        text = (EditText) findViewById(R.id.editTextText);
        main = (Button) findViewById(R.id.buttonMain);
        alarm = (Button) findViewById(R.id.buttonAlarm);
        szkody = (Button) findViewById(R.id.buttonSzkody);
        //sprawdzenie pozwolenia na tworzenie folderów
        if (ActivityCompat.checkSelfPermission(MainActivity.this
                , Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED) {
            //kiedy jest pozwolenie
            //utwórz folder
            CreateFolder();
        } else {
            //kiedy nie ma zgody pytam o nią
            ActivityCompat.requestPermissions(MainActivity.this
                    , new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}
                    , 100);
        }
        //reagowanie na przyciski
        //przycisk main
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = text.getText().toString();
                createFile(v, "Main");
            }
        });
        //przycisk alarm

        //przycisk szkody

    }

    //komenda wydaj pozwolenie
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //sprawdzam warunki
        if (requestCode == 100 && (grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
            CreateFolder();
        } else {
            Toast.makeText(getApplicationContext(), "brak zgody", Toast.LENGTH_SHORT).show();
        }
    }

    //komenda utwórz nowy folder
    private void CreateFolder() {
        //inicjacja


        //tworzenie głównego repo
        String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
        File file = new File(extStorageDirectory, "HelpAPP");
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
                Toast.makeText(getApplicationContext(), "Utworzono folder główny", Toast.LENGTH_SHORT).show();

            } else {
                //jak nie ma wyswietlam alert
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                String message = "nie udalo sie utworzyc folderu glownego" +
                        "\nPath : " + Environment.getExternalStorageDirectory() +
                        "\nmkdir " + file.mkdir();
                builder.setMessage(message);
                builder.show();
            }
        }


        //tworzenie podfolderu Main ( config )
        String extStorageInner = extStorageDirectory + "/Helpapp";
        File file2 = new File(extStorageInner, "Main");
        if (file2.exists()) {
            //jesli istnieje
            //Toast.makeText(getApplicationContext(), "Folder istnieje", Toast.LENGTH_SHORT).show();
        } else {
            //kiedy nie ma folderu
            //tworzę nowy
            file2.mkdir();
            //sprawdzam
            if (file2.isDirectory()) {
                //jak utworzyło wuswietlam
                Toast.makeText(getApplicationContext(), "Utworzono folder main", Toast.LENGTH_SHORT).show();

            } else {
                //jak nie ma wyswietlam alert
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                String message = "nie udalo sie utworzyc folderu main" +
                        "\nPath : " + Environment.getExternalStorageDirectory() +
                        "\nmkdir " + file2.mkdir();
                builder.setMessage(message);
                builder.show();
            }
        }


        //Tworzenie podfolderu Alarmy
        File file3 = new File(extStorageInner, "Alarmy");
        if (file3.exists()) {
            //jesli istnieje
            //Toast.makeText(getApplicationContext(), "Folder istnieje", Toast.LENGTH_SHORT).show();
        } else {
            //kiedy nie ma folderu
            //tworzę nowy
            file3.mkdir();
            //sprawdzam
            if (file3.isDirectory()) {
                //jak utworzyło wuswietlam
                Toast.makeText(getApplicationContext(), "Utworzono folder alarmy", Toast.LENGTH_SHORT).show();

            } else {
                //jak nie ma wyswietlam alert
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                String message = "nie udalo sie utworzyc folderu Alarmy" +
                        "\nPath : " + Environment.getExternalStorageDirectory() +
                        "\nmkdir " + file3.mkdir();
                builder.setMessage(message);
                builder.show();
            }
        }


        //Tworzenie podfolderu Szkody
        File file4 = new File(extStorageInner, "Szkody");
        if (file4.exists()) {
            //jesli istnieje
            //Toast.makeText(getApplicationContext(), "Folder istnieje", Toast.LENGTH_SHORT).show();
        } else {
            //kiedy nie ma folderu
            //tworzę nowy
            file4.mkdir();
            //sprawdzam
            if (file4.isDirectory()) {
                //jak utworzyło wuswietlam
                Toast.makeText(getApplicationContext(), "Utworzono folder Szkody", Toast.LENGTH_SHORT).show();

            } else {
                //jak nie ma wyswietlam alert
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                String message = "nie udalo sie utworzyc folderu Szkody" +
                        "\nPath : " + Environment.getExternalStorageDirectory() +
                        "\nmkdir " + file4.mkdir();
                builder.setMessage(message);
                builder.show();
            }
        }
    }

    //komenda zapisz string jako plik txt
    public void createFile(View v, String folder) {
        try {
            //tworzę interesującą mnie scieżkę
            File root = new File(Environment.getExternalStorageDirectory().toString() + "/Helpapp/" + folder);
            //sprawdzam czy jest poprawna
            if (root.exists()) {
                // pobieranie daty i godziny
                Date currentTime = Calendar.getInstance().getTime();
                String nazwa = "Dane "+ currentTime.toString()+".txt";
                //tworzę scezke zapisu z nazwa pliku
                File filepath = new File(root, nazwa);
                //tworzę "pisak"
                FileWriter writer = new FileWriter(filepath);
                //w pliku pisze tekst
                writer.append(message);
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
