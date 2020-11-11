package com.example.HelpApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class szkody extends AppCompatActivity {
    private Button button2;
    ImageButton imageButton;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    ImageButton imageButton5;
    ImageButton imageButton6;
    ImageButton imageButton7;
    ImageButton imageButton8;
    ImageButton imageButton9;
    ImageButton imageButton10;
    ImageButton imageButton11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szkody);
        imageButton = (ImageButton) findViewById(R.id.buttonDrogi);
        imageButton2 = (ImageButton) findViewById(R.id.buttonKomunikacja);
        imageButton3 = (ImageButton) findViewById(R.id.buttonLokalowe);
        imageButton4 = (ImageButton) findViewById(R.id.buttonOdsniezanie);
        imageButton5 = (ImageButton) findViewById(R.id.buttonSmieci);
        imageButton6 = (ImageButton) findViewById(R.id.buttonDewastacja);
        imageButton7 = (ImageButton) findViewById(R.id.buttonKanalizacyjne);
        imageButton8 = (ImageButton) findViewById(R.id.buttonZielen);
        imageButton9 = (ImageButton) findViewById(R.id.buttonZwierzeta);
        imageButton10 = (ImageButton) findViewById(R.id.buttonPorzadek);
        imageButton11 = (ImageButton) findViewById(R.id.buttonInne);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrogi();

            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openKomunikacja();
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLokalowe();
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOdsniezanie();
            }
        });
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSmieci();
            }
        });
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDewastacja();
            }
        });
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openKanalizacyjne();

            }
        });
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openZielen();

            }
        });
        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openZwierzeta();

            }
        });
        imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPorzadek();

            }
        });
        imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInne();
            }
        });

    }
    public void openDrogi() {
        Intent intent = new Intent(this, drogi.class);
        startActivity(intent);
    }
    public void openKomunikacja() {
        Intent intent = new Intent(this, komunikacja.class);
        startActivity(intent);
    }
    public void openLokalowe() {
        Intent intent = new Intent(this, lokalowe.class);
        startActivity(intent);
    }
    public void openOdsniezanie() {
        Intent intent = new Intent(this, odsniezanie.class);
        startActivity(intent);
    }
    public void openSmieci() {
        Intent intent = new Intent(this, smieci.class);
        startActivity(intent);
    }
    public void openDewastacja() {
        Intent intent = new Intent(this, dewastacja.class);
        startActivity(intent);
    }
    public void openKanalizacyjne() {
        Intent intent = new Intent(this, kanalizacyjne.class);
        startActivity(intent);
    }
    public void openZielen() {
        Intent intent = new Intent(this, zielen.class);
        startActivity(intent);
    }
    public void openZwierzeta() {
        Intent intent = new Intent(this, zwierzeta.class);
        startActivity(intent);
    }
    public void openPorzadek() {
        Intent intent = new Intent(this, porzadek.class);
        startActivity(intent);
    }
    public void openInne() {
        Intent intent = new Intent(this, inne.class);
        startActivity(intent);
    }

}
