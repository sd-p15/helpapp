package com.example.HelpApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    //elementy GUI
    Button button;
    Button button2;
    Button button3;
    //deklaracja zmiennych tworzenia repozytorium


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //przypisanie GUI
        button = (Button) findViewById(R.id.buttonAlarm);
        button2 = (Button) findViewById(R.id.buttonSzkody);
        button3 = (Button) findViewById(R.id.buttonWiedza);
        // słuchacze przycisków
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlarm();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSzkody();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWiedza();
            }
        });

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

    }
    //komendy otwierania nowych stron
    public void openAlarm() {
        Intent intent = new Intent(this, alarm.class);
        startActivity(intent);
    }
    public void openSzkody() {
        Intent intent = new Intent(this, szkody.class);
        startActivity(intent);
    }
    public void openWiedza() {
        Intent intent = new Intent(this, wiedza.class);
        startActivity(intent);
    }

    //komenda wydaj pozwolenie
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //sprawdzam warunki
        if (requestCode == 100 && (grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
            //po wydaniu zgody sprawdz foldery
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
        File file = new File(extStorageDirectory, "HelpAPP" );
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
        String extStorageInner = extStorageDirectory + "/HelpAPP";
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


}