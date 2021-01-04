package com.example.HelpApp;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class ciekawostka extends AppCompatActivity {

    public ciekawostka() throws FileNotFoundException {
    }

    Integer numerCiekawostki;




    @RequiresApi(api = Build.VERSION_CODES.O)
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void pobierzCiekawostke(){

        TextView tekstCiekawostki = (TextView) findViewById(R.id.textView18);
        tekstCiekawostki.setMovementMethod(new ScrollingMovementMethod());

        String data;

        StringBuilder sbuffer = new StringBuilder();
        InputStream is = this.getResources().openRawResource(R.raw.ciekawostki);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        if (is != null){

            try{

                Integer counter = 0;

                while ((data = reader.readLine()) != null) {

                    if (counter.equals(numerCiekawostki)){
                        sbuffer.append(data.replace("&", "\n").replace(
                                " - ", "\n\n"));
                    }
                    counter ++;

                }

                is.close();


            } catch (IOException e) {
                sbuffer.append("nie wczytały się");
                e.printStackTrace();
            }
            tekstCiekawostki.setText(sbuffer);
        }


        ImageView obrazekCiekawostki = (ImageView) findViewById(R.id.imageView);

        Uri image = Uri.parse("android.resource://com.example.HelpApp/drawable/c" +
                numerCiekawostki);
        obrazekCiekawostki.setImageURI(image);
    };


    public void openWiedza() {
        Intent intent = new Intent(this, bazawiedzy.class);
        startActivity(intent);
    }
};
