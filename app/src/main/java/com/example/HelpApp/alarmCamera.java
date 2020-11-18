package com.example.HelpApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;

import java.net.URI;
import java.util.jar.Attributes;

public class alarmCamera extends AppCompatActivity {
    private static int VIDEO_REQUEST = 101;
    private Uri videoUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_camera);

        Button dalej = (Button) findViewById(R.id.buttonDalej);

        dalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openComms();
            }
        });
    }

    public void CaptureVideo(View view) {
        Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        if (videoIntent.resolveActivity(getPackageManager()) != null)
            startActivityForResult(videoIntent, VIDEO_REQUEST); //rozpoczęcie nagrywania

    }

        protected void onActiviyResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == VIDEO_REQUEST && resultCode == RESULT_OK) //daje zwrot czy aktywność została pomyślnie zakończona
        {
            videoUri = data.getData();
        }
    }

    public void openComms() {
        Intent intent = new Intent(this, alarmComms.class);
        startActivity(intent);
    };
}