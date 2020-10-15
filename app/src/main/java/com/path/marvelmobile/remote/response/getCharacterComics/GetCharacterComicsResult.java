package com.path.marvelmobile.remote.response.getCharacterComics;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.path.marvelmobile.remote.response.getCharacterDetails.Thumbnail;

public class GetCharacterComicsResult {

    @Expose
    @SerializedName("title")
    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
