package com.example.zomatosearch.data.network;

import com.example.zomatosearch.data.network.models.RestaurantSearchResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiInterface {
    @GET("/api/v2.1/search")
    Call<RestaurantSearchResponse> doZomatoSearch(@QueryMap Map<String, String> params);
}