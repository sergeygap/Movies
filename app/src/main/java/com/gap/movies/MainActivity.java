package com.gap.movies;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.gap.movies.data.Movie;

import java.util.List;

import io.reactivex.rxjava3.internal.operators.maybe.MaybeUnsafeCreate;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivityResponse";
    private  MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.getMovie().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                Log.d(TAG, movies.toString());
            }
        });

        mainViewModel.loadMovies();

    }
}