package com.example.reproductormusica;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = null;
    }


    public void music(View view) {

        switch (view.getId()) {

            case R.id.btnPlay:
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.music);

                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        stopMusic();
                    }

                });
                mediaPlayer.start();
                break;

            case R.id.btnPause:
                if (mediaPlayer != null)
                    mediaPlayer.pause();
                break;

            case R.id.btnStop:
                if (mediaPlayer != null)
                    mediaPlayer.stop();
                stopMusic();


        }


    }

    private void stopMusic() {
        mediaPlayer.release();
        mediaPlayer = null;


    }

}