package com.gap.movies.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainResponse {
    @SerializedName("docs")// позволяет считывать поле с json, если названо как-то иначе
    private List<Movie> movies;

    public MainResponse(List<Movie> movie) {
        this.movies = movie;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "MainResponse{" +
                "movies=" + movies +
                '}';
    }
}
