package com.path.marvelmobile.remote.response.getCharacterDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetCharacterDetailsResponseBody {


    @Expose
    @SerializedName("data")
    private GetCharacterDetailsData data;

    @Expose
    @SerializedName("code")
    private int code;

    public GetCharacterDetailsData getData() {
        return data;
    }

    public void setData(GetCharacterDetailsData data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
