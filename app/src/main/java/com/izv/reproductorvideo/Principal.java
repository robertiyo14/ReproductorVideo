package com.izv.reproductorvideo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;


public class Principal extends Activity {

    private static final int ACCION_VIDEO=1;
    VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Intent intent = getIntent();
        Uri data = intent.getData();
//        File archivo = new File(Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_MOVIES) +"/video.mp4");
//        Uri videoUri = Uri.fromFile(archivo);
        vv = (VideoView) findViewById(R.id.vv);
        vv.setVideoURI(data);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(vv);
        vv.setMediaController(mediaController);
        vv.start();
    }

    public void play(View v){
        vv.start();
    }

    public void stop(View v){
    }

    public void pause(View v){
        vv.pause();
    }

}
