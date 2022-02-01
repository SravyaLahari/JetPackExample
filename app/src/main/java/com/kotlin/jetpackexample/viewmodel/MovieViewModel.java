package com.kotlin.jetpackexample.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kotlin.jetpackexample.model.Movie;
import com.kotlin.jetpackexample.repository.MovieRepository;

public class MovieViewModel extends ViewModel {

    private MutableLiveData<Movie> movieData;
    private MovieRepository movieRepository;

    public void init() {
        if (movieData != null) {
            return;
        }
        movieRepository = MovieRepository.getInstance();
        movieData = movieRepository.getMovies();
    }

    public LiveData<Movie> getMovieRepository() {
        return movieData;
    }

}
