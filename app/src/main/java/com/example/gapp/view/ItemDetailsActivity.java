package com.example.gapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gapp.R;

public class ItemDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        ImageView icon =findViewById(R.id.icon_detail);
        TextView textView =findViewById(R.id.detail_text);
        TextView description =findViewById(R.id.car_description);
        Bundle bundle=this.getIntent().getExtras();
        int pic=bundle.getInt("image");

        Intent intent = getIntent();
        String value = intent.getStringExtra("itemName");
        String value1 = intent.getStringExtra("itemDescription");
        icon.setImageResource(pic);
        textView.setText(value);
        description.setText(value1);

    }

}