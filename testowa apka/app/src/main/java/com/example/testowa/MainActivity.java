package com.example.testowa;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //deklaracja zgody na polaczenie
    private static final int REQUEST_CALL =1;
    @Override
    //onCreate - odpalanie aplikacji
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //zdjecie sluchawki - nawigacja
        ImageView imageCall = findViewById(R.id.imageCall);
        //dodanie akcji na nacisniecie sluchawki
        imageCall.setOnClickListener(new View.OnClickListener() {
            //komendy podczas akcji nacisniecia ikony
            public void onClick(View v) {
                //wykonaj polaczenie
                makePhoneCall();
                //przyszłe zacznij nagrywanie
                //przyszłe nagraj kamere
                //przyszłe udostepnij lokalizacje
            }
        });
    }
    //funkcja wykonania połaczenia
    private void makePhoneCall(){
        String number ="134673334";
        if(ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);

        }else{
            String dial ="tel:" + number;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }

    }
    //funkcja uzyskania dostepu do wykonywania połączen przez aplikacje
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL) {
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            }else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}