package com.renovavision.daggertwo.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alexmprog on 16.12.2015.
 */
public class Repository {

    @SerializedName("name")
    public String name;

    @SerializedName("description")
    public String description;

    @SerializedName("html_url")
    public String url;
}
