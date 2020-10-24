package com.example.proyectobase;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Info_act extends AppCompatActivity {
    private VideoView videoV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);

        videoV = (VideoView)findViewById(R.id.vd);

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.videoinfo;

        Uri uri = Uri.parse(ruta);

        videoV.setVideoURI(uri);

        MediaController media = new MediaController(this);
        videoV.setMediaController(media);
    }
}