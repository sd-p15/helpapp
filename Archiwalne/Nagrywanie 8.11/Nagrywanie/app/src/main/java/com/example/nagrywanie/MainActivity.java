package com.example.nagrywanie;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.net.URI;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    private final int VIDEO_REQUEST_CODE = 100; //przechwytywanie nagrania?
    private Uri videoUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CaptureVideo(View view) {
        Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        File video_file = getFilepath();
        Uri video_uri = Uri.fromFile(video_file);
        videoIntent.putExtra(MediaStore.EXTRA_OUTPUT,video_uri);
        videoIntent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
        startActivityForResult(videoIntent,VIDEO_REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==VIDEO_REQUEST_CODE)
        {
            if (resultCode==RESULT_OK)
            {
                Toast.makeText(getApplicationContext(),"Video Successfully Recorded",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Video Capture Failed",Toast.LENGTH_LONG).show();
            }
        }
    }

    public void PlayVideo(View view)
    {
        Intent playIntent = new Intent(this, VideoPlayAcitvity.class);
        playIntent.putExtra("videoUri",videoUri.toString());
        startActivity(playIntent);

    }

    public File getFilepath ()
    {
        File folder = new File("adcard/video_app");
        if (folder.exists())
        {
            folder.mkdir();
        }
        File video_file = new File(folder,"sample_video.mp4");

        return video_file;
    } //tworzy folder

    protected void onActiviyResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == VIDEO_REQUEST && resultCode == RESULT_OK)
        {
            videoUri = data.getData();
        }
    }
}

//rozpoczyna i kończy nagrywanie, sprawdza czy odpowiednio się nagrało i wytwarza plik?






