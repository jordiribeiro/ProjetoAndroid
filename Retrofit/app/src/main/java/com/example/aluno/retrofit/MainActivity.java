package com.example.aluno.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.example.aluno.retrofit.dominio.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("teste","iniciando...");
        //Retrofit
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        Log.i("teste","objeto retrofit criado...");
        ApiEndpoint apiService = retrofit.create(ApiEndpoint.class);
        Log.i("teste","chamando api...");
        Call<Post> call = apiService.obtersuario(2);
        //chamada assíncrona
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                int statusCode = response.code();
                Post user = response.body();
                Log.i("teste","statuscode: " + statusCode);
                Log.i("teste", "Cidade do usuário: " + user.getAddress().getCity());
                ((TextView) findViewById(R.id.resp)).setText(user.getAddress().getCity()+"-"+statusCode);
            }
            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                // Log error here since request failed
                Log.i("teste",t.toString());
            }
        });
    }


}
