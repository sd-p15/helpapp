package com.example.nagrywanie;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class VideoPlayAcitvity extends AppCompatActivity {
    private VideoView mVideoView; //tworzenie aktywności - wyświetlenie video
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play_acitvity);
        mVideoView=findViewById(R.id.videoView);
        Uri videoUri = Uri.parse(getIntent().getExtras().getString("videoUri"));
        mVideoView.setVideoURI(videoUri);
        mVideoView.start();

    }
}