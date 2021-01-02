package com.example.HelpApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class register extends AppCompatActivity {
    String template;
    String imieString;
    String telefonString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //przyciski
        Button dalej = (Button) findViewById(R.id.button);
        EditText imie = (EditText) findViewById(R.id.nazwisko);
        EditText telefon = (EditText) findViewById(R.id.telefon);

        dalej.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                imieString=imie.getText().toString();
                telefonString=telefon.getText().toString();
                template = "Imię i nazwisko: " + imieString +
                "\n Nr telefonu: " + telefonString;
                createFile(v );
                openMain();
            }
        });
    }

    // operacje jeśli zostanie wybrany przycisk "dalej"
    public void openMain() {
        Intent send = new Intent(this, MainActivity.class);
        startActivity(send);

    };





    //komenda zapisz string jako plik txt
    public void createFile(View v) {
        try {
            //tworzę interesującą mnie scieżkę
            File root = new File(Environment.getExternalStorageDirectory().toString() + "/HelpApp/Main");
            //sprawdzam czy jest poprawna
            if (root.exists()) {
                //nazwa pliku txt
                String nazwa = "Dane.txt";
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