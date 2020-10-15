package com.path.marvelmobile.remote.response.getCharacterComics;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetCharacterComicsData {

    @Expose
    @SerializedName("results")
    private List<GetCharacterComicsResult> results;

    public List<GetCharacterComicsResult> getResults() {
        return results;
    }

    public void setResults(List<GetCharacterComicsResult> results) {
        this.results = results;
    }
}
