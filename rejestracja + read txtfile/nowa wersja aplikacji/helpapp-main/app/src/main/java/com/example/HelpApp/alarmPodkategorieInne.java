package com.example.HelpApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class alarmPodkategorieInne extends AppCompatActivity {

    String alarmPodkategoria;
    String kategoria;

    public static final String PODKATEGORIA ="Alarm.podkategoria";
    public static final String KATEGORIA ="Alarm.kategoria";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_podkategorie_inne);

        Intent intent = getIntent();
        kategoria = intent.getStringExtra(alarm.KATEGORIA);

        Button dalej = (Button) findViewById(R.id.buttonDalej);
        TextView text = (TextView) findViewById(R.id.textViewPodkategoria);
        TextView textKategoria = (TextView) findViewById(R.id.textViewKategoria);
        textKategoria.setText("Kategoria: "+ kategoria);

        EditText podkategoria = (EditText) findViewById(R.id.editTextPodkategoria);

        dalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmPodkategoria=podkategoria.getText().toString();
                if(alarmPodkategoria!=null){
                    openPodkategorie();
                }else{
                    Toast.makeText(getApplicationContext(),"Wybierz podkategorię", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openPodkategorie() {
        String text=alarmPodkategoria;
        Intent intent = new Intent(this, alarmLokalizacja.class);
        intent.putExtra(PODKATEGORIA,text);
        intent.putExtra(KATEGORIA,kategoria);
        startActivity(intent);
    }
}