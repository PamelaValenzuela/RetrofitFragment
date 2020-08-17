package com.example.preguntadinamicajava.api;

import com.example.preguntadinamicajava.beans.PreguntasLista;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("api.php?amount=10&category=15&difficulty=easy")
    Call<PreguntasLista> getAllQuestions();
}
