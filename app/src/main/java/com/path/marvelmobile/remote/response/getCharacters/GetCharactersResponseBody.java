package com.path.marvelmobile.remote.response.getCharacters;

import com.google.gson.annotations.SerializedName;

public class GetCharactersResponseBody {


    @SerializedName("result")
    private GetCharactersResult result;

    public GetCharactersResult getResult() {
        return result;
    }

    public void setResult(GetCharactersResult result) {
        this.result = result;
    }
}
