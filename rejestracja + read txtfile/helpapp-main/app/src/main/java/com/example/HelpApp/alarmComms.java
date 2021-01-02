package com.example.HelpApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class alarmComms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_comms);

        Button dalej = (Button) findViewById(R.id.buttonDalej);

        EditText comment = (EditText)findViewById(R.id.editTextCom);

        dalej.setOnClickListener(new View.OnClickListener() {

            String comment_text = comment.getText().toString();

            // tutaj kodzina dodająca komentarz do pliku CSV

            @Override
            public void onClick(View v) {
                openStatus();
            }
        });
    }



    public void openStatus() {
        Intent intent = new Intent(this, alarmSummary.class);
        startActivity(intent);
    };
}

///////////////////////


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//
//        poleTekstowe1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                String tekst =poleTekstowe1.getText().toString();;
//                poleTekstowe2.setText(tekst);
//            }
//        });
//
//        poleTekstowe2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                String tekst =poleTekstowe2.getText().toString();;
//                poleTekstowe1.setText(tekst);
//            }
//        });
//    }