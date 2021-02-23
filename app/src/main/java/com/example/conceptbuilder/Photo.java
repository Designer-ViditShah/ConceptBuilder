package com.example.conceptbuilder;

import com.google.gson.annotations.SerializedName;

public class Photo
{
// thumbnailUrl is the key that is used in the json file to store the url
    @SerializedName("thumbnailUrl")
    private String thumbnailUrl;

// this function is used to return the string value from the json file
    public String getUrl() {
        return thumbnailUrl;
    }
}
