package com.example.gapp.controler;

import com.example.gapp.model.CarItem;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CarApiRest {
    @GET("data.json")
    Call<List<CarItem>> getListCar();
}
