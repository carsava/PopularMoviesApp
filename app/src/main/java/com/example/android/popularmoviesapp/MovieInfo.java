package com.example.android.popularmoviesapp;

public class MovieInfo {
    public String name;
    public String author;
    public int resourceImage;
    public String url;

    public MovieInfo(String name, String author, int resourceImage, String url){
        this.name = name;
        this.author = author;
        this.resourceImage = resourceImage;
        this.url = url;
    }
}
