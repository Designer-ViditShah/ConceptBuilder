package com.example.conceptbuilder;

import com.google.gson.annotations.SerializedName;

public class Post {
    private String title;
    private int userid;
    private int id;
    @SerializedName("body")
    private String subtitle;

    public String getTitle() {
        return title;
    }

    public int getUserid() {
        return userid;
    }

    public int getId() {
        return id;
    }

    public String getSubtitle() {
        return subtitle;
    }
}
