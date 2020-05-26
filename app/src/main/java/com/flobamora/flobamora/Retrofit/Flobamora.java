package com.flobamora.flobamora.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Flobamora {
    @SerializedName("Category")
    private String Category;
    @SerializedName("dataImage")
    private String dataImage;
    @SerializedName("dataName")
    private String dataName;
    @SerializedName("dataRating")
    private String dataRating;

    public Flobamora(String Category, String dataImage,String dataName,String dataRating) {
        this.Category = Category;
        this.dataImage = dataImage;
        this.dataName = dataName;
        this.dataRating = dataRating;
    }

    public String getCategory() {
        return Category;
    }

    public String getDataImage() {
        return dataImage;
    }

    public String getDataName() {
        return dataName;
    }

    public String getDataRating() {
        return dataRating;
    }
}
