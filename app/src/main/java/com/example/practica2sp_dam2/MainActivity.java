package com.example.practica2sp_dam2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button actVideo, actSonido, actAyuda, pauseSonido, detSonido;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actVideo = (Button) findViewById(R.id.bplay_video);
        actSonido = (Button) findViewById(R.id.bplay_audio);
        actAyuda = (Button) findViewById(R.id.b_ayuda);
        //pauseSonido = (Button) findViewById(R.id.bpause_audio);
        //detSonido = (Button) findViewById(R.id.bstop_audio);
        //mp = MediaPlayer.create(MainActivity.this,R.raw.sonido_de_inicio_y_cierre_de_windows_7_mp3_41203);

        actVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), video.class);
                startActivity(intent);
            }
        });

        actSonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), audio.class);
                startActivity(intent);
            }
        });

        /*pauseSonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPause();
            }
        });

        detSonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundStop();
            }
        });*/

        actAyuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifyMost();
            }
        });
    }

    /*private void playedAudio() {
        Uri myUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sonido_de_inicio_y_cierre_de_windows_7_mp3_41203);
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(getApplicationContext(),myUri);
            } catch (IOException f) {
                f.printStackTrace();
            } catch(IllegalStateException f1){
                f1.printStackTrace();
            } catch(SecurityException f2){
                f2.printStackTrace();
            } catch(IllegalArgumentException f3){
                f3.printStackTrace();
            }

            mediaPlayer.setLooping(true);
            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                @Override
                public boolean onInfo(MediaPlayer mp, int what, int extra) {
                    return false;
                }
            });

            mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                @Override
                public void onBufferingUpdate(MediaPlayer mp, int percent) {

                }
            });
        SurfaceView surface = (SurfaceView)findViewById(R.id.videoplay);
        SurfaceHolder superficie = surface.getHolder();
        superficie.setKeepScreenOn(true);
        superficie.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                mediaPlayer.setDisplay(superficie);
                try {
                    mediaPlayer.prepare();
                } catch (IOException f) {
                    f.printStackTrace();
                }catch(IllegalStateException f1){
                    f1.printStackTrace();
                }
                mediaPlayer.start();
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
            }
        });
    }*/

    /*private void soundPlay() {
        Uri myUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sonido_de_inicio_y_cierre_de_windows_7_mp3_41203);
        MediaPlayer mediaPlayer = new MediaPlayer();

        try {
            mediaPlayer.setDataSource(this,myUri);
        } catch (IOException f) {
            f.printStackTrace();
        }

        try {
            mediaPlayer.prepare();
        } catch (IOException f) {
            f.printStackTrace();
        }

        mediaPlayer.start();
        }*/

    /*private void soundPause() {
        Uri myUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sonido_de_inicio_y_cierre_de_windows_7_mp3_41203);
        MediaPlayer mediaPlayer = new MediaPlayer();

        try {
            mediaPlayer.setDataSource(this,myUri);
        } catch (IOException f) {
            f.printStackTrace();
        }

        try {
            mediaPlayer.prepare();
        } catch (IOException f) {
            f.printStackTrace();
        }

        mediaPlayer.pause();
    }*/

    /*private void soundStop() {
        Uri myUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sonido_de_inicio_y_cierre_de_windows_7_mp3_41203);
        MediaPlayer mediaPlayer = new MediaPlayer();

        try {
            mediaPlayer.setDataSource(this,myUri);
        } catch (IOException f) {
            f.printStackTrace();
        }

        try {
            mediaPlayer.prepare();
        } catch (IOException f) {
            f.printStackTrace();
        }

        mediaPlayer.stop();
    }*/

    private void notifyMost() {
        int NOTIFICATION_ID= 1;
        Context context=getApplicationContext();
        NotificationManager notificationManager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String CHANNEL_ID = "chanelPcpal";
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence nombre= "Chanel_1";
            String description = "Canal Principal";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mCanal= new NotificationChannel(CHANNEL_ID,nombre,importance);
            mCanal.setDescription(description);
            mCanal.enableLights(true);
            mCanal.setLightColor(Color.GREEN);
            mCanal.enableVibration(true);
            mCanal.setVibrationPattern(new long[]{100,200,300,400,500,400,300,200,400});
            mCanal.setShowBadge(false);
            notificationManager.createNotificationChannel(mCanal);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID)
                .setSmallIcon(R.drawable.bienvenidoimg)
                .setContentTitle("Nueva Notificación")
                .setContentText("Bienvenido al reproductor, gracias por su confianza");
        Intent intent = new Intent(context,MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent=stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        notificationManager.notify(NOTIFICATION_ID,builder.build());

    }

    /*public void soundPlay(View view){
        mp.start();
    }
    public void soundPause(View view){
        mp.pause();
    }
    public void soundStop(View view){
        mp.stop();
    }*/
}