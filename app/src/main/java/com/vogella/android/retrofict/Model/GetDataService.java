package com.vogella.android.retrofict.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/posts")
    Call<List<RetroPhoto>> getAllPhotos();
}
