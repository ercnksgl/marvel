package com.path.marvelmobile.remote.response.getCharacters;

import com.google.gson.annotations.SerializedName;

public class GetCharactersResult {

    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
