package com.example.gapp.view;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.gapp.R;
import com.example.gapp.controler.ListCarActivity;


public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.my_super_song);
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, ListCarActivity.class);
        startActivity(intent);
        mediaPlayer.start();
    }

}