package com.gap.movies.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.gap.movies.R;
import com.gap.movies.data.Movie;

public class MovieDetailActivity extends AppCompatActivity {

    private static final String EXTRA_MOVIE = "movie";
    private ImageView imageViewPoster;
    private TextView textViewTitle;
    private TextView textViewYear;
    private TextView textViewDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        initViews();
        Movie movie = (Movie) getIntent().getSerializableExtra(EXTRA_MOVIE);

        if (movie != null) {
            if (movie.getLogo() != null) {
                Glide.with(this)
                        .load(movie.getLogo().getUrl())
                        .into(imageViewPoster);
            } else {
                Glide.with(this)
                        .load(R.drawable.ic_launcher_foreground)
                        .into(imageViewPoster);
            }
            Glide.with(this)
                    .load(movie.getLogo().getUrl())
                    .into(imageViewPoster);
            textViewTitle.setText(movie.getName());
            textViewYear.setText(String.valueOf(movie.getYear()));
            textViewDescription.setText(movie.getDescription());
        }
    }

    private void initViews() {
        imageViewPoster = findViewById(R.id.imageViewPoster);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewYear = findViewById(R.id.textViewYear);
        textViewDescription = findViewById(R.id.textViewDescription);
    }

    public static Intent newIntent(Context context, Movie movie) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(EXTRA_MOVIE, movie);
        return intent;
    }

}










