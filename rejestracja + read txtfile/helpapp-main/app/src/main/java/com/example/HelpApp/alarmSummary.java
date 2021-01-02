package com.example.HelpApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class alarmSummary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_summary);

        Button dalej = (Button) findViewById(R.id.buttonDalej);
        Button popraw = (Button) findViewById(R.id.buttonPopraw);

        dalej.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openStatus1();
            }
        });


        popraw.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openStatus2();
            }
        });

    }

    // operacje jeśli zostanie wybrany przycisk "wyślij"
    public void openStatus1() {
        Intent send = new Intent(this, mail.class);     // uruchom skrypt mail
        startActivity(send);

//        Intent intent = new Intent(this, alarmStusus.class);    // uruchom skrypt alarmStatus
//        startActivity(intent);
       };

    // operacje jeśli zostanie wybrany przycisk "popraw"
    public void openStatus2() {
        Intent intent = new Intent(this, alarm.class);      // uruchom skrypt alarm
        startActivity(intent);
    };


}