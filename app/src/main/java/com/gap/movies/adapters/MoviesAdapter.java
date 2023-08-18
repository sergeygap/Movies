package com.gap.movies.adapters;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gap.movies.R;
import com.gap.movies.data.Movie;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {


    private List<Movie> moviesList = new ArrayList<>();
    private OnReachEndListener onReachEndListener;

    public void setOnReachEndListener(OnReachEndListener onReachEndListener) {
        this.onReachEndListener = onReachEndListener;
    }


    @SuppressLint("NotifyDataSetChanged")
    public void setMovies(List<Movie> movies) {
        this.moviesList = movies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.movie_item,
                parent,
                false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Log.d("MoviesAdapter", "onBindViewHolder: " + position);
        Movie movie = moviesList.get(position);
        if (movie.getLogo() != null) {
            Glide.with(holder.itemView)
                    .load(movie.getLogo().getUrl())
                    .into(holder.imageViewLogo);
        } else {
            Glide.with(holder.itemView)
                    .load(R.drawable.ic_launcher_foreground)
                    .into(holder.imageViewLogo);
        }

        double rating = movie.getRating().getKp();
        int backgroundId;
        if (rating > 7) {
            backgroundId = R.drawable.circle_green;
        } else if (rating > 5) {
            backgroundId = R.drawable.circle_orange;
        } else {
            backgroundId = R.drawable.circle_red;
        }
        holder.textViewRating.setBackgroundResource(backgroundId);
        holder.textViewRating.setText(String.valueOf(rating).substring(0, 3));

        if (position == moviesList.size() - 1 && onReachEndListener != null) {
            onReachEndListener.onReachEnd();
        }

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public interface OnReachEndListener {
        void onReachEnd();
    }


    static class MovieViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageViewLogo;
        private final TextView textViewRating;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewLogo = itemView.findViewById(R.id.imageViewLogo);
            textViewRating = itemView.findViewById(R.id.textViewRating);
        }
    }

}
