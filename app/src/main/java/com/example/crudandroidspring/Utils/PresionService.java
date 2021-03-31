package com.example.crudandroidspring.Utils;

import com.example.crudandroidspring.Models.PresionArterial;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PresionService {
    @GET("listar/")
    Call<List<PresionArterial>> getPresion();
}
