package com.kotlin.jetpackexample.repository;

import androidx.lifecycle.MutableLiveData;

import com.kotlin.jetpackexample.model.Movie;
import com.kotlin.jetpackexample.network.MoviesApi;
import com.kotlin.jetpackexample.network.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private static MovieRepository movieRepository;
    private MoviesApi moviesApi;


    public static MovieRepository getInstance() {
        if (movieRepository == null) {
            movieRepository = new MovieRepository();
        }
        return movieRepository;
    }

    public MovieRepository() {
        moviesApi = RetrofitService.getClient().create(MoviesApi.class);
    }

    public MutableLiveData<Movie> getMovies() {
        MutableLiveData<Movie> moviesResponse = new MutableLiveData<>();
        moviesApi.getMovieList().enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful()) {
                    moviesResponse.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                moviesResponse.setValue(null);
            }
        });
        return moviesResponse;
    }

}
