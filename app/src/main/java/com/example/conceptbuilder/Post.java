package com.example.conceptbuilder;

import com.google.gson.annotations.SerializedName;

public class Post {
    // title is the key that is used in the json file to store the Title
    // subtitle is the key that is used in the json file to store the SubTitle
    private String title;
    @SerializedName("body")
    private String subtitle;

    public String getTitle() {
        return title;
    }
    public String getSubtitle() {
        return subtitle;
    }
}
