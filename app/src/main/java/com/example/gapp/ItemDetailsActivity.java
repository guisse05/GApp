package com.example.gapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ItemDetailsActivity extends AppCompatActivity {
TextView textView =findViewById(R.id.detail_text);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        String value = getIntent().getStringExtra("itemName");
        textView.setText(value);
    }
}
