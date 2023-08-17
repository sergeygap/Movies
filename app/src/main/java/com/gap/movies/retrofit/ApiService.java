package com.gap.movies.retrofit;

import com.gap.movies.data.MainResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiService {
    // один запрос, возвращающий топ популярных фильмов
    @GET("movie?page=1&limit=40&token=5D96XZC-7XRMEGE-NGYBX3W-XWESWSB&field=rating.kp&search=7-10&sortField=votes.kp&sortType=-1")
    Single<MainResponse> loadMovies();
}
