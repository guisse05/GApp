package com.example.gapp.controler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gapp.ItemDetailsActivity;
import com.example.gapp.R;
import com.example.gapp.model.CarApiRest;
import com.example.gapp.view.CarItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListCarActivity extends AppCompatActivity {
    private RecyclerView shopListView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_car);

        // API Gson
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://guisse05.github.io/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CarApiRest carApiRest = retrofit.create(CarApiRest.class);
        Call<List<CarItem>> call = carApiRest.getListCar();
        call.enqueue(new Callback<List<CarItem>>() {
            @Override
            public void onResponse(Call<List<CarItem>> call, Response<List<CarItem>> response) {
                showList(response.body());

            }

            @Override
            public void onFailure(Call<List<CarItem>> call, Throwable t) {

            }
        });
    }
//get list view
        private void showList(List<CarItem> listToDisplay) {

            shopListView =  findViewById(R.id.shop_list);
            layoutManager = new LinearLayoutManager(this);
            shopListView.setLayoutManager(layoutManager);
            mAdapter = new CarItemAdapter(this, listToDisplay, new CarItemAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(CarItem item) {

                    Intent intent = new Intent(getApplicationContext(), ItemDetailsActivity.class);
                    intent.putExtra("itemName",item.getName());

                    startActivity(intent);


                }
            });
            shopListView.setAdapter(mAdapter);
        }
}