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


    public void openStatus1() {
        Intent intent = new Intent(this, alarmStusus.class);
        startActivity(intent);
       };

    public void openStatus2() {
        Intent intent = new Intent(this, alarm.class);
        startActivity(intent);
    };


}