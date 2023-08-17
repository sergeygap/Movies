package com.gap.movies.data;

import com.google.gson.annotations.SerializedName;

public class Logo {
    @SerializedName("url")
    private String url;

    public Logo(String url){
        this.url = url;
    }

    public String getUrl() {
        return url;
    }


    @Override
    public String toString() {
        return "Logo{" +
                "url='" + url + '\'' +
                '}';
    }
}
