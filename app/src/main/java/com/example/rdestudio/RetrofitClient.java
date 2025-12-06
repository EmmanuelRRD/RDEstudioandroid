package com.example.rdestudio;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    //sirve para consumir apis y Get,Post, Delete, Put y convertir de json a clases java

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {//Singleton de retrofit
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

