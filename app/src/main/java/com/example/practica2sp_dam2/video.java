package com.example.practica2sp_dam2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class video extends AppCompatActivity {
    Button play, pause, reand, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        play = (Button) findViewById(R.id.playV);
        pause = (Button) findViewById(R.id.pauseV);
        reand = (Button) findViewById(R.id.continueV);
        stop = (Button) findViewById(R.id.stopV);

        Uri myUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videofile);
        VideoView vidW = (VideoView)findViewById(R.id.visualiceVideo);
        vidW.setVideoURI(myUri);
        vidW.setMediaController(new MediaController(this));

        vidW.requestFocus();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vidW.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vidW.pause();
            }
        });

        reand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vidW.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vidW.stopPlayback();
                vidW.seekTo(0);
            }
        });
    }
}