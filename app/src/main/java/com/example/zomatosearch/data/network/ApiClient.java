package com.example.zomatosearch.data.network;


import android.util.Log;

import com.example.zomatosearch.data.AppDataManager;
import com.example.zomatosearch.utils.AppConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ApiClient {

    private static final String BASE_URL = "https://developers.zomato.com";
    private static Retrofit retrofit = null;


     static Retrofit getApiClinet() {

        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request newRequest;
                newRequest  = chain.request().newBuilder()
                        .addHeader("user_key", AppConstants.ZOMATO_API_KEY)
                        .build();
                return chain.proceed(newRequest);
            }
        });


        OkHttpClient client = builder.build();

        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        return retrofit;
    }
}
