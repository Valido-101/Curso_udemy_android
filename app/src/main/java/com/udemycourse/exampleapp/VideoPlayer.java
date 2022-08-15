package com.udemycourse.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        //Obtenemos el videoView
        VideoView video = (VideoView)findViewById(R.id.videoView);

        //Asignamos media controller
        MediaController mediaController = new MediaController(this);

        //Anclamos el mediaController a una vista
        mediaController.setAnchorView(video);

        //Asignamos el mediaController al videoView
        video.setMediaController(mediaController);

        //Seteamos el uri de nuestro vídeo
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/raw/" + R.raw.demovideo);

        video.setVideoURI(videoUri);

        //Iniciamos el vídeo
        video.start();
    }
}