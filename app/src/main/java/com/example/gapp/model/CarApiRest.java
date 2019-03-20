package com.example.gapp.model;

import com.example.gapp.view.CarItem;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CarApiRest {
    @GET("data.json")
    Call<List<CarItem>> getListCar();
}
