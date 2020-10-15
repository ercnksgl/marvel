package com.path.marvelmobile.remote.response.getCharacters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetCharactersResponseBody {


    @Expose
    @SerializedName("data")
    private GetCharactersData data;

    @Expose
    @SerializedName("code")
    private int code;

    public GetCharactersData getData() {
        return data;
    }

    public void setData(GetCharactersData data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
