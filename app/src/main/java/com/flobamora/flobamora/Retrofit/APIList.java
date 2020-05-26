package com.flobamora.flobamora.Retrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIList {
    @GET("flobamora")
    Call<ArrayList<Flobamora>> getAllFlobamora_Data();
}
