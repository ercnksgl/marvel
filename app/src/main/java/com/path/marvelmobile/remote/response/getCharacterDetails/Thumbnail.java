package com.path.marvelmobile.remote.response.getCharacterDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thumbnail {

    @Expose
    @SerializedName("path")
    private String path;

    @Expose
    @SerializedName("extension")
    private String extension;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
