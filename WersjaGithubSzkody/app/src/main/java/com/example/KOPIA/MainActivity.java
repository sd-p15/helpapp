package com.example.KOPIA;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button szkoda = (Button) findViewById(R.id.SZKODA);
        szkoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSzkody();
            }
        });
    }

    public void openSzkody() {
        Intent intent = new Intent(this, SzkodyKategoria.class);
        startActivity(intent);
    }
}