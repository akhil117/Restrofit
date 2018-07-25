package com.example.akhilbatchu.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private final static String API_KEY = "b69f521299ab171bcbce76d4d2d80e05";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (API_KEY.isEmpty()) {
            Log.i("Insert","Apikey");
            return;
        }
        Interface service = Api.getClient().create(Interface.class);
        Call<Movies> call =  service.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies>call, Response<Movies> response) {
                List<Result> movies = response.body().getResults();
                Log.d(TAG, "Number of movies received: " + movies.size() );
            }

            @Override
            public void onFailure(Call<Movies>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());

            }
        });


    }
}
