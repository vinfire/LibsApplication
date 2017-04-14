package com.example.gtr.libsapplication.retrofit;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by GTR on 2017/4/12.
 */

public interface MyService {
    @GET("/")  //里面写网址下的子目录
    Call<String> getBaidu();

    @POST("/")
    @FormUrlEncoded
    Call<String> postBsidu();
}
