package com.example.crudandroidspring.Utils;

import com.example.crudandroidspring.Models.PresionArterial;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PresionService {

    @GET("presion/")
    Call<List<PresionArterial>> getPresion();

    @POST("presion/save")
    Call<PresionArterial> addPresion(@Body PresionArterial presionArterial);

    @POST("edit/{id}")
    Call<PresionArterial>updatePresion(@Path("id") int id, @Body PresionArterial persona);

    @POST("eliminar/{id}")
    Call<PresionArterial>deletePresion(@Path("id")int id);
}
