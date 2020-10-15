package com.path.marvelmobile.remote.response.getCharacters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetCharactersResult {

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("thumbnail")
    private Thumbnail thumbnail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }
}
