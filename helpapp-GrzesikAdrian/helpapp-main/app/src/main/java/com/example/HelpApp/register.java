package com.example.HelpApp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
        CheckBox polityka = (CheckBox) findViewById(R.id.checkBoxPolityka);
        CheckBox regulamin = (CheckBox) findViewById(R.id.checkBoxRegulamin);

        dalej.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(polityka.isChecked() && regulamin.isChecked()){
                    imieString=imie.getText().toString();
                    telefonString=telefon.getText().toString();
                    template = "Imię i nazwisko: " + imieString +
                            "\n Nr telefonu: " + telefonString;
                    createFile(v );
                    openMain();
                }else{
                    Toast.makeText(getApplicationContext(), "Zaakceptuj politykę i regulamin", Toast.LENGTH_LONG).show();
                }
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