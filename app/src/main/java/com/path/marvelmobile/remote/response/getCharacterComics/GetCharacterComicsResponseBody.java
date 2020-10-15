package com.path.marvelmobile.remote.response.getCharacterComics;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetCharacterComicsResponseBody {


    @Expose
    @SerializedName("data")
    private GetCharacterComicsData data;

    @Expose
    @SerializedName("code")
    private int code;

    public GetCharacterComicsData getData() {
        return data;
    }

    public void setData(GetCharacterComicsData data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
