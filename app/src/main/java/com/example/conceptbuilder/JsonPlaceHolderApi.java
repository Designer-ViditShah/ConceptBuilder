package com.example.conceptbuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

//this interface is used to communicate with the Http link
public interface JsonPlaceHolderApi {

//    posts is the end portion of the base URL
    @GET("posts")
    Call<List<Post>> getPosts();

//    photos is the end portion of the base URL
    @GET("photos")
    Call<List<Photo>> getPhotos();
}
