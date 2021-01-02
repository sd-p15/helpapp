package com.example.HelpApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    Button button2;
    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.buttonAlarm);
        button2 = (Button) findViewById(R.id.buttonSzkody);
        button3 = (Button) findViewById(R.id.buttonWiedza);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlarm();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSzkody();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWiedza();
            }
        });
    }

    public void openAlarm() {
        Intent intent = new Intent(this, alarm.class);
        startActivity(intent);
    }
    public void openSzkody() {
        Intent intent = new Intent(this, szkody.class);
        startActivity(intent);
    }
    public void openWiedza() {
        Intent intent = new Intent(this, wiedza.class);
        startActivity(intent);
    }
}