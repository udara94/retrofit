package com.vogella.android.retrofict.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetDataService {

    @GET("/posts")
    Call<List<RetroPhoto>> getAllPhotos();

    @POST("/posts")
    @FormUrlEncoded
    Call<RetroPhoto> savePost(@Field("title") String title,
                        @Field("body") String body,
                        @Field("userId") long userId);
}
