package com.gap.movies.retrofit;

import com.gap.movies.data.MainResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {
    // один запрос, возвращающий топ популярных фильмов
    @Headers({
            "Accept: application/json",
            "X-API-KEY: 5D96XZC-7XRMEGE-NGYBX3W-XWESWSB"
    })
    @GET("movie?&limit=5&field=rating.kp&search=7-10&sortField=votes.kp&sortType=-1")// изначально здесь было page = 5
    Single<MainResponse> loadMovies(@Query("page") int page);
}
