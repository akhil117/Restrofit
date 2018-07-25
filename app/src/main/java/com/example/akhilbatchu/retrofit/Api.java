package com.example.akhilbatchu.retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;
public class Api {
    private static Retrofit retrofit = null;
    public static final String url = "http://api.themoviedb.org/3/";
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
