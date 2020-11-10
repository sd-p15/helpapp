package com.example.nagrywanie;

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

public class MainActivity extends AppCompatActivity {
    private static int VIDEO_REQUEST = 101;
    private Uri videoUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CaptureVideo(View view) {
        Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        if (videoIntent.resolveActivity(getPackageManager()) != null)
            startActivityForResult(videoIntent, VIDEO_REQUEST); //rozpoczęcie nagrywania

    }

    public void PlayVideo(View view)
    {
        Intent playIntent = new Intent(this, VideoPlayAcitvity.class);
        playIntent.putExtra("videoUri",videoUri.toString()); //tutaj to videoUri jest z VideoPlayActivity, dzięki temu możemy odtworzyć
        startActivity(playIntent); //rezultat aktywności - film

    }

    protected void onActiviyResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == VIDEO_REQUEST && resultCode == RESULT_OK) //daje zwrot czy aktywność została pomyślnie zakończona
        {
            videoUri = data.getData();
        }
    }
}








