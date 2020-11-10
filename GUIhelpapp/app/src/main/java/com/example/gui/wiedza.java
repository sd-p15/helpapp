package com.example.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class wiedza extends AppCompatActivity {
    ImageButton imageButton12;
    ImageButton imageButton13;
    ImageButton imageButton14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiedza);
        imageButton12 = (ImageButton) findViewById(R.id.buttoninfoopandemii);
        imageButton13 = (ImageButton) findViewById(R.id.buttonBazaWiedzy);
        imageButton14 = (ImageButton) findViewById(R.id.buttonQuiz);

        imageButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfopandemia();

            }
        });
        imageButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBazawiedzy();
            }
        });
        imageButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuiz();
            }
        });
    }
    public void openInfopandemia() {
        Intent intent = new Intent(this, infopandemia.class);
        startActivity(intent);
    }
    public void openBazawiedzy() {
        Intent intent = new Intent(this, bazawiedzy.class);
        startActivity(intent);
    }
    public void openQuiz() {
        Intent intent = new Intent(this, quiz.class);
        startActivity(intent);
    }
}