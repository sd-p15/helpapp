package com.example.HelpApp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class alarm extends AppCompatActivity {
    String alarmKategoria;
    public static final String KATEGORIA ="Alarm.kategoria";

    public alarm() throws FileNotFoundException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Button kategoria1 = (Button) findViewById(R.id.buttonKategoria1);
        Button kategoria2 = (Button) findViewById(R.id.buttonKategoria2);
        Button kategoria3 = (Button) findViewById(R.id.buttonKategoria3);
        Button kategoria4 = (Button) findViewById(R.id.buttonKategoria4);
        Button dalej = (Button) findViewById(R.id.buttonDalej);
        TextView text = (TextView) findViewById(R.id.textViewKategoria);

        kategoria1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmKategoria = "Kategoria1";
                text.setText("Kategoria: " + alarmKategoria);
            }
        });

        kategoria2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmKategoria = "Kategoria2";
                text.setText("Kategoria: " + alarmKategoria);
            }
        });

        kategoria3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmKategoria = "Kategoria3";
                text.setText("Kategoria: " + alarmKategoria);
            }
        });

        kategoria4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmKategoria = "Kategoria4";
                text.setText("Kategoria: " + alarmKategoria);
            }
        });

        dalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                writeToCSV();
                openPodkategorie();
            }
        });
    }


    //tutaj zapisz kategorię do CSV
//    public void writeToCSV() {
//        BufferedReader csvReader = null;
//        String head = "category1";
//        int index = 3;
//        String[] data = null;
//        try {
//            String sCurrentLine;
//            csvReader = new BufferedReader(new FileReader("form.csv"));
//
//            while ((sCurrentLine = csvReader.readLine()) != null) {
//            }
//            data = sCurrentLine.split(",");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (csvReader != null) csvReader.close();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//
//        data[index] = alarmKategoria;
//
//        FileWriter csvWriter = null;
//        try {
//            csvWriter = new FileWriter("form.csv");
//
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                csvWriter.append(String.join(",", data));
//            }
//
//            csvWriter.flush();
//            csvWriter.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (csvWriter != null) csvWriter.close();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//
//    }


    public void openPodkategorie() {
        String text=alarmKategoria;
        Intent intent = new Intent(this, alarmPodkategoria.class);
        intent.putExtra(KATEGORIA,text);
        startActivity(intent);
    };
}