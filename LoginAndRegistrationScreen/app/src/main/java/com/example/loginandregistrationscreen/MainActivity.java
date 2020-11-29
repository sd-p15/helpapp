package com.example.loginandregistrationscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText mTextimie;
    EditText mTextnazwisko;
    EditText mTextnumer_telefonu;
    Button mButtonLogin;
    TextView mTextViewRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextimie = (EditText) findViewById(R.id.edittext_imie);
        mTextnazwisko = (EditText) findViewById(R.id.edittext_nazwisko);
        mTextnumer_telefonu = (EditText) findViewById(R.id.edittext_numer_telefonu);
        mButtonLogin = (Button) findViewById(R.id.button_login);
        mTextViewRegister = (TextView) findViewById(R.id.textview_register);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this,RegisterActivity2.class);
                startActivity(registerIntent);

            }
        });
    }
}