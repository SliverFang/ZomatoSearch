package com.example.zomatosearch.data.network;


import com.example.zomatosearch.data.network.models.RestaurantSearchResponse;

import retrofit2.Callback;

public interface ApiHelper {
    public void searchZomato(final Callback<RestaurantSearchResponse> callback, String query);
}
