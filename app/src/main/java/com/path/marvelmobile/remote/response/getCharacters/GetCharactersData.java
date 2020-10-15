package com.path.marvelmobile.remote.response.getCharacters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetCharactersData {

    @Expose
    @SerializedName("results")
    private List<GetCharactersResult> results;

    public List<GetCharactersResult> getResults() {
        return results;
    }

    public void setResults(List<GetCharactersResult> results) {
        this.results = results;
    }
}
