package com.example.gapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.gapp.R;

public class ItemDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
      TextView textView =findViewById(R.id.detail_text);
      TextView description =findViewById(R.id.car_description);
        Intent intent = getIntent();
        String value = intent.getStringExtra("itemName");
        String value1 = intent.getStringExtra("itemDescription");
        textView.setText(value);
        description.setText(value1);
    }
}