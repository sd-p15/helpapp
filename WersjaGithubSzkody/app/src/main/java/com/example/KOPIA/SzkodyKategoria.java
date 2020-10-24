package com.example.KOPIA;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SzkodyKategoria extends AppCompatActivity {
    String kategoria;
    public static final String KATEGORIA ="SzkodyKategoria.kategoria";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szkody_kategoria);
        //Pierwsza Kategoria
        Button wandalizm = (Button) findViewById(R.id.Wandalizm);
        //Akcja przycisku
        wandalizm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kategoria = "Wandalizm";
                openPodkategorie();
            }
        });
        //2 Kategoria
        Button olej = (Button) findViewById(R.id.PlamaOleju);
        //Akcja Przycisku
        olej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kategoria = "Olej";
                openPodkategorie();
            }
        });
        //3 Kategoria
        Button nieporzadek = (Button) findViewById(R.id.Nieporzadek);
        //Akcja Przycisku
        nieporzadek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kategoria = "Nieporządek";
                openPodkategorie();

            }
        });
        //4 Kategoria
        Button inne = (Button) findViewById(R.id.Inne);
        //Akcja Przycisku
        inne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kategoria = "Inne";
                openPodkategorie();
            }
        });

    }

    public void openPodkategorie() {
        String text=kategoria;
        Intent intent = new Intent(this, SzkodyPodkategoria.class);
        intent.putExtra(KATEGORIA,text);
        startActivity(intent);
    };
}