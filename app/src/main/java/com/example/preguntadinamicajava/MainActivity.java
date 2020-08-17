package com.example.preguntadinamicajava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.widget.Toast;

import com.example.preguntadinamicajava.api.Api;
import com.example.preguntadinamicajava.api.RetrofitClient;
import com.example.preguntadinamicajava.beans.PreguntasLista;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("creacion", "se ha creado la actividad");

        Api mservice = RetrofitClient.getRetrofitInstance().create(Api.class);
        Call<PreguntasLista> mCall = mservice.getAllQuestions();


        mCall.enqueue(new Callback<PreguntasLista>() {
            @Override
            public void onResponse(Call<PreguntasLista> mCall, Response<PreguntasLista> response) {
                if(response != null) {
                    Log.i("respuestaonreponse", response.toString());
                    for(int x = 0; x < response.body().getResults().size(); x++)
                    {

                        Log.d("despuesif", response.body().getResults().get(x).getQuestion());
                    }
                }
        }
            @Override
            public void onFailure(Call<PreguntasLista> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error: no pudimos recuperar los datos de opentdb",
                        Toast.LENGTH_SHORT).show();
            }
            });
        }}

