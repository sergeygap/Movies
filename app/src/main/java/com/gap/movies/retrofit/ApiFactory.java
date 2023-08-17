package com.gap.movies.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {
    private static final String BASE_URL = "https://api.kinopoisk.dev/v1.3/";

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())//чтобы json переделывать в data
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // чтобы код был ассинхронным
            .build();

    public static final ApiService apiService = retrofit.create(ApiService.class); // Singleton

}
