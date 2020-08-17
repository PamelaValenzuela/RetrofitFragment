package com.example.preguntadinamicajava.api;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit mRetrofit;
    private static final String BASE_URL = "https://opentdb.com/";

    public static Retrofit getRetrofitInstance(){
if (mRetrofit== null){
    mRetrofit = new retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
        return mRetrofit;
    }
}
