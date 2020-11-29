package com.example.loginandregistrationscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity2 extends AppCompatActivity {
    EditText mTextimie;
    EditText mTextnazwisko;
    EditText mTextnumer_telefonu;
    EditText mTextCnfnumer_telefonu;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        mTextimie = (EditText) findViewById(R.id.edittext_imie);
        mTextnazwisko = (EditText) findViewById(R.id.edittext_nazwisko);
        mTextCnfnumer_telefonu = (EditText) findViewById(R.id.edittext_cnf_numer_telefonu);

        mButtonRegister = (Button) findViewById(R.id.button_login);
        mTextViewLogin = (TextView) findViewById(R.id.textview_register);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(RegisterActivity2,this,MainActivity.class);
                startActivity(LoginIntent);

            }
        });
    }
}