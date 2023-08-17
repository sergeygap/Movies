package com.gap.movies;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gap.movies.data.MainResponse;
import com.gap.movies.data.Movie;
import com.gap.movies.retrofit.ApiFactory;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    private static final String TAG = "MainViewModel";
    private final MutableLiveData<List<Movie>> movie = new MutableLiveData<>();
    private final CompositeDisposable composite = new CompositeDisposable();

    private int page = 1;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Movie>> getMovie() {
        return movie;
    }


    public void loadMovies() {
        Disposable disposable = ApiFactory.apiService
                .loadMovies(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MainResponse>() {
                    @Override
                    public void accept(MainResponse mainResponse) throws Throwable {
                        movie.setValue(mainResponse.getMovies());
                        page++;
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        Log.d(TAG, throwable.toString());
                    }
                });
        composite.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        composite.clear();
    }
}














