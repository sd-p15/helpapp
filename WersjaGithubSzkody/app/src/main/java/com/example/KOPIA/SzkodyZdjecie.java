package com.example.KOPIA;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SzkodyZdjecie extends AppCompatActivity {

    ImageView zdjecie;
    Button zrobZdjecieButton;
    public String kategoria;
    public String podkategoria;
    public String komentarz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szkody_zdjecie);

        Intent intent = getIntent();
        kategoria = intent.getStringExtra(SzkodyPodkategoria.KATEGORIA);
        podkategoria = intent.getStringExtra(SzkodyPodkategoria.PODKATEGORIA);
        komentarz = intent.getStringExtra(SzkodyPodkategoria.KOMENTARZ);

        TextView kategoriaText = (TextView) findViewById(R.id.kategoria);
        TextView podkategoriaText = (TextView) findViewById(R.id.podkategoria);
        TextView komentarzText = (TextView) findViewById(R.id.komentarz);

        kategoriaText.setText(kategoria);
        podkategoriaText.setText(podkategoria);
        komentarzText.setText(komentarz);

        zrobZdjecieButton =  findViewById(R.id.zrobZdjecieButton);
        Button wyslijButton = (Button) findViewById(R.id.wyslij);

        zdjecie =  findViewById(R.id.zdjecie);



        zrobZdjecieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Zgoda na robienie zdjec
                if(ContextCompat.checkSelfPermission(SzkodyZdjecie.this,
                        Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(SzkodyZdjecie.this,
                            new String [] {
                                    Manifest.permission.CAMERA
                            },
                            100);
                }
                Intent intent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });

        wyslijButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wyslij();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            Bitmap captureImage = (Bitmap) data.getExtras().get("data");
            zdjecie.setImageBitmap(captureImage);

        }
    }
    public void wyslij() {
        //nazwa maila zbiorczego
        String mail = "testapp7040@gmail.com";
        //tytuł maila
        String subject ="Zgłoszenie szkody: "+kategoria;
        //formatka
        String message = "Zgłaszam szkodę : "+ kategoria+ "\n" +
                "Rodzaj podkategorii : "+ podkategoria +"\n" +
                "Komentarz: "+ komentarz +"\n" +
                "Lokalizacja gps: ";
        //send Mail
        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mail, subject, message);

        javaMailAPI.execute();

    }
}
