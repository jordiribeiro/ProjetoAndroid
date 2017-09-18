package com.example.aluno.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import com.example.aluno.retrofit.dominio.Post;

public interface ApiEndpoint {

@GET("users/{id}")
Call<Post> obtersuario(@Path("id") int userID);

}