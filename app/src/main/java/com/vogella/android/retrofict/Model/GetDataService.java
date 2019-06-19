package com.vogella.android.retrofict.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface GetDataService {

    @GET("/posts")
    Call<List<RetroPhoto>> getAllPhotos();

    @POST("/posts")
    @FormUrlEncoded
    Call<RetroPhoto> savePost(@Field("title") String title,
                        @Field("body") String body,
                        @Field("userId") long userId);

    @PUT("/posts/{id}")
    @FormUrlEncoded
    Call<RetroPhoto> updatePost(@Path("id") long id,
                          @Field("title") String title,
                          @Field("body") String body,
                          @Field("userId") long userId);

    @DELETE("/posts/{id}")
    Call<RetroPhoto> deletePost(@Path("id") long id);
}
