package com.example.practica2sp_dam2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class audio extends AppCompatActivity {
    Button playSonido, pauseSonido, detSonido;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        playSonido = (Button) findViewById(R.id.btplay_audio);
        pauseSonido = (Button) findViewById(R.id.bpause_audio);
        detSonido = (Button) findViewById(R.id.bstop_audio);
        mp = MediaPlayer.create(audio.this,R.raw.sonido_de_inicio_y_cierre_de_windows_7_mp3_41203);
    }
    //public void soundPlay(View view){

    public void setPlaySonido(Button playSonido) {
        this.playSonido = playSonido;
        mp.start();
    }
    public void soundPause(View view){
        mp.pause();
    }
    public void soundStop(View view){
        mp.stop();
    }
}