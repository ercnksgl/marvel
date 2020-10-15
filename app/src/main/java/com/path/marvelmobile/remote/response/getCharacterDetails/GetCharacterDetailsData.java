package com.path.marvelmobile.remote.response.getCharacterDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetCharacterDetailsData {

    @Expose
    @SerializedName("results")
    private List<GetCharacterDetailsResult> results;

    public List<GetCharacterDetailsResult> getResults() {
        return results;
    }

    public void setResults(List<GetCharacterDetailsResult> results) {
        this.results = results;
    }
}
