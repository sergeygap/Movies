package com.gap.movies.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Logo implements Serializable {
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
