package com.example.conceptbuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

//    posts inside get method is the string that will be added to the base URL to fetch the data
    @GET("posts")
    Call<List<Post>> getPosts();
}
