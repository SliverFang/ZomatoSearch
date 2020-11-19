package com.example.zomatosearch.data;


import com.example.zomatosearch.data.network.ApiHelper;
import com.example.zomatosearch.data.network.AppApiHelper;
import com.example.zomatosearch.data.network.models.RestaurantSearchResponse;

import retrofit2.Callback;

public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private static ApiHelper mApiHelper;

    public AppDataManager()
    {
        mApiHelper=new AppApiHelper();
    }

    @Override
    public void searchZomato(Callback<RestaurantSearchResponse> callback, String query) {
        mApiHelper.searchZomato(callback,query);
    }
}
