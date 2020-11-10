package com.haroonstudios.mini.nagraj_dzwiek.Services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.IBinder;
import android.os.SystemClock;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.IOException;

public class RecordingService extends Service
{

    MediaRecorder mediaRecorder;
    long mStaardingTimeMillis = 0;
    long mElapsedMillis = 0;

    File file;

    String fileName;



    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //return super.onStartCommand(intent, flags, startId);
        statRecording();
        return START_STICKY;
    }

    private void statRecording()
    {
        Long tsLong = System.currentTimeMillis()/1000;
        String ts = tsLong.toString();

        fileName = "audio_"+ts;

        file = new File(Environment.getExternalStorageDirectory() + "/MySoundRec/"+fileName+".mp3");
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        mediaRecorder.setOutputFile(file.getAbsolutePath());
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
        mediaRecorder.setAudioChannels(1);


        try
        {
                mediaRecorder.prepare();
                mediaRecorder.start();

                mStaardingTimeMillis = System.currentTimeMillis();

        }


        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // sposob usuwania nagranych

    private void stopRecording()
    {
        mediaRecorder.stop();
        mElapsedMillis = (System.currentTimeMillis() - mStaardingTimeMillis);
        mediaRecorder.release();
        Toast.makeText(getApplicationContext(),"Recording saved " + file.getAbsolutePath(),Toast.LENGTH_LONG).show();



    }



    @Override
    public void onDestroy() {
        if (mediaRecorder!=null)
        {
            stopRecording();
        }
        super.onDestroy();

    }
}
