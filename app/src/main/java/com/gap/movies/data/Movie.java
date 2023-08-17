package com.gap.movies.data;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("year")
    private String year;
    @SerializedName("rating")
    private Rating rating;
    @SerializedName("logo")
    private Logo logo;

    public Movie(int id, String name, String description, String year, Rating rating, Logo logo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.year = year;
        this.rating = rating;
        this.logo = logo;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getYear() {
        return this.year;
    }

    public Rating getRating() {
        return rating;
    }

    public Logo getLogo() {
        return logo;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", year='" + year + '\'' +
                ", rating=" + rating +
                ", logo=" + logo +
                '}';
    }
}
