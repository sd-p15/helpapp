package com.example.HelpApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;


public class ciekawostka extends AppCompatActivity {

    public ciekawostka() throws FileNotFoundException {
    }

    Integer numerCiekawostki;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ciekawostka);


        Intent intent = getIntent();
        numerCiekawostki = intent.getIntExtra(bazawiedzy.CIEKAWOSTKA_NO, -1);

        pobierzCiekawostke();

        Button powrot = (Button) findViewById(R.id.buttonPowrot);


        powrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWiedza();

            }
        });
    }

    public void pobierzCiekawostke(){

        TextView tekstCiekawostki = (TextView) findViewById(R.id.textView18);
        ImageView obrazekCiekawostki = (ImageView) findViewById(R.id.imageView);

        String text = "Przykładowy tekst ciekawostki" + numerCiekawostki;
            tekstCiekawostki.setText(text);
        Uri image = Uri.parse("android.resource://com.example.HelpApp/drawable/c" +
                numerCiekawostki);
        obrazekCiekawostki.setImageURI(image);
    };


    public void openWiedza() {
        Intent intent = new Intent(this, wiedza.class);
        startActivity(intent);
    }
};
