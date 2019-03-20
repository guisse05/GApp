package com.example.gapp.controler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import static com.example.gapp.R.layout.activity_main;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, ListCarActivity.class);
        startActivity(intent);
    }

}


