package com.kotlin.jetpackexample.network;

import com.kotlin.jetpackexample.model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesApi {

    @GET("movielist.json")
    Call<Movie> getMovieList();
}

