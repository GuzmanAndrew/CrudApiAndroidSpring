package com.example.crudandroidspring.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Clients {

    public static Retrofit getPresion(String url) {
        Retrofit retrofit  = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
