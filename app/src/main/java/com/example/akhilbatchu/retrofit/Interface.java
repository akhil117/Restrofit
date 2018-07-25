package com.example.akhilbatchu.retrofit;

import android.graphics.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Interface {
    @GET("tv/top_rated")
    Call<Movies> getTopRatedMovies(@Query("api_key") String apiKey);
}
