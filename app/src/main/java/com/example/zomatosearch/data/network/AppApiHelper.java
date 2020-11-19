
package com.example.zomatosearch.data.network;

import android.util.Log;

import com.example.zomatosearch.data.network.models.RestaurantSearchResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;

public class AppApiHelper implements ApiHelper {

    static Call<RestaurantSearchResponse> call;
    @Override
    public void searchZomato(final Callback<RestaurantSearchResponse> callback, String query) {

        HashMap<String,String> q=new HashMap<>();
        q.put("q",query);
        ApiInterface apiInterface = ApiClient.getApiClinet().create(ApiInterface.class);
        if(call!=null)
        {
            call.cancel();
        }
        call = apiInterface.doZomatoSearch(q);
        call.enqueue(callback);
    }
}

